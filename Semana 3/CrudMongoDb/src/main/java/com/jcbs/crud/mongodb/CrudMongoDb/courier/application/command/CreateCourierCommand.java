package com.jcbs.crud.mongodb.CrudMongoDb.courier.application.command;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.request.CreateCourierRequest;

public interface CreateCourierCommand {

    void execute(CreateCourierRequest request);
}
