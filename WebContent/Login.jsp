<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="languages.Compte"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.ynov.model.Client" %>
<%@ page import="com.ynov.model.Compte" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

		<form>
            <select id="language" name="language" onchange="submit()">
            	<option value="fr" ${language == 'fr' ? 'selected' : ''}>Fran�ais</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>          
            </select>
        </form>
        
		<form method="post" action="Login">
            <fieldset>
                <legend> <fmt:message key="connexion"/> </legend>
                <p><fmt:message key="login_form"/></p>

                <label for="nom"> <fmt:message key="login"/> <span class="requis">*</span></label>
                <input type="login" id="login" name="login" value="<c:out value="${utilisateur.login}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['login']}</span>
                <br />

                <label for="password"> <fmt:message key="password"/> <span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['password']}</span>
                <br />

                <input type="submit" value="Login" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
</body>
</html>