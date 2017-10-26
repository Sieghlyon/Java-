package com.ynov.function;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	private static Singleton instance;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	private static EntityManagerFactory factory;
	
	private Singleton() {
		factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		
	}
	
	/**
	 * @return the factory
	 */
	public static EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public static void setFactory(EntityManagerFactory factory) {
		Singleton.factory = factory;
	}

	public static Singleton getInstance() {
		
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
