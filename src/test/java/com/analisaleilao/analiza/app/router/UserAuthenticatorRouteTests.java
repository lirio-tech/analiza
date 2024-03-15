package com.analisaleilao.analiza.app.router;

import com.analisaleilao.analiza.AnalizaApplication;
import com.analisaleilao.analiza.TestAnalizaApplication;
import com.analisaleilao.analiza.app.router.data.AuthConfirmRequest;
import com.analisaleilao.analiza.app.router.data.AuthRequest;
import com.analisaleilao.analiza.core.dataproviders.repository.AuthUserRepository;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.testcontainers.shaded.org.bouncycastle.asn1.x500.style.RFC4519Style.c;

@SpringBootTest(classes = AnalizaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestAnalizaApplication.class)
@ActiveProfiles("test")
public class UserAuthenticatorRouteTests {

    private static final String EMAIL = "diegolirio.dl@gmail.com";
    WebTestClient client;
    @Autowired
    private AuthUserRepository repository;

    @BeforeEach
    void setUp(ApplicationContext context) {
        client = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void test_login_send_email_code() {
        client.post().uri("/auth")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(new AuthRequest(EMAIL)), AuthRequest.class)
                .exchange()
                .expectStatus().isNoContent();

        repository.findByEmail(EMAIL)
                .count()
                .subscribe(c -> {
                    System.out.println(c);
                    Assertions.assertTrue(c > 0, "Code is not stored in Database");
                });

    }

    @Test
    public void test_login_confirm_email_code() {

        client.post().uri("/auth")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(new AuthRequest(EMAIL)), AuthRequest.class)
                .exchange()
                .expectStatus().isNoContent();

        Flux<Integer> fluxCode = repository
                .findByEmail(EMAIL)
                .map(au -> au.getCodeAuth());

        fluxCode
            .doOnNext(code -> {
                client.post().uri("/auth/confirm")
                        .accept(MediaType.APPLICATION_JSON)
                        .body(Mono.just(new AuthConfirmRequest(EMAIL, code)), AuthRequest.class)
                        .exchange()
                        .expectStatus().isNoContent();
            })
            .subscribe(c -> {
                System.out.println(c);
                Assertions.assertTrue(c != 0, "Confirm Code is not stored in Database");
            });


    }

}
