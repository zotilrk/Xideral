package com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository;


import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findById(String id);
    List<Order> findAll();

    boolean existsById(String id);

    void deleteById(String id);
}
