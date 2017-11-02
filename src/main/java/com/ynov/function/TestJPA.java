package com.ynov.function;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Virement;


public class TestJPA {

	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	private static Logger logger = LogManager.getLogger(TestJPA.class);
	
	public static void main(String[] args) {
		EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
		 
		 try {
				em.getTransaction().begin();
					
			Client client = new Client();
			client.setLogin("bourse");
			client.setNom("seb");
			client.setPrenom("boursier");
			client.setPassword("no");
			Compte compte = new Compte();
			compte.setLibelle("Compte courant");
		
			compte.setMontant(-123456);
			
			List<Compte> listeComptes = new ArrayList<Compte>();
			listeComptes.add(compte);
			
			client.setComptes(listeComptes);
			compte.setClient(client);
			
			Virement transe = new Virement();
			transe.setCompte(compte);
			transe.setMontant(-95);
			//transe.setDestination(1);
			List<Virement> listeTransactions = new ArrayList<Virement>();
			listeTransactions.add(transe);
			compte.setVirements(listeTransactions);

			em.persist(client);

			em.getTransaction().commit();
			
			TypedQuery<Client> tQuery = em.createQuery("FROM Client", Client.class);
			List<Client> clientList = tQuery.getResultList();
			TypedQuery<Compte> tQueryC = em.createQuery("FROM Compte", Compte.class);
			List<Compte> comptes = tQueryC.getResultList();
			
			System.out.println("Size client : " + clientList.size());
			System.out.println("Size compte : " + comptes.size());

 
			
		PersistenceUtil util = Persistence.getPersistenceUtil();
		
		 for (Client c : clientList) { 
			  logger.info(c.toString());
			  logger.debug("is client loaded ?" + util.isLoaded(c));
			  logger.debug("is compte loaded ?" + util.isLoaded(c.getComptes()));
				  
			  Compte co = c.getComptes().get(0); 
			  logger.debug("are transaction loaded ?" +
			util.isLoaded(co, "transactions")); co.getVirements();
			logger.debug("are transaction loaded now ?" + util.isLoaded(co,"transactions")); 
			for(Virement tran: co.getVirements()){
					logger.info(tran.toString()); 
				} 
			  
			logger.info("Size" + clientList.size()); 
			}
		 
			}finally {
				em.close();
				factory.close();
			}
	

	}

}