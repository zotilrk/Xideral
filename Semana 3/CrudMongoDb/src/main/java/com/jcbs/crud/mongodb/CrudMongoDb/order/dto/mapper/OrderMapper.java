package com.jcbs.crud.mongodb.CrudMongoDb.order.dto.mapper;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.Order;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest request);

    OrderResponse toOrderResponse(Order order);
}
