package com.jcbs.crud.mongodb.CrudMongoDb.courier.service.command;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.application.command.CreateCourierCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.repository.CourierRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.mapper.CourierMapper;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.request.CreateCourierRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateCourierService implements CreateCourierCommand {

    @Autowired
    private CourierRepository courierRepository;
    private CourierMapper courierMapper;


    @Override
    public void execute(CreateCourierRequest request) {

        Courier courier = courierMapper.toCourier(request);
        courier.setRating(0.0);
        courier.setCreatedAt(LocalDateTime.now());
        courierRepository.save(courier);


    }
}
