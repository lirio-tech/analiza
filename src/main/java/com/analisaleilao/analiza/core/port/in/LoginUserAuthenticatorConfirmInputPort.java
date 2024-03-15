package com.analisaleilao.analiza.core.port.in;

import reactor.core.publisher.Mono;

public interface LoginUserAuthenticatorConfirmInputPort {

    Mono<String> confirm(String email, Integer code);
}
