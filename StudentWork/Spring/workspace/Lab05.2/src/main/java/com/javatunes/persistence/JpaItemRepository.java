/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javatunes.domain.MusicItem;

public class JpaItemRepository implements ItemRepository {
	
	// TODO: Inject the EM
	@PersistenceContext
	private EntityManager em;

	public MusicItem get(Long id) {
	    // TODO: Call EntityManager.find() and return the result
		return em.find(MusicItem.class,id);
	}

	public void add(MusicItem musicItem){
		em.persist(musicItem);
	}

	@Override
	public Collection<MusicItem> getAll() {
		// Not implemented
		return null;
	}

	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		// Not implemented
		return null;
	}

	@Override
	public int size() {
		// Not implemented
		return ((Long) em.createQuery("select count(*) from MusicItem").getResultList().get(0)).intValue();
	}

}
