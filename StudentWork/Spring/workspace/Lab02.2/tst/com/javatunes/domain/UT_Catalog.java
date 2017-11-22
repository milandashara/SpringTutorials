/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class UT_Catalog {
	
    @Inject
    private Catalog catalog;

    @Inject
	private Catalog catalog2;
	
	@Test
	public void catalogTest() {

		// Catalog catalog = ctx.getBean(Catalog.class);
		assertTrue("Catalog should not be null", catalog!=null);

		assertTrue("scope prototye test", catalog!=catalog2);
		
		Collection<MusicItem> items = catalog.findByKeyword("a");
		assertTrue("Found items should not be empty", items.size()>0);
		
		// Some console output to see our results.
		for (MusicItem musicItem : items) {
			System.out.println(musicItem);
		}
		
	}

}
