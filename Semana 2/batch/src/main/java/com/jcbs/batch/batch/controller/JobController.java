package com.jcbs.batch.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @PostMapping("/importProducts")
    public void importCsvToDBJob() {

        try {
            jobLauncher.run(job, new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
