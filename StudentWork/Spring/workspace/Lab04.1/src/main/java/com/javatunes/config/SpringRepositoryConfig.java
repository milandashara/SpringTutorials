/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

// Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {
	
	// TODO: Inject the environment
	@Inject
	Environment environment;
	
	
	// Declare the item repository bean
	@Bean
	public ItemRepository itemRepository() {
		// Pass a CatalogData to the repository
		InMemoryItemRepository rep = new InMemoryItemRepository();
		rep.setMaxSearchResults(new Integer(environment.getProperty("javatunes.repository.maxSearchResults")));
		// TODO: Retrieve the maxSearchResults property from the environment (as an Integer)
		// TODO: Initialize the maxSearchResults property or rep using it
		return rep;
	}
}