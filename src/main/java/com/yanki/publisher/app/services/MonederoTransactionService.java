package com.yanki.publisher.app.services;

import com.yanki.publisher.app.models.documents.MonederoTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonederoTransactionService {
    Flux<MonederoTransaction> findAll();
    Mono<MonederoTransaction> findById(String id);
    Mono<MonederoTransaction> create(MonederoTransaction monederoTransaction);
}
