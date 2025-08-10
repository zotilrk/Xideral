package com.jcbs.crud.mongodb.CrudMongoDb.courier.service.query;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.application.query.GetCourierQuery;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.Courier;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.repository.CourierRepository;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.mapper.CourierMapper;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response.GetCourierResponse;

import java.util.List;

public class GetCourierService implements GetCourierQuery {

    private CourierRepository courierRepository;
    private CourierMapper courierMapper;

    @Override
    public GetCourierResponse query(String id) {
        return courierRepository.findById(id)
                .map(courierMapper::toGetCourierResponse)
                .orElse(null);
    }

    @Override
    public List<GetCourierResponse> queryAll() {
        List<Courier> couriers = courierRepository.findAll();
        if (couriers == null || couriers.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return couriers.stream()
                .map(courierMapper::toGetCourierResponse)
                .toList();
    }
}
