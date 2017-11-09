package com.ynov.model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.model.Client;
import com.ynov.model.Connection;
import com.ynov.model.ServletHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "client";
    public static final String VUE              = "/Login.jsp";
    public static final String ACCUEIL          = "/Login.jsp";
    public static final String ID_USER          = "user_id";
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Préparation de l'objet formulaire */
        Connection form = new Connection();

        /* Traitement de la requête et récupération du bean en résultant */
        Client utilisateur = form.connecterUtilisateur( request );
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession(false);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        
        if ( form.getErreurs().isEmpty() ) {
        	session.setAttribute( ATT_SESSION_USER, utilisateur.getLogin() );
        	session.setAttribute( ID_USER , utilisateur.getClientID() );
        	
        } else {
        	session.setAttribute( ATT_SESSION_USER, null );
        	utilisateur = null;
        }
        
        
        if(utilisateur != null) {
        	this.getServletContext().getRequestDispatcher( ServletHelper.SERVLET_ACCOUNT ).forward( request, response );
        } else {
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.LOGIN);
        	dispatcher.forward( request, response );
        }
        
        /* 
         * RequestDispatcher dispatcher = getServletCOntext().getRequestDispatcher(ServletHelper.ACCOUNTS);
         */
	}

}
