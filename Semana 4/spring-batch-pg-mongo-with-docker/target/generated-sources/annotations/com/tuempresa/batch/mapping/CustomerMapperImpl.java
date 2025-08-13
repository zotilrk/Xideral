package com.tuempresa.batch.mapping;

import com.tuempresa.batch.domain.mongo.CustomerDoc;
import com.tuempresa.batch.domain.postgres.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-13T17:31:40-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Homebrew)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDoc toDoc(CustomerEntity c) {
        if ( c == null ) {
            return null;
        }

        CustomerDoc customerDoc = new CustomerDoc();

        if ( c.getId() != null ) {
            customerDoc.setId( String.valueOf( c.getId() ) );
        }
        customerDoc.setEmail( extractEmailDomain( c.getEmail() ) );

        customerDoc.setFullName( fullName(c.getFirstName(), c.getLastName()) );
        customerDoc.setActive( mapStatusToActive(c.getStatus()) );
        customerDoc.setEmailDomain( extractEmailDomain(c.getEmail()) );

        return customerDoc;
    }
}
