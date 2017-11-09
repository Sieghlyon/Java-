<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="languages.Compte"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="com.ynov.model.Client" %>
<%@ page import="com.ynov.model.Compte" %>
<%@ page import="com.ynov.model.Transaction" %>

<!DOCTYPE html>
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/css.css"> 
<title>Liste de compte</title>
</head>
<body>
		
        
       <% Client test = (Client) request.getAttribute("client");%>
       
       		<p> <fmt:message key="bonjour"/>  </p>    <%= test.getPrenom() %>  <%= test.getNom() %>
       		<table>
  				<tr>
    				<th> <fmt:message key="compte"/> </th>
    				<th> <fmt:message key="montant"/> </th>
    				<th> <fmt:message key="virement"/> </th>
    				<th> <fmt:message key="transaction"/> </th>
  				</tr>
  				<c:forEach var = "i" items="${client.getComptes()}" >
  				<tr>	
         			<td> <c:out value = "${i.getLibelle()}"/> </td> 
         			<td> <c:out value = "${i.getMontant()}"/> </td>
         			<td> <input type="button" value="<fmt:message key="liste_virement"/>" onclick="document.location='http://localhost:8080/1/Virement?id=${i.getId()}'">  </td>
         			<td> <input type="button" value="<fmt:message key="liste_transaction"/>" onclick="document.location='http://localhost:8080/1/Transaction?id=${i.getId()}'">  </td>		
  				</tr>
  				</c:forEach>
			</table>
			
			<input type="button" value="<fmt:message key="account_creation"/>" onclick="document.location='http://localhost:8080/1/Account-Creation'">
       			
</body>
</html>