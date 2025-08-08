package com.jcbs.crud.mongodb.CrudMongoDb.order.service.command;

import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.CreateOrderCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper.OrderMapper;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateOrderService implements CreateOrderCommand {

    private final OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(OrderRequest request) {

        Order order = orderMapper.toOrder(request);
        //Add logic to assign a courier if there are someone available

        //Add logic to change status if the order is assigned to a courier
        order.setStatus(OrderEnum.ASSIGNED);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);

    }
}
