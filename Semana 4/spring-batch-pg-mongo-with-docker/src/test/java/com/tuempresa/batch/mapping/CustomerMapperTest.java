package com.tuempresa.batch.mapping;

import com.tuempresa.batch.domain.mongo.CustomerDoc;
import com.tuempresa.batch.domain.postgres.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    private final CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    void toDoc_mapsFields() {
        CustomerEntity e = CustomerEntity.builder()
                .id(123L).firstName("Ada").lastName("Lovelace")
                .email("ada@computing.org").status("ACTIVE").build();

        CustomerDoc doc = mapper.toDoc(e);
        assertEquals("123", doc.getId());
        assertEquals("Ada Lovelace", doc.getFullName());
        assertEquals("computing.org", doc.getEmailDomain());
        assertTrue(doc.isActive());
    }
}
