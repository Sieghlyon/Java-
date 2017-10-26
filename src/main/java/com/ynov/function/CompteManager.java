package com.ynov.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;

public class CompteManager {
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	
	public static void CreateCompte() {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		 em = factory.createEntityManager();
		 
		 Transaction transe = new Transaction();
		 
		 em.getTransaction().begin();
		 
		 
		 em.persist(transe);

		em.getTransaction().commit();
			
		 em.close();
	
	}
	
	public static Compte loadCompteByID(int id) { 
		 EntityManager em = null;

			Singleton.getInstance();
			factory = Singleton.getFactory();
			 em = factory.createEntityManager();
			 
			 em.getTransaction().begin();
			 
			 Compte compte = em.find(Compte.class, id);
			 
			 
			 em.close();
			
			 
			 return compte;
	 }
}
