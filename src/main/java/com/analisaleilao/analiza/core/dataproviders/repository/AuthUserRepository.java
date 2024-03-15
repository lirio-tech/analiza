package com.analisaleilao.analiza.core.dataproviders.repository;

import com.analisaleilao.analiza.core.entity.AuthUserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthUserRepository extends ReactiveCrudRepository<AuthUserEntity, ObjectId> {
    Flux<AuthUserEntity> findByEmail(String email);

    Mono<AuthUserEntity> findByEmailAndCodeAuth(String email, Integer codeAuth);
}
