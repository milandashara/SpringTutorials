/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import com.javatunes.domain.MusicItem;
import org.springframework.batch.item.ItemWriter;

// A simple writer for Person items
// TODO: Implement the correct type to be an item reader for MusicItem instances
public class MusicItemWriter implements ItemWriter<MusicItem>{

	// TODO: Create a write method
	public void	write(java.util.List<? extends MusicItem> items) {
		System.out.println("MusicItemWriter.write() called");
		for (MusicItem cur : items) {
			System.out.println("title :" +cur.getTitle() +" price:"+cur.getPrice());
		}
	}
}
