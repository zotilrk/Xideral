package com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String customerName;
    private String customerAddress;
    private String customerPhone;

    private String description;
    private Double price;
    private OrderEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime deliveredAt;

    private String courierId;
}
