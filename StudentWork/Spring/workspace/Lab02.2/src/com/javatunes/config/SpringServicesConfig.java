/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;

@Configuration
public class SpringServicesConfig {
	
	// TODO: Inject the repository
	@Inject
	ItemRepository itemRepository;

	// TODO: Declare the catalog bean definition
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Catalog catalog(){
		CatalogImpl catalog = new CatalogImpl();
		catalog.setItemRepository(itemRepository);
		return catalog;
	}

}