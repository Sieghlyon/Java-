<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="languages.Compte"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="com.ynov.model.Client" %>
<%@ page import="com.ynov.model.Compte" %>
<%@ page import="com.ynov.model.Transaction" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="inc/css.css"> 
	<script
  	src="https://code.jquery.com/jquery-3.2.1.js"
  	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  	crossorigin="anonymous"></script>
	<script type="text/javascript" src="inc/AJAX2.js"></script>

<title>Transaction</title>
</head>
<body>
        <div> <fmt:message key='page'/> : <div id="page"> </div> </div>
			<table>
  				<tr id="row">
    				<th> <fmt:message key="transaction"/> </th>
    				<th> <fmt:message key="montant"/> </th>
    				<th> <fmt:message key="date"/> </th>
  				</tr>
  				
			</table>
			
		<input type="button" value="Previous_Page"  onclick="previousPage()">
        
        <input type="button" value="Next_Page"  onclick="nextPage()">
			
		<form method="post" action="Transaction?id=${compte.getId()}">
			<p> <label for="montant">Montant : </label> <input type="text" id="" name="montant" value="" size="20" maxlength="60" /> </p>
            
            <input type="submit" value="Transaction" class="" />
        </form>
        
        <br> Montant du Compte:  </br> <br> ${compte.getMontant()} </br>
        
        
        
    <script>
		var page = (${page} - 1);
		var id = ${id};
	</script> 
</body>
</html>