/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class SpringRepositoryConfig {

	@Inject
	private Integer maxSearchResults;

	// TODO: Declare the item repository bean
	@Bean
	public ItemRepository itemRepository(){
		InMemoryItemRepository inMemoryItemRepository = new InMemoryItemRepository();
		inMemoryItemRepository.setMaxSearchResults(maxSearchResults);
		return inMemoryItemRepository;
	}

}