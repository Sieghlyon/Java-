package com.ynov.model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.function.CompteManager;
import com.ynov.function.JPA;
import com.ynov.function.TransactionManager;
import com.ynov.function.VirementManager;
import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/Virement")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter( "id" );
		//Client client = JPA.loadClientByID(Integer.parseInt(id));
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id));
		//Transaction transaction = TransactionManager.loadTransactionById(7);
		//request.setAttribute("transaction", transaction);
		
		//request.setAttribute("client", client);
		request.setAttribute("compte", compte);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_compte = request.getParameter( "id" );
		
		String montant = request.getParameter("montant");
		String libelle = request.getParameter("libelle");
		String destination = request.getParameter("destination");
		
		Compte compte_receveur = CompteManager.loadCompteByID(Integer.parseInt(destination));
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id_compte));
		VirementManager.CreateVirement(libelle, montant, compte, compte_receveur);
		
		doGet(request, response);
	}

}
