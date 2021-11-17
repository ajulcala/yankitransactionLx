package com.yanki.publisher.app.controllers;

import com.yanki.publisher.app.models.documents.MonederoTransaction;
import com.yanki.publisher.app.services.MonederoTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
@EnableBinding(Source.class)
@RestController
@RequestMapping("/publish")
public class MonederoTransactionController {
    @Autowired
    private MessageChannel output;

    @Autowired
    private MonederoTransactionService service;

    @GetMapping("/list")
    public Flux<MonederoTransaction> findAll(){
        return service.findAll();
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<MonederoTransaction>> create(@RequestBody MonederoTransaction monederoTransaction){
        monederoTransaction.setCreateAt(LocalDateTime.now());
        output.send(MessageBuilder.withPayload(monederoTransaction).build());
        return service.create(monederoTransaction)
                .map(ct -> new ResponseEntity<>(ct , HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
