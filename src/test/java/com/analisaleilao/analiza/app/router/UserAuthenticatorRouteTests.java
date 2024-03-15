package com.analisaleilao.analiza.app.controller;

import com.analisaleilao.analiza.AnalizaApplication;
import com.analisaleilao.analiza.TestAnalizaApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = AnalizaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestAnalizaApplication.class)
@ActiveProfiles("test")
public class UserAuthenticatorRouteTests {

    WebTestClient client;
    
    @BeforeEach
    void setUp(ApplicationContext context) {
        client = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void test_login_send_email_code() {
        client.get().uri("/auth")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);

    }

}
