package com.jcbs.crud.mongodb.CrudMongoDb.courier.infrastructure.persistence;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourierMongoRepository implements CourierRepository {

    @Autowired
    private SpringDataMongoCourierRepository springRepo;

    @Override
    public Courier save(Courier courier) {
        return springRepo.save(courier);
    }

    @Override
    public Optional<Courier> findById(String id) {
        return springRepo.findById(id);
    }

    @Override
    public List<Courier> findAll() {
        return springRepo.findAll();
    }
}
