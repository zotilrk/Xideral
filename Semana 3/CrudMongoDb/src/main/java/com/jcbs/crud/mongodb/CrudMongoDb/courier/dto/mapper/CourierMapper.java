package com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.mapper;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.request.CreateCourierRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response.GetCourierResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier toCourier(CreateCourierRequest request);

    GetCourierResponse toGetCourierResponse(Courier courier);
}
