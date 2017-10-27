package com.ynov.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.model.ServletHelper;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			  throws IOException, ServletException {
			  HttpServletRequest req = (HttpServletRequest) request;
			  HttpServletResponse res = (HttpServletResponse) response;
			  
			  /* Non-filtrage des ressources statiques */
		        String chemin = req.getRequestURI().substring( req.getContextPath().length() );
		        if ( chemin.startsWith( "/inc" ) ) {
		            chain.doFilter( req, res );
		            return;
		        }
		        
			  HttpSession session = req.getSession(false);
			  String loginURI = ServletHelper.getServletUrl(ServletHelper.SERVLET_LOGIN, req);
			 
			  
			  boolean loggedIn = session != null && session.getAttribute("client") != null;
			        boolean loginRequest = req.getRequestURI().equals(loginURI);
			 
			        if (loggedIn || loginRequest) {
			            chain.doFilter(request, response);
			        } else {
			            res.sendRedirect(loginURI);
			        }
			  }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
