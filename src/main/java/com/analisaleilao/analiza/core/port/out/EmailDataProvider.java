package com.analisaleilao.analiza.core.port.out;

public interface EmailDataProvider {
    Boolean send(String email, int codeAuth);
}
