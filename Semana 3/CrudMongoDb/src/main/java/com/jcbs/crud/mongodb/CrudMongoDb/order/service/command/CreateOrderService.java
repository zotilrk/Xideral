package com.jcbs.crud.mongodb.CrudMongoDb.order.service.command;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.courierEnum.EnumCourierStatus;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.repository.CourierRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.CreateOrderCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.repository.OrderRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper.OrderMapper;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class CreateOrderService implements CreateOrderCommand {

    private final OrderRepository orderRepository;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private OrderMapper orderMapper;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute(OrderRequest request) {

        Order order = orderMapper.toOrder(request);

        List<Courier> disponibles = courierRepository.findByStatus(EnumCourierStatus.DISPONIBLE);

        if (disponibles.isEmpty()) {
            throw new IllegalStateException("No hay repartidores disponibles para asignar el pedido.");
        }

        HashSet<Courier> courierSet = new HashSet<>(disponibles);
        List<Courier> randomList = new ArrayList<>(courierSet.stream().toList());
        Collections.shuffle(randomList);

        Courier asignado = randomList.get(0);


        order.setCourierId(asignado.getId());
        order.setStatus(OrderEnum.ASSIGNED);

        asignado.setStatus(EnumCourierStatus.OCUPADO);
        courierRepository.save(asignado);

        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);

    }
}
