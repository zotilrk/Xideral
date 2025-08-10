package com.jcbs.crud.mongodb.CrudMongoDb.courier.application.query;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response.GetCourierResponse;

import java.util.List;

public interface GetCourierQuery {

    GetCourierResponse query(String id);

    List<GetCourierResponse> queryAll();
}
