package com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderResponse {
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
