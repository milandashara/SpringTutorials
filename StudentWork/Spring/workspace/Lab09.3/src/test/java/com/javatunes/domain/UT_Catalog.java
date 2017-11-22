/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import javax.inject.Inject;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringConfig.class)
public class UT_Catalog {

	@Inject
	Catalog catalog;
	
	@Test
	public void catalogTest() {
		
		assertNotNull("Catalog should not be null", catalog);
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(catalog.findById(1L));
		System.out.println("***\n");
	}

}
