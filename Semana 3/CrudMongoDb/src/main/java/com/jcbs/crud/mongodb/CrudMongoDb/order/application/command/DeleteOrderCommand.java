package com.jcbs.crud.mongodb.CrudMongoDb.order.application.command;

public interface DeleteOrderCommand {

    void execute(String id);
}
