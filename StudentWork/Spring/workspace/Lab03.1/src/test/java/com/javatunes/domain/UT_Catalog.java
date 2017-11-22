/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

@RunWith(SpringJUnit4ClassRunner.class)
// TODO: Initialize Spring container via @SpringApplicationConfiguration
@SpringApplicationConfiguration(SpringConfig.class)
public class UT_Catalog {

    @Inject
    Catalog catalog;
    
	@Test
	public void catalogTest() {
		
		assertNotNull("Catalog should not be null", catalog);

		Collection<MusicItem> found = catalog.findByKeyword("a");

		for (MusicItem musicItem : found) {
			System.out.println(musicItem);
		}
		
	}

}
 