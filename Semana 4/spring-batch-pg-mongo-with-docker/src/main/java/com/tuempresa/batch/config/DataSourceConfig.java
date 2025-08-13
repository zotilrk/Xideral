package com.tuempresa.batch.config;

import javax.sql.DataSource;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class DataSourceConfig {

    // DataSource principal (PostgreSQL)
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties businessDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource businessDataSource() {
        return businessDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    // DataSource para metadatos de Spring Batch (H2)
    @Bean
    @ConfigurationProperties("spring.batchmeta")
    public DataSourceProperties batchMetaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.batchmeta")
    public DataSource batchMetaDataSource() {
        return batchMetaDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
