package com.ynov.function;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.ynov.model.Compte;
import com.ynov.model.Transaction;
import com.ynov.model.Virement;

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
	
	public static void CreateTransaction(String montant, Compte compte) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		 em = factory.createEntityManager();
		 
		 em.getTransaction().begin();
		 
		 Transaction transe = new Transaction();
		 transe.setMontant(Integer.parseInt(montant));
		 transe.setDate(new Date());
		 transe.setCompte(compte);
		 
		 List<Transaction> transactions = compte.getTransactions();
		 transactions.add(transe);
		 compte.setTransactions(transactions);
		 compte.enlever(Integer.parseInt(montant));
		 
		 em.persist(transe);
		 em.merge(compte);

		 em.getTransaction().commit();
			
		 em.close();
			
	}

	public static String getTransaction(String id, String page) throws IOException {
		EntityManager em = null;
		String chaine;
		
		Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
			 
		String query = "SELECT transe FROM Transaction transe INNER JOIN transe.compte orig WHERE orig.id=" + id ;
		
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id));
		
		TypedQuery<Transaction> tQuery = em.createQuery(query, Transaction.class).setFirstResult(10 * Integer.parseInt(page)).setMaxResults(10) ;
		List<Transaction> liste = tQuery.getResultList();
		
		chaine = Serialisation.JsonTransaction(liste);
		
		em.close();
			 
		return chaine;
	}
}
