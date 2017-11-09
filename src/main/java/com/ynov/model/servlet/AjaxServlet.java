package com.ynov.model.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.function.CompteManager;
import com.ynov.function.Serialisation;
import com.ynov.function.Singleton;
import com.ynov.function.VirementManager;
import com.ynov.model.Client;
import com.ynov.model.Compte;
import com.ynov.model.Virement;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/Ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory factory;
	private static final String PERSISTANCE_UNIT_NAME = "banque";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		String chaine = VirementManager.getVirement(id, page);
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
        response.getWriter().write(chaine);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
