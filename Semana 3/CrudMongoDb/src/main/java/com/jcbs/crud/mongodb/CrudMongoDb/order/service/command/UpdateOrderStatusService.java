package com.jcbs.crud.mongodb.CrudMongoDb.order.service.command;

import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.UpdateStatusCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class UpdateOrderStatusService implements UpdateStatusCommand {

    private final OrderRepository orderRepository;
    private OrderMapper orderMapper;

    private static final Map<OrderEnum, Predicate<OrderEnum>> VALID_TRANSITIONS = new EnumMap<>(OrderEnum.class);

    static {
        VALID_TRANSITIONS.put(OrderEnum.IN_PROGRESS, prev -> prev == OrderEnum.ASSIGNED);
        VALID_TRANSITIONS.put(OrderEnum.DELIVERED, prev -> prev == OrderEnum.IN_PROGRESS);
        VALID_TRANSITIONS.put(OrderEnum.CANCELLED, prev -> true);
        // Add other transitions if needed
    }

    public UpdateOrderStatusService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(String id, OrderEnum status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        OrderEnum currentStatus = order.getStatus();

        boolean isValid = VALID_TRANSITIONS.getOrDefault(status, prev -> false).test(currentStatus);

        if (!isValid) {
            throw new IllegalStateException(
                    String.format("Cannot change status from %s to %s", currentStatus, status)
            );
        }

        order.setStatus(status);
        orderRepository.save(order);

    }
}
