package com.jcbs.crud.mongodb.CrudMongoDb.order.service.query;

import com.jcbs.crud.mongodb.CrudMongoDb.order.application.query.GetOrderQuery;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper.OrderMapper;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetOrderService implements GetOrderQuery {

    private final OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public GetOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse query(String id) {

        return orderRepository.findById(id)
                .map(orderMapper::toOrderResponse)
                .orElse(null);
    }

    @Override
    public List<OrderResponse> queryAll() {
        List<Order> orders = orderRepository.findAll();
        if (orders == null || orders.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return orders.stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }
}
