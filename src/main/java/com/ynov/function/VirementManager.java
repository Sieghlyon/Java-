package com.ynov.function;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Virement;

public class VirementManager {
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	
	public static Virement loadVirementById(int id) { 
		 EntityManager em = null;

		 Singleton.getInstance();
			factory = Singleton.getFactory();
			 em = factory.createEntityManager();
			 
			 em.getTransaction().begin();
			 
			 Virement trans = em.find(Virement.class, id);		 
			 
			 em.close();
			 
			 return trans;
	 }
	
	public static void CreateVirement(String libel, String montant, Compte donneur, Compte receveur ) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		 em = factory.createEntityManager();
		 
		 em.getTransaction().begin();
		 
		 Virement transe = new Virement();
		 transe.setMontant(Integer.parseInt(montant));
		 transe.setDestination(receveur);
		 transe.setLibelle(libel);
		 transe.setCompte(donneur);
		 
		 List<Virement> virements = donneur.getVirements();
		 virements.add(transe);
		 donneur.setVirements(virements);
		 donneur.enlever(Integer.parseInt(montant));
		 receveur.ajouter(Integer.parseInt(montant));
		 
		 em.persist(transe);
		 em.merge(donneur);
		 em.merge(receveur);

		em.getTransaction().commit();
			
		 em.close();
			
	}
	
	public static double getSolde(Virement transe) {
		double montant;
		
		montant = transe.getMontant();
		
		return montant;
	}
}
