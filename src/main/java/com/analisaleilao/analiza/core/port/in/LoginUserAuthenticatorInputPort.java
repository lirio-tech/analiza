package com.analisaleilao.analiza.core.port;

import reactor.core.publisher.Mono;

public interface LoginUserAuthenticatorInputPort {


    Mono<Boolean> auth(String email);
}
