package com.analisaleilao.analiza.app.controller;

import com.analisaleilao.analiza.AnalizaApplication;
import com.analisaleilao.analiza.TestAnalizaApplication;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = AnalizaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestAnalizaApplication.class)
@ActiveProfiles("test")
public class UserAuthenticatorRouteTests {


    @Test
    public void test_login_send_email_code() {
        // TODO webClient
    }

}
