package com.tuempresa.batch.domain.postgres;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CustomerEntityTest {
    @Test
    void builderAndGettersWork() {
        CustomerEntity entity = CustomerEntity.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .status("ACTIVE")
                .build();
        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getFirstName()).isEqualTo("John");
        assertThat(entity.getLastName()).isEqualTo("Doe");
        assertThat(entity.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(entity.getStatus()).isEqualTo("ACTIVE");
    }

    @Test
    void settersWork() {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(2L);
        entity.setFirstName("Jane");
        entity.setLastName("Smith");
        entity.setEmail("jane.smith@example.com");
        entity.setStatus("INACTIVE");
        assertThat(entity.getId()).isEqualTo(2L);
        assertThat(entity.getFirstName()).isEqualTo("Jane");
        assertThat(entity.getLastName()).isEqualTo("Smith");
        assertThat(entity.getEmail()).isEqualTo("jane.smith@example.com");
        assertThat(entity.getStatus()).isEqualTo("INACTIVE");
    }
}

