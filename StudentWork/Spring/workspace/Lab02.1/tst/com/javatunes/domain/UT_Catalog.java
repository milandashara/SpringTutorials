/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.service.Catalog;

// Configure using Spring's testing integration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/configuration/applicationContext.xml")
public class UT_Catalog {

    @Inject
    private Catalog cat;
    
	@Test
	public void catalogTest() {
		assertTrue("Catalog should not be null", cat!=null);
		
		System.out.println(cat);
		System.out.println(cat.size());
		System.out.println(cat.findByKeyword("a"));

	}

}
