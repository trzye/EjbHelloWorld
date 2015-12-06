package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Cabin;


@Stateless
public class TravelAgentBean implements TravelAgentRemote {
	@PersistenceContext(unitName="oracle")
	private EntityManager manager;
	
	@Override
	public void createCabin(Cabin cabin) {
		manager.persist(cabin);
	}

	@Override
	public Cabin findCabin(int id) {
		return manager.find(Cabin.class, id);
	}
}
