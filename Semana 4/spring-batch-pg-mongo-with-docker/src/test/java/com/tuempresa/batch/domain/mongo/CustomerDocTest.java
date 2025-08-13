package com.tuempresa.batch.domain.mongo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CustomerDocTest {
    @Test
    void builderAndGettersWork() {
        CustomerDoc doc = CustomerDoc.builder()
                .id("abc123")
                .fullName("Alice Johnson")
                .email("alice.johnson@example.com")
                .emailDomain("example.com")
                .active(true)
                .build();
        assertThat(doc.getId()).isEqualTo("abc123");
        assertThat(doc.getFullName()).isEqualTo("Alice Johnson");
        assertThat(doc.getEmail()).isEqualTo("alice.johnson@example.com");
        assertThat(doc.getEmailDomain()).isEqualTo("example.com");
        assertThat(doc.isActive()).isTrue();
    }

    @Test
    void settersWork() {
        CustomerDoc doc = new CustomerDoc();
        doc.setId("xyz789");
        doc.setFullName("Bob Lee");
        doc.setEmail("bob.lee@example.com");
        doc.setEmailDomain("example.com");
        doc.setActive(false);
        assertThat(doc.getId()).isEqualTo("xyz789");
        assertThat(doc.getFullName()).isEqualTo("Bob Lee");
        assertThat(doc.getEmail()).isEqualTo("bob.lee@example.com");
        assertThat(doc.getEmailDomain()).isEqualTo("example.com");
        assertThat(doc.isActive()).isFalse();
    }
}

