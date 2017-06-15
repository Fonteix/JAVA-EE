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

<div class="col-10 panier">
    <jsp:useBean id="panier" scope="session" class="Modele.ModelePanier" />
    <ul class="collection">
        <li class="collection-item avatar">
        <c:choose>
            <c:when test="${panier.getNombreArticle()==0}" > 
                Panier vide !
            </c:when> 
            <c:otherwise>
                <c:forEach var="articlesPanier" items="${panier.getArticlePanier()}" varStatus="counter">
                    <form name="item" method="POST" action="#">
                        <c:out value="${articlesPanier.partNumber}"/> </BR>
                        <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'>
                        <input type='text' name="quantity" value='<c:out value="${articlesPanier.quantity}"/>' size='2'>
                        <input class="button" type="submit" name="action" value="Delete"></BR>


                        Prix/Total : <c:out value="${articlesPanier.totalCost}"/> euros</BR></BR>
                    </form>
                </c:forEach>   
                Total du panier: $<c:out value="${panier.getOrderTotal()}"/>

            </c:otherwise>
        </c:choose>

        
                        
                        <c:out value="${panier.numArticle}"/> </BR> 
                        <!--panier viens de ModelePanier.java-->
                        <!--numArticle viens de ModeleArticlePanier-->
                           
                    

        </li>
    </ul>
</div>
