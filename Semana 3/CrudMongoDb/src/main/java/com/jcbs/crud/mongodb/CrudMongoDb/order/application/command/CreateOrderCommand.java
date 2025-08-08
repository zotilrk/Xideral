package com.jcbs.crud.mongodb.CrudMongoDb.order.application.command;

import com.jcbs.crud.mongodb.CrudMongoDb.order.dto.request.OrderRequest;

public interface CreateOrderCommand {

    void execute(OrderRequest request);
}
