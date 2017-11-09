package com.ynov.function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

import com.ynov.model.Client;

public class ClientManager {
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
	//private static Logger logger = LogManager.getLogger(JPA.class);
	
	 public static Client loadClientByID(int clientID) { 
		 EntityManager em = null;

		 Singleton.getInstance();
			factory = Singleton.getFactory();
			 em = factory.createEntityManager();
			 
			 em.getTransaction().begin();
			 
			 Client client = em.find(Client.class, clientID);
			 
			 
			 em.close();
			
			 
			 return client;
	 }
	 
	 public static Client createClient() { 
		 EntityManager em = null;

		 Singleton.getInstance();
			factory = Singleton.getFactory();
			 em = factory.createEntityManager();
			 
			 em.getTransaction().begin();
			 
			 Client client = new Client();
			 
			 em.persist(client);
			 em.getTransaction().commit();
			 em.close();
			
			 
			 return client;
	 }
	 
	 public static void ChangePassword(String motdepasse, int id) {
		 EntityManager em = null;

		 Singleton.getInstance();
		 factory = Singleton.getFactory();
		 em = factory.createEntityManager();
			 
		 em.getTransaction().begin();
			 
		 Client client = em.find(Client.class, id);
		 client.setPassword(motdepasse);
			 
		 em.merge(client);
		 em.getTransaction().commit();
		 em.close();
	 }
}
