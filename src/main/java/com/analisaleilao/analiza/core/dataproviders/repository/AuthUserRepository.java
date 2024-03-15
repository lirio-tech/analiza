package com.analisaleilao.analiza.core.dataproviders.repository;

import com.analisaleilao.analiza.core.entity.AuthUser;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthUserRepository extends ReactiveCrudRepository<AuthUser, ObjectId> {
    Flux<AuthUser> findByEmail(String email);

    Mono<AuthUser> findByEmailAndCodeAuth(String email, Integer codeAuth);
}
