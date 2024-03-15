package com.analisaleilao.analiza.app.router.data;

public class AuthConfirmResponse {
    private final String hash;

    public AuthConfirmResponse(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }
}
