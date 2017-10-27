package com.ynov.model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.function.CompteManager;
import com.ynov.function.JPA;
import com.ynov.model.Client;

/**
 * Servlet implementation class AccountCreationServlet
 */
@WebServlet("/Account-Creation")
public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ID_USER          = "user_id";
	public static final String VUE          = "/AccountCreation.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute(ID_USER);
		
		client = JPA.loadClientByID(id);
		
		request.setAttribute("client", client);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute(ID_USER);
		
		client = JPA.loadClientByID(id);
		
		int montant = Integer.parseInt(request.getParameter("montant"));
		
		CompteManager.CreateCompte(client, montant);
		doGet(request, response);
	}

}
