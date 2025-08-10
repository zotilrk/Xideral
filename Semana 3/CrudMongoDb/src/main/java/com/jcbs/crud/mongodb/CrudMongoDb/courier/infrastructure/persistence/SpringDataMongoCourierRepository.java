package com.jcbs.crud.mongodb.CrudMongoDb.courier.infrastructure.persistence;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.courierEnum.EnumCourierStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataMongoCourierRepository extends MongoRepository<Courier, String> {

    // Custom query method to find couriers by their status
    List<Courier> findByStatus(EnumCourierStatus status);
}
