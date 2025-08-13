package com.tuempresa.batch.mapping;


import com.tuempresa.batch.domain.mongo.CustomerDoc;
import com.tuempresa.batch.domain.postgres.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(target = "fullName", expression = "java(fullName(c.getFirstName(), c.getLastName()))")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "active", expression = "java(mapStatusToActive(c.getStatus()))")
    @Mapping(target = "emailDomain", expression = "java(extractEmailDomain(c.getEmail()))")
    CustomerDoc toDoc(CustomerEntity c);

    default String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    default boolean mapStatusToActive(String status) {
        return "ACTIVE".equalsIgnoreCase(status);
    }

    default String extractEmailDomain(String email) {
        if (email == null || !email.contains("@")) return "";
        return email.substring(email.indexOf("@") + 1);
    }

}
