package com.analisaleilao.analiza.app.config;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Profile("test")
@Configuration
public class EmailConfig {
    @Bean
    @Primary
    public JavaMailSender javaMailSender() {
        JavaMailSender javaMailSender = Mockito.mock(JavaMailSender.class);
        Mockito.when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        return javaMailSender;
    }
}
