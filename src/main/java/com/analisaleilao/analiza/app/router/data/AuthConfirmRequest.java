package com.analisaleilao.analiza.app.router.data;

public class AuthConfirmRequest {

    private String email;
    private Integer code;

    public AuthConfirmRequest() {}

    public AuthConfirmRequest(String email, Integer code) {
        this.email = email;
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
