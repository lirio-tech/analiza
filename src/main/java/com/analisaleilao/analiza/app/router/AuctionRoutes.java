package com.analisaleilao.analiza.app.router;

import com.analisaleilao.analiza.core.entity.Auction;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class AuctionRoutes {

    private static final String ROOT = "/auctions";

    @Bean
    public RouterFunction<ServerResponse> routesAction() {
        return RouterFunctions.route(RequestPredicates.GET(ROOT).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), this::get);
    }

    private Mono<ServerResponse> get(ServerRequest request) {
        var list = List.of(new Auction(ObjectId.get(), "Mogilar - Mogi das Cruzes - SP"));
        return ServerResponse.ok().bodyValue(list);
    }

}
