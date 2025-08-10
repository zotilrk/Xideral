package com.jcbs.crud.mongodb.CrudMongoDb.courier.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jcbs.crud.mongodb.CrudMongoDb.courier.domain.model.courierEnum.EnumCourierStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetCourierResponse {

    private String name;
    private String phone;
    private String vehicleType;
    private EnumCourierStatus status;
    private Double rating;
}
