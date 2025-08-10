package com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest request);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "deliveredAt", target = "deliveredAt")
    @Mapping(source = "courierId", target = "courierId")
    OrderResponse toOrderResponse(Order order);
}
