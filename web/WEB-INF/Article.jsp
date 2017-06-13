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
    <div class="col s12 m7" style="padding:15px">
    <div class="card horizontal">
      <div class="card-image">
        <img alt="image" src="image/${article['imageArticle']}" <c:out value="${article['imageArticle']}"/> >
      </div>
      <div class="card-stacked">
        <div class="card-content">
            <p><c:out value="${article['nomArticle']}"/> </br>  <c:out value="${article['prixArticle']}"/> euros </p>
        </div>
        <div class="card-action">
          <a href="#">Ajouter au panier</a><i class="material-icons right">send</i>
        </div>
      </div>
    </div>
  </div>
 

</c:forEach>   



  
