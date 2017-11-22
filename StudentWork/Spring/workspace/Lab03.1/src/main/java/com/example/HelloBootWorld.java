/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloBootWorld implements CommandLineRunner {

    public static void main(String[] args) {
    	System.out.println("HelloBootWorld.main() called");
        SpringApplication.run(HelloBootWorld.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("HelloBootWorld.run() called");
		for (String cur : arg0) {
			System.out.println(cur);
		}
	}    
}
