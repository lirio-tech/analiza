package com.analisaleilao.analiza.core.port.in;

import reactor.core.publisher.Mono;

public interface LoginUserAuthenticatorInputPort {


    Mono<Boolean> auth(String email);
}
