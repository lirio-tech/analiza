package com.analisaleilao.analiza.core.usecases;

import com.analisaleilao.analiza.core.dataproviders.repository.AuthUserRepository;
import com.analisaleilao.analiza.core.entity.AuthUserEntity;
import com.analisaleilao.analiza.core.port.in.LoginUserAuthenticatorConfirmInputPort;
import com.analisaleilao.analiza.core.usecases.exceptions.AuthValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class LoginUserAuthenticatorConfirmUsecase implements LoginUserAuthenticatorConfirmInputPort {

    private Logger log = LoggerFactory.getLogger(LoginUserAuthenticatorConfirmUsecase.class);
    private final AuthUserRepository authUserRepository;

    public LoginUserAuthenticatorConfirmUsecase(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public Mono<String> confirm(String email, Integer code) {
        return authUserRepository
            .findByEmailAndCodeAuth(email, code)
            .switchIfEmpty(Mono.error(new AuthValidationException("Autenticacao nao permitida, verifica o codigo enviado por email")))
            .map(auth -> {
                log.info("method=confirm, auth={}", auth);
                return auth.getId().toString();
            });
    }
}
