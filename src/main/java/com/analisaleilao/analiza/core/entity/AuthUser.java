package com.analisaleilao.analiza.core.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "authUsers")
public class AuthUser {

    @Id
    private ObjectId id;
    private String email;

    private int codeAuth;

    public AuthUser() {
    }

    public AuthUser(String email) {
        this.email = email;
    }

    public AuthUser(String email, int codeAuth) {
        this(email);
        this.codeAuth = codeAuth;
    }

    public ObjectId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getCodeAuth() {
        return codeAuth;
    }

    @Override
    public String toString() {
        return "AuthUserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", codeAuth=" + codeAuth +
                '}';
    }
}
