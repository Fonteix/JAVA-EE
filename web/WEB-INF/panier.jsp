<%@page import="Métier.Article"%>
<%@page import="java.util.List"%>


<jsp:include page="Templates/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if (request.getAttribute("confirmationAchat")!=null) {%>
    <div class="row">
        <div class="col s8 offset-s2 center-align card-panel light-green"><span class="white-text flow-text"><strong>${confirmationAchat}</strong></span></div>
    </div>
<% } %>
    
<% if(request.getAttribute("listeArticle")!=null){%>
<c:forEach items="${listeArticle}" var="article" >
    <ul class="collection">
        <li class="collection-item avatar">
            <img src="images/yuna.jpg" alt="" class="circle">
            <span class="title"><c:out value="${article['nomArticle']}"/></span>
            <p><c:out value="${article['typeArticle']}"/><br>
                Prix/Unité: <c:out value="${article['prixArticle']}"/> euros</BR>
        </p>
        </li>
    </ul>
</c:forEach>
<%} else {%>
    <ul class="collection">
        <li class="collection-item avatar">
            Panier vide
        </li>
    </ul>
<%}%>
<h4>TOTAL : ${prix} euros</h4>
<div class="row">
    <div class="col s12 m5">
        <div class="card-panel teal">
            <form action="panier" method="post">
            <span class="white-text">
                    <button class="btn waves-effect waves-light" type="submit" name="vider" value="vider">Vider le panier<i class="material-icons">delete</i></button>
                    <button class="btn waves-effect waves-light" type="submit" name="valider" value="valider">Valider le panier<i class="material-icons right">send</i></button>
                </form>
            </span>
        </div>
    </div>
</div>
