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

// Optional: Declare as a Spring configuration class
@Configuration
public class SpringDomainConfig {

	// Optional: Declare as a bean definition
	@Bean
	public Integer maxSearchResults () {
		return 20;
	}

}