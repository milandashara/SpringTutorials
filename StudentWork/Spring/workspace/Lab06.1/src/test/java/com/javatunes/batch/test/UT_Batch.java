/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch.test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
	
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringConfig.class)
public class UT_Batch {

	@Inject 
	JobLauncher jobLauncher;
	
	@Inject 
	Job job;
	
    @Test
    public void testLaunchJob() throws Exception {

        // test a complete job
    	  
    	try {
     
    		// TODO: Run the job through the job launcher
    		JobExecution execution = jobLauncher.run(job,new JobParameters());
    		System.out.println("Exit Status : " + execution.getStatus());
    		assertTrue("Exit status should be COMPLETED", execution.getStatus() == BatchStatus.COMPLETED);
     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
     
    }

    
}
