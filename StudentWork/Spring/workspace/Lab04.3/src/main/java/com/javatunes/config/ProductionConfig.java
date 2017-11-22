/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.RepositoryType;
import com.javatunes.persistence.StorageType;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;
import org.springframework.context.annotation.Profile;

// Declare as a Spring configuration class
// TODO: Declare a profile
@Profile("production")
@Configuration
public class ProductionConfig {
	
	@Inject
	@RepositoryType(StorageType.CLOUD)
	private ItemRepository itemRepository;
	
	@Bean
	public Catalog catalog() {
		CatalogImpl cat = new CatalogImpl(itemRepository);
		return cat;
	}
}