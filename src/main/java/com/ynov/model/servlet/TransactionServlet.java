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
import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Transaction;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/Transaction")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = JPA.loadClientByID(9);
		Transaction transaction = TransactionManager.loadTransactionById(7);
		
		request.setAttribute("client", client);
		request.setAttribute("transaction", transaction);
		
		//response.getWriter().append("Served at: hello world    " + client);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_compte = request.getParameter("compte");
		String montant = request.getParameter("montant");
		String libelle = request.getParameter("libelle");
		String destination = request.getParameter("destination");
		
		Compte compte_receveur = CompteManager.loadCompteByID(Integer.parseInt(destination));
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id_compte));
		TransactionManager.CreateTransaction(libelle, montant, compte, compte_receveur);
		
		doGet(request, response);
	}

}
