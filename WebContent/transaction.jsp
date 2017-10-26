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
	<link rel="stylesheet" type="text/css" href="css.css"> 

<title>NOOOOOOOOOOOOOOOOOOO</title>
</head>
<body>
		<form method="post" action="Transaction">
			<p> <label for="compte">Origine : </label> <input type="text" id="" name="compte" value="" size="20" maxlength="60" /> </p>
			<p> <label for="montant">Montant : </label> <input type="text" id="" name="montant" value="" size="20" maxlength="60" /> </p>
			<p> <label for="destination">Destination : </label> <input type="text" id="" name="destination" value="" size="20" maxlength="60" /> </p>
			<p> <label for="libelle">Libelle : </label> <input type="text" id="" name="libelle" value="" size="20" maxlength="60" /> </p>
            
            <input type="submit" value="Transaction" class="" />
        </form>
</body>
</html>