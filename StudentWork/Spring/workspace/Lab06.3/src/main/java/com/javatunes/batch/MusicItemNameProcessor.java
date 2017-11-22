/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import com.javatunes.domain.MusicItem;
import org.springframework.batch.item.ItemProcessor;

// A simple Person processor that returns a Person
// TODO: Implement the correct type to be an item processor for MusicItem instances
// TODO: The processor input and output types should both be MusicItem
public class MusicItemNameProcessor implements ItemProcessor<MusicItem, MusicItem> {

	// TODO: Create a process method appropriate for this class
	@Override
	public MusicItem process(MusicItem p) throws Exception {
		System.out.println("MusicItemNameProcessor.process()");
		p.setTitle(p.getTitle().toUpperCase());
		return p;
	}
}
