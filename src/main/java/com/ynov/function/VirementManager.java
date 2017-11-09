package com.ynov.function;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public static String getVirement(String id, String page) throws IOException { 
		EntityManager em = null;
		String chaine;
		
		Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
			 
		String query = "SELECT vire FROM Virement vire INNER JOIN vire.compte orig WHERE orig.id=" + id ;
		
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id));
		
		TypedQuery<Virement> tQuery = em.createQuery(query, Virement.class).setFirstResult(10 * Integer.parseInt(page)).setMaxResults(10) ;
		List<Virement> liste = tQuery.getResultList();
		
		chaine = Serialisation.Json(liste);
		
		em.close();
			 
		return chaine;
	 }
	
	public static void CreateVirement(String libel, String montant, Compte donneur, Compte receveur ) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		 em = factory.createEntityManager();
		 
		 em.getTransaction().begin();
		 
		 Virement vire = new Virement();
		 vire.setMontant(Integer.parseInt(montant));
		 vire.setDestination(receveur);
		 vire.setLibelle(libel);
		 vire.setCompte(donneur);
		 vire.setDate(new Date());
		 
		 List<Virement> virements = donneur.getVirements();
		 virements.add(vire);
		 donneur.setVirements(virements);
		 donneur.enlever(Integer.parseInt(montant));
		 receveur.ajouter(Integer.parseInt(montant));
		 
		 em.persist(vire);
		 em.merge(donneur);
		 em.merge(receveur);

		em.getTransaction().commit();
			
		 em.close();
			
	}
	
	public static double getSolde(Virement vire) {
		double montant;
		
		montant = vire.getMontant();
		
		return montant;
	}
}
