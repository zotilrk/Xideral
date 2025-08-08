package com.jcbs.crud.mongodb.CrudMongoDb.order.application.command;

import com.jcbs.crud.mongodb.CrudMongoDb.order.domain.model.OrderEnum.OrderEnum;

public interface UpdateStatusCommand {
    void execute(String id, OrderEnum status);
}
