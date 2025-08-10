package com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model;


import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.courierEnum.EnumCourierStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "couriers")
public class Courier {

    @Id
    private String id;

    private String name;
    private String phone;
    private String vehicleType;
    private EnumCourierStatus status;
    private Double rating;
    private LocalDateTime createdAt;
}
