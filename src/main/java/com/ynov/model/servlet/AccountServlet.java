package com.ynov.model.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.function.ClientManager;
import com.ynov.function.JPA;
import com.ynov.function.TransactionManager;
import com.ynov.model.Client;
import com.ynov.model.Transaction;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/Accounts")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * default constructor
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		String id = request.getParameter( "id" );
	
		Client client = JPA.loadClientByID(9);
		Transaction transaction = TransactionManager.loadTransactionById(7);
		
		request.setAttribute("text", id);
		request.setAttribute("client", client);
		request.setAttribute("transaction", transaction);
		
		//response.getWriter().append("Served at: hello world   hhh " + client);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAccounts.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
