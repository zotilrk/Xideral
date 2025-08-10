package com.jcbs.crud.mongodb.CrudMongoDb.order.infrastructure.rest;

import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.CreateOrderCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.DeleteOrderCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.application.command.UpdateStatusCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.order.application.query.GetOrderQuery;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    private CreateOrderCommand createOrderCommand;

    @Autowired
    private GetOrderQuery getOrderQuery;

    @Autowired
    private UpdateStatusCommand updateStatusCommand;

    @Autowired
    private DeleteOrderCommand deleteOrderCommand;

    @PostMapping
    public ResponseEntity<OrderRequest> createOrder(
            @RequestBody OrderRequest orderRequest){

        createOrderCommand.execute(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public ResponseEntity<OrderResponse> getOrder(
            @RequestParam String id) {

        OrderResponse orderResponse = getOrderQuery.query(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(orderResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(getOrderQuery.queryAll());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void>updateStatus(
            @PathVariable String id,
            @RequestParam OrderEnum status
    ){

        updateStatusCommand.execute(id, status);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable String id
    ){
        deleteOrderCommand.execute(id);
        return ResponseEntity.noContent().build();
    }


}
