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
<% if (request.getAttribute("ajoutPanier")!=null) {%>
    <div class="row">
        <div class="col s8 offset-s2 center-align card-panel light-green"><span class="white-text flow-text"><strong>${ajoutPanier}</strong></span></div>
    </div>
<% } %>

<c:forEach items="${liste}" var="article" >
    <form action="Articles" method="post">
        <div class="col s12 m7" style="padding:15px">
        <div class="card horizontal">
          <div class="card-image">
              <input type="hidden" name="numArticle" value ="${article['numArticle']}"/>
              <input type="hidden" name="nomArticle" value ="${article['nomArticle']}"/>
            <img alt="image" src="image/${article['imageArticle']}" <c:out value="${article['imageArticle']}"/> >
          </div>
          <div class="card-stacked">
            <div class="card-content">
                <p><c:out value="${article['nomArticle']}"/> </br>  <c:out value="${article['prixArticle']}"/> euros </p>
            </div>
            <div class="card-action">
              <button type="submit" class="btn-floating btn-large waves-effect right waves-light red"><i class="material-icons">add</i></button>
            </div>
          </div>
        </div>
      </div>
    </form>
 

</c:forEach>   



  
