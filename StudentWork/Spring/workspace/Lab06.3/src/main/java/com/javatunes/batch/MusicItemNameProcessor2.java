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

import java.math.BigDecimal;

// A simple Person processor that returns a Person
// TODO: Implement the correct type to be an item processor for MusicItem instances
// TODO: The processor input and output types should both be MusicItem
public class MusicItemNameProcessor2 implements ItemProcessor<MusicItem, MusicItem> {

	private static BigDecimal ONE = new BigDecimal("1.00");

	// TODO: Create a process method appropriate for this class
	@Override
	public MusicItem process(MusicItem musicItem) throws Exception {
		System.out.println("MusicItemNameProcessor2.process()");
		musicItem.setPrice(musicItem.getPrice().add(ONE));
		return musicItem;
	}
}
