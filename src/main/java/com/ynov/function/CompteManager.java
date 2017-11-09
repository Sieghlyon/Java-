package com.ynov.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;

public class CompteManager {
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	
	public static void CreateCompte(Client client, int montant, String libelle) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
		
		List<Compte> listeComptes = new ArrayList<Compte>();
		 
		Compte compte = new Compte();
		
		compte.setLibelle(libelle);
		compte.setClient(client);
		compte.setMontant(montant);
		
		listeComptes = client.getComptes();
		listeComptes.add(compte);
		client.setComptes(listeComptes);
		
		em.getTransaction().begin();
		 
		em.persist(compte);
		em.merge(client);

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
