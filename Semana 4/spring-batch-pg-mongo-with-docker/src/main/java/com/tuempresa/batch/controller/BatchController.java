package com.tuempresa.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/batch/customers")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job importCustomersJob;

    public BatchController(JobLauncher jobLauncher, Job importCustomersJob) {
        this.jobLauncher = jobLauncher;
        this.importCustomersJob = importCustomersJob;
    }

    @PostMapping("/run")
    public ResponseEntity<?> runJob(@RequestParam(required = false) String runTag) throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("ts", Instant.now().toEpochMilli())
                .addString("runTag", runTag != null ? runTag : "manual")
                .toJobParameters();

        JobExecution exec = jobLauncher.run(importCustomersJob, params);
        return ResponseEntity.accepted().body(Map.of(
                "jobName", exec.getJobInstance().getJobName(),
                "instanceId", exec.getJobInstance().getInstanceId(),
                "executionId", exec.getId(),
                "status", exec.getStatus().toString()
        ));
    }
}
