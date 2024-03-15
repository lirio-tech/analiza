package com.analisaleilao.analiza.core.dataproviders.smtp;

import com.analisaleilao.analiza.core.port.out.EmailDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailDataProviderSmtp implements EmailDataProvider {

    @Autowired
    private JavaMailSender emailSender;
    private SimpleMailMessage message = new SimpleMailMessage();

    @Override
    public Boolean send(String email, int codeAuth) {
        this.send(email, "Codigo de Autenticacao - Analisa Leilao", codeAuth+"");
        return true;
    }

    public void send(String to, String subject, String text) {
        message.setFrom("no-reply@analisaleilao.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
