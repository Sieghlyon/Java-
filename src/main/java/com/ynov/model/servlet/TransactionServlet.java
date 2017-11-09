package com.ynov.model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.function.CompteManager;
import com.ynov.function.TransactionManager;
import com.ynov.model.Compte;

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
		String id = request.getParameter("id");
		//Client client = JPA.loadClientByID(Integer.parseInt(id));
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id));
		//Transaction transaction = TransactionManager.loadTransactionById(7);
		//request.setAttribute("transaction", transaction);
		
		//request.setAttribute("client", client);
		request.setAttribute("compte", compte);
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_compte = request.getParameter( "id" );
		
		String montant = request.getParameter("montant");
		
		Compte compte = CompteManager.loadCompteByID(Integer.parseInt(id_compte));
		TransactionManager.CreateTransaction( montant, compte);
		
		doGet(request, response);
	}

}
