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

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.JpaItemRepository;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

@Configuration
public class SpringRepositoryConfig {

	@Inject
	EntityManagerFactory entityManagerFactory;

	// TODO: Define itemRepository bean
	@Bean
	public ItemRepository itemRepository(){
		JpaItemRepository jpaItemRepository = new JpaItemRepository();
		return jpaItemRepository;
	}

	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager
				= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory );
		return transactionManager;
	}


}