package com.yanki.publisher.app.models.dao;

import com.yanki.publisher.app.models.documents.MonederoTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MonederoTransactionDao extends ReactiveMongoRepository<MonederoTransaction, String> {
}
