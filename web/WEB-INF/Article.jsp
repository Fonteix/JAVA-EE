<%-- 
    Document   : Article
    Created on : 12 juin 2017, 08:47:08
    Author     : p1410833
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Métier.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Templates/header.jsp" />

<!-- ARTICLES-->


<c:forEach items="${liste}" var="article" >

    <div class="row">
        <div class="col s12 m6">
            <div class="card">
                <div class="card-image">
                    <img class="ballons" src="" alt=""/>
                    <span class="card-title"><c:out value="${article['nomArticle']}"/></span>
                    <a class="btn-floating halfway-fab waves-effect waves-light red"  type="submit" name="addToCart" value="Ajouter !"><i class="material-icons">add</i></a>
                </div>
                <div class="card-content">
                    <p> <c:out value="${article['prixArticle']}"/> euros </p>
                </div>
            </div>
        </div>
    </div>

</c:forEach>   


</body>
</html>
