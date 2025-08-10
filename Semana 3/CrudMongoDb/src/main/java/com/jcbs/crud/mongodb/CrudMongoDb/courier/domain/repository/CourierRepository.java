package com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.repository;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.courierEnum.EnumCourierStatus;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {

    Courier save(Courier courier);

    Optional<Courier> findById(String id);

    List<Courier> findAll();

    List<Courier> findByStatus(EnumCourierStatus status);
}
