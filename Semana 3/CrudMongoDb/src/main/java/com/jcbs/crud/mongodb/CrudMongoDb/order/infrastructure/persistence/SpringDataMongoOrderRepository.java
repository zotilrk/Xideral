package com.jcbs.crud.mongodb.CrudMongoDb.order.infrastructure.persistence;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SpringDataMongoOrderRepository extends MongoRepository<Order, String> {
}
