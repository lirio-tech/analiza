package com.analisaleilao.analiza.app.router;

import com.analisaleilao.analiza.app.router.data.AuthConfirmRequest;
import com.analisaleilao.analiza.app.router.data.AuthConfirmResponse;
import com.analisaleilao.analiza.app.router.data.AuthRequest;
import com.analisaleilao.analiza.core.port.in.LoginUserAuthenticatorConfirmInputPort;
import com.analisaleilao.analiza.core.port.in.LoginUserAuthenticatorInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class UserAuthenticatorRoute {

    private final UserAuthenticatorHandle handler;

    public UserAuthenticatorRoute(UserAuthenticatorHandle handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> routeAuth() {
        String ROOT = "/auth";
        return RouterFunctions
                .route(POST(ROOT).and(accept(MediaType.APPLICATION_JSON)), handler::auth)
                .andRoute(POST(ROOT.concat("/confirm")).and(accept(MediaType.APPLICATION_JSON)), handler::authConfirm)
                ;
    }

    @Component
    public static class UserAuthenticatorHandle {

        private final LoginUserAuthenticatorInputPort login;
        private final LoginUserAuthenticatorConfirmInputPort confirm;

        public UserAuthenticatorHandle(LoginUserAuthenticatorInputPort login, LoginUserAuthenticatorConfirmInputPort confirm) {
            this.login = login;
            this.confirm = confirm;
        }

        public Mono<ServerResponse> auth(ServerRequest request) {
            return request.bodyToMono(AuthRequest.class)
                    .flatMap(authRequest -> login.auth(authRequest.getEmail()))
                    .flatMap(result -> ServerResponse.noContent().build());
        }

        public Mono<ServerResponse> authConfirm(ServerRequest request) {
            return request.bodyToMono(AuthConfirmRequest.class)
                    .flatMap(authRequest -> confirm.confirm(authRequest.getEmail(), authRequest.getCode()))
                    .flatMap(result -> ServerResponse.ok().bodyValue(new AuthConfirmResponse(result)));
        }

    }

}
