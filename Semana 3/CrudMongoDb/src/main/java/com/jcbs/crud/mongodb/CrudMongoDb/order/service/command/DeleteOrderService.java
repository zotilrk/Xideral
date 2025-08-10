package com.jcbs.crud.mongodb.CrudMongoDb.order.service.command;

import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.DeleteOrderCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrderService implements DeleteOrderCommand {

    private final OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public DeleteOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(String id) {

        if(orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Order with id " + id + " does not exist.");
        }
    }
}
