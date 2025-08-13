package com.tuempresa.batch.job;

import com.tuempresa.batch.domain.mongo.CustomerDocRepository;
import com.tuempresa.batch.domain.postgres.CustomerRepository;
import com.tuempresa.batch.mapping.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BatchConfigTest {
    @Autowired
    ApplicationContext context;

    @Test
    void customerReaderBeanExists() {
        assertThat(context.getBean("customerReader")).isNotNull();
    }

    @Test
    void customerProcessorBeanExists() {
        Object bean = context.getBean("customerProcessor");
        assertThat(bean).isNotNull();
    }

    @Test
    void customerWriterBeanExists() {
        assertThat(context.getBean("customerWriter")).isNotNull();
    }
}

