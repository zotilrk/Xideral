package com.jcbs.crud.mongodb.CrudMongoDb.courier.infrastructure.rest;

import com.jcbs.crud.mongodb.CrudMongoDb.courier.application.command.CreateCourierCommand;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.application.query.GetCourierQuery;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.request.CreateCourierRequest;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response.GetCourierResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
public class CourierRestController {

    private CreateCourierCommand createCourierCommand;

    private GetCourierQuery getCourierQuery;

    @PostMapping
    public ResponseEntity<CreateCourierRequest> createCourier(
            @RequestBody CreateCourierRequest createCourierRequest) {

        createCourierCommand.execute(createCourierRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public ResponseEntity<GetCourierResponse> getCourier(
            @RequestParam String id) {

        GetCourierResponse courierResponse = getCourierQuery.query(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(courierResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetCourierResponse>> getAllCouriers() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(getCourierQuery.queryAll());
    }
}
