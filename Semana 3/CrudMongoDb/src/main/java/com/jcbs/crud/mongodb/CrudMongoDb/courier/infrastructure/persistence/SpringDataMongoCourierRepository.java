package com.jcbs.crud.mongodb.CrudMongoDb.courier.infrastructure.persistence;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoCourierRepository extends MongoRepository<Courier, String> {
}
