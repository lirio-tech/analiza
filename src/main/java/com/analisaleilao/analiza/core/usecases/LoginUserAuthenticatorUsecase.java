package com.analisaleilao.analiza.core.usecases;

import com.analisaleilao.analiza.core.dataproviders.repository.AuthUserRepository;
import com.analisaleilao.analiza.core.entity.AuthUser;
import com.analisaleilao.analiza.core.port.out.EmailDataProvider;
import com.analisaleilao.analiza.core.port.in.LoginUserAuthenticatorInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Random;


@Service
class LoginUserAuthenticatorUsecase implements LoginUserAuthenticatorInputPort {

    private final Logger log = LoggerFactory.getLogger(LoginUserAuthenticatorUsecase.class);
    private final Random random = new Random();
    private final EmailDataProvider emailDataProvider;
    private final AuthUserRepository authUserRepository;

    public LoginUserAuthenticatorUsecase(EmailDataProvider emailDataProvider, AuthUserRepository authUserRepository) {
        this.emailDataProvider = emailDataProvider;
        this.authUserRepository = authUserRepository;
    }

    @Override
    public Mono<Boolean> auth(String email) {
        log.info("email={}", email);
        int codeAuth = random.nextInt(10_000, 99_999);
        emailDataProvider.send(email, codeAuth);
        return authUserRepository
                .save(new AuthUser(email, codeAuth))
                .map(s -> s.getId() != null)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
