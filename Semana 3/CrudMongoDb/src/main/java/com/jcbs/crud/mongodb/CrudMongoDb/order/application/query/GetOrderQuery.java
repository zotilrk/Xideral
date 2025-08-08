package com.jcbs.crud.mongodb.CrudMongoDb.order.application.query;

import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface GetOrderQuery {

    OrderResponse query(String id);

    List<OrderResponse> queryAll();
}
