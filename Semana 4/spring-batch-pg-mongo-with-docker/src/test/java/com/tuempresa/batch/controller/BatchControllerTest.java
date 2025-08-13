package com.tuempresa.batch.controller;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import jakarta.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BatchController.class)
class BatchControllerTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    JobLauncher jobLauncher;

    @MockBean
    Job importCustomersJob;

    @Test
    void runJob_returnsAccepted() throws Exception {
        JobExecution fakeExec = new JobExecution(1L);
        fakeExec.setJobInstance(new JobInstance(1L, "importCustomersJob"));
        fakeExec.setStatus(BatchStatus.STARTED);

        when(jobLauncher.run(any(Job.class), any(JobParameters.class))).thenReturn(fakeExec);

        mockMvc.perform(post("/api/batch/customers/run"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.jobName").value("importCustomersJob"))
                .andExpect(jsonPath("$.status").value("STARTED"));
    }
}
