package com.ynov.model;
import javax.servlet.http.HttpServletRequest;

public class ServletHelper {
		public static final String ACCOUNTS = "/listAccounts.jsp";
		public static final String LOGIN = "/Login.jsp";
		public static final String SERVLET_LOGIN = "/Login";
		public static final String SERVLET_ACCOUNT = "/Accounts";
		
		public static String getServletUrl(String servlet, HttpServletRequest request) {
			return request.getContextPath() + servlet;
		}
}
