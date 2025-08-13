package com.tuempresa.batch.domain.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDocRepository extends MongoRepository<CustomerDoc, String> {
}

