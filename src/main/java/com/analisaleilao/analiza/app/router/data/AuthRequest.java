package com.analisaleilao.analiza.app.router.data;

public class AuthRequest {

    public AuthRequest() {}

    public AuthRequest(String email) {
        this.email = email;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
