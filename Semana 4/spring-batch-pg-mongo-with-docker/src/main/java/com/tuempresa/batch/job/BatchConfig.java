package com.tuempresa.batch.job;

import com.tuempresa.batch.domain.mongo.CustomerDoc;
import com.tuempresa.batch.domain.mongo.CustomerDocRepository;
import com.tuempresa.batch.domain.postgres.CustomerEntity;
import com.tuempresa.batch.domain.postgres.CustomerRepository;
import com.tuempresa.batch.mapping.CustomerMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
public class BatchConfig {

    @Bean
    public org.springframework.batch.item.data.RepositoryItemReader<CustomerEntity> customerReader(CustomerRepository repository) {
        return new RepositoryItemReaderBuilder<CustomerEntity>()
                .name("customerReader")
                .repository(repository)
                .methodName("findAll")
                .pageSize(100)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();
    }

    @Bean
    public ItemProcessor<CustomerEntity, CustomerDoc> customerProcessor(CustomerMapper mapper) {
        return mapper::toDoc;
    }

    @Bean
    public RepositoryItemWriter<CustomerDoc> customerWriter(CustomerDocRepository repository) {
        return new RepositoryItemWriterBuilder<CustomerDoc>()
                .repository(repository)
                .methodName("save")
                .build();
    }

    @Bean
    public Step importCustomersStep(JobRepository jobRepository,
                                    PlatformTransactionManager transactionManager,
                                    org.springframework.batch.item.data.RepositoryItemReader<CustomerEntity> reader,
                                    ItemProcessor<CustomerEntity, CustomerDoc> processor,
                                    RepositoryItemWriter<CustomerDoc> writer) {
        return new StepBuilder("importCustomersStep", jobRepository)
                .<CustomerEntity, CustomerDoc>chunk(100, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job importCustomersJob(JobRepository jobRepository, Step importCustomersStep) {
        return new JobBuilder("importCustomersJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(importCustomersStep)
                .build();
    }
}
