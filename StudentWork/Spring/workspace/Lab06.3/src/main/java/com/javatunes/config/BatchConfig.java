/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import javax.inject.Inject;

import com.javatunes.batch.MusicItemNameProcessor;
import com.javatunes.batch.MusicItemNameProcessor2;
import com.javatunes.batch.MusicItemReader;
import com.javatunes.batch.MusicItemWriter;
import com.javatunes.domain.MusicItem;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
// Enable Spring batch processing
@EnableBatchProcessing
@SuppressWarnings({"rawtypes", "unchecked"}) // Needed because of obscure generics related warnings for readers/processors
public class BatchConfig {

	// @EnableBatchProcessing sets up the following two builders
    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;

    @Bean
	public MusicItemNameProcessor musicItemNameProcessor(){
    	return new MusicItemNameProcessor();
	}

	@Bean
	public MusicItemNameProcessor2 musicItemNameProcessor2(){
		return new MusicItemNameProcessor2();
	}

	@Bean
	public ItemProcessor namePriceProcessor() {
		List<ItemProcessor<MusicItem,MusicItem>> processors =
				new ArrayList<>();
		processors.add(musicItemNameProcessor());
		processors.add(musicItemNameProcessor2());
		CompositeItemProcessor<MusicItem,MusicItem> compositeProcessor =
				new CompositeItemProcessor<MusicItem,MusicItem>();
		compositeProcessor.setDelegates(processors);
		return compositeProcessor;
	}

	@Bean
	public MusicItemReader musicItemReader(){
		return new MusicItemReader();
	}

	@Bean
	public MusicItemWriter musicItemWriter(){
		return new MusicItemWriter();
	}

	@Bean
	public Step step1() {
		return steps.get("step1")
				. <MusicItem,MusicItem>chunk(2).reader(musicItemReader())
				.processor(musicItemNameProcessor()).writer(musicItemWriter()).build();
	}

//	@Bean
//	public Step step2() {
//		return steps.get("step2")
//				. <MusicItem,MusicItem>chunk(2).reader(musicItemReader())
//				.processor(musicItemNameProcessor2()).writer(musicItemWriter()).build();
//	}

	@Bean
	public Job job1() {
		//return jobs.get("myJob").start(step1()).next(step2()).build();
		return jobs.get("myJob").start(step1()).build();
	}
}