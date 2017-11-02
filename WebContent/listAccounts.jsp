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
<title>well whatever</title>
</head>
<body>
		<form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
        
       <% Client test = (Client) request.getAttribute("client");%>
       
       		<p> bonjour :  </p>    <%= test.getPrenom() %>  <%= test.getNom() %>
       		<table>
  				<tr>
    				<th>Compte</th>
    				<th>Montant</th>
    				<th>Transaction</th>
  				</tr>
  				<c:forEach var = "i" items="${client.getComptes()}" >
  				<tr>	
         			<td> <c:out value = "${i.getLibelle()}"/> </td> 
         			<td> <c:out value = "${i.getMontant()}"/> </td>
         			<td> <input type="button" value="Liste Transactions" onclick="document.location='http://localhost:8080/1/Transaction?id=${i.getId()}'">  </td>	
  				</tr>
  				</c:forEach>
			</table>
       			
</body>
</html>