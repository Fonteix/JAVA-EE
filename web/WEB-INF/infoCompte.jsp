<%-- 
    Document   : infoCompte
    Created on : 13 juin 2017, 19:42:36
    Author     : lucas
--%>
<!--HEADER-->
<jsp:include page="Templates/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="${monCompte['id']}"/>
        <c:out value="${monCompte['prenom']}"/>
        <c:out value="${monCompte['nom']}"/>
        <c:out value="${monCompte['pseudo']}"/>
        <c:out value="${monCompte['mdp']}"/>
    </body>
</html>
