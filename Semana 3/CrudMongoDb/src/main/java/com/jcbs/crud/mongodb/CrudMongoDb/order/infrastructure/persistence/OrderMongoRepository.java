package com.jcbs.crud.mongodb.CrudMongoDb.order.infrastructure.persistence;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderMongoRepository implements OrderRepository {

    private final SpringDataMongoOrderRepository springRepo;

    public OrderMongoRepository(SpringDataMongoOrderRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public Order save(Order order) {
        return springRepo.save(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return springRepo.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return springRepo.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return springRepo.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        springRepo.deleteById(id);
    }


}
