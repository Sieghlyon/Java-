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
       		<p> comptes </p>
       		
       		<fmt:message key="test"/>
       		<fmt:message key="bonjour"/>
			${text}
			${bonjour}
			<c:forEach var = "i" items="${client.getComptes()}" >
         	<p> Item </p> <c:out value = "${i}"/><p>
      </c:forEach>
			
		
</body>
</html>