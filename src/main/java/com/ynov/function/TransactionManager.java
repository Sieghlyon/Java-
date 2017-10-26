package com.ynov.function;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;

public class TransactionManager {
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	
	public static Transaction loadTransactionById(int id) { 
		 EntityManager em = null;

		 Singleton.getInstance();
			factory = Singleton.getFactory();
			 em = factory.createEntityManager();
			 
			 em.getTransaction().begin();
			 
			 Transaction trans = em.find(Transaction.class, id);		 
			 
			 em.close();
			 
			 return trans;
	 }
	
	public static void CreateTransaction(String libel, String montant, Compte donneur, Compte receveur ) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		 em = factory.createEntityManager();
		 
		 em.getTransaction().begin();
		 
		 Transaction transe = new Transaction();
		 transe.setMontant(Integer.parseInt(montant));
		 transe.setDestination(receveur.getId());
		 transe.setLibelle(libel);
		 transe.setCompte(donneur);
		 
		 List<Transaction> transactions = donneur.getTransactions();
		 transactions.add(transe);
		 donneur.setTransactions(transactions);
		 donneur.enlever(Integer.parseInt(montant));
		 receveur.ajouter(Integer.parseInt(montant));
		 
		 em.persist(transe);
		 em.merge(donneur);
		 em.merge(receveur);

		em.getTransaction().commit();
			
		 em.close();
			
	}
	
	public static double getSolde(Transaction transe) {
		double montant;
		
		montant = transe.getMontant();
		
		return montant;
	}
}
