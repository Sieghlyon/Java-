package com.ynov.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import com.ynov.function.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connection {
	private static final String CHAMP_LOGIN  = "login";
    private static final String CHAMP_PASS   = "password";
    private static EntityManagerFactory factory;

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Client connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String login = getValeurChamp( request, CHAMP_LOGIN );
        String mdp = getValeurChamp( request, CHAMP_PASS );

        Client utilisateur = new Client();

        try {
            validationLogin( login , mdp);
        } catch ( Exception e ) {
            setErreur( CHAMP_LOGIN, e.getMessage() );
        }
        
        utilisateur.setLogin( login );

        /* Validation du champ mot de passe. */
        try {
            validationmdp( login, mdp );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setPassword(  mdp );

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
            EntityManager em = null;
        	
        	Singleton.getInstance();
    		factory = Singleton.getFactory();
    		em = factory.createEntityManager();
    		 
    		TypedQuery<Client> tQuery = em.createQuery("FROM Client WHERE login='" + login + "'AND password='" + mdp + "'", Client.class);
    		utilisateur = tQuery.getSingleResult();
    		 
        	em.close();
            
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    private void validationLogin(String login, String mdp) throws Exception {
		// TODO Auto-generated method stub
    	EntityManager em = null;
    	
    	Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
		
		Client client = new Client();
		
    	try {
		
		 
		 TypedQuery<Client> tQuery = em.createQuery("FROM Client WHERE login='" + login + "'AND password='" + mdp + "'", Client.class);
		 client = tQuery.getSingleResult();
		 
    	}catch(Exception e ) {
    		throw new Exception( "Le login n'existe pas." );
    	}finally {
    		em.close();
    	}
		 
        if ( client.getLogin().equals(login) == false ) {      
            throw new Exception( "Le login est incorrecte." );  
        }
	}


    /**
     * Valide le mot de passe saisi.
     */
    private void validationmdp(String login, String mdp ) throws Exception {
    	EntityManager em = null;

		Singleton.getInstance();
		factory = Singleton.getFactory();
		em = factory.createEntityManager();
		
		Client client = new Client();
		 
		 try {
		 TypedQuery<Client> tQuery = em.createQuery("FROM Client WHERE login='" + login + "'AND password='" + mdp + "'", Client.class);
		 client = tQuery.getSingleResult();
		 
		 }catch(Exception e ) {
	    		throw new Exception( "Le mot de passe est incorrecte." );
	    	}finally {
	    		em.close();
	    	}
		 
        if (client.getPassword().equals(mdp) == false ) {
            if ( mdp.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } 
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
