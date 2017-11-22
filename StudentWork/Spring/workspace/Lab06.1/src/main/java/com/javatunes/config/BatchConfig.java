package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.batch.SimpleTasklet;

@Configuration
// TODO: Enable Batch Processing
@EnableBatchProcessing
public class BatchConfig {

   // TODO: Declare and inject factory for building jobs
	@Inject
	private JobBuilderFactory jobs;

   // TODO: Declare and inject factory for building steps  
	@Inject
	private StepBuilderFactory steps;
	@Bean
	public Step step1() {
	  // TODO: Create and return a step called "step1" that will run SimpleTasklet
	return steps.get("step1").tasklet(new SimpleTasklet()).build();}

	@Bean
	public Job job1() {
	  // TODO: Create and return a job called "myJob" that will contain step1
	  return jobs.get("myjob1").start(step1()).build();
	}


}