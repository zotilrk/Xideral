package com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.mapper;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.request.CreateCourierRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response.GetCourierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier toCourier(CreateCourierRequest request);

    @Mapping(target = "status", source = "status")
    GetCourierResponse toGetCourierResponse(Courier courier);
}
