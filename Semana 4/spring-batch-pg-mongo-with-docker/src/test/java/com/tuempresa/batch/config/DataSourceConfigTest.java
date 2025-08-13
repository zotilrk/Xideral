package com.tuempresa.batch.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataSourceConfigTest {

    @Autowired
    ApplicationContext context;

    @Test
    void businessDataSourceBeanExists() {
        assertThat(context.getBean("businessDataSource")).isNotNull();
    }

    @Test
    void batchMetaDataSourceBeanExists() {
        assertThat(context.getBean("batchMetaDataSource")).isNotNull();
    }
}

