package com.yanki.publisher.app.services.impl;

import com.yanki.publisher.app.models.dao.MonederoTransactionDao;
import com.yanki.publisher.app.models.documents.MonederoTransaction;
import com.yanki.publisher.app.services.MonederoTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MonederoTransactionServiceImpl implements MonederoTransactionService {
    @Autowired
    MonederoTransactionDao dao;

    @Override
    public Flux<MonederoTransaction> findAll() {
        log.info("Listar");
        return dao.findAll();
    }

    @Override
    public Mono<MonederoTransaction> findById(String id) {
        log.info("Busacar por id");
        return dao.findById(id);
    }

    @Override
    public Mono<MonederoTransaction> create(MonederoTransaction monederoTransaction) {
        log.info("Guardar transaccion");
        return dao.save(monederoTransaction);
    }
}
