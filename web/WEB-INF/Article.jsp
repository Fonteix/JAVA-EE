<%-- 
    Document   : Article
    Created on : 12 juin 2017, 08:47:08
    Author     : p1410833
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Métier.Article"%>
<jsp:include page="Templates/header.jsp" />

<!-- ARTICLES-->
<%  
// retrieve your list from the request, with casting 
ArrayList<Article> list = (ArrayList<Article>) request.getAttribute("listeArticle");

// print the information about every category of the list
for(Article article : list) {
    out.println(article.getNumArticle());
    out.println(article.getNomArticle());
    out.println(article.getPrixArticle());
    out.println(article.getTypeArticle());
}
%>

<c:forEach items="${liste}" var="Article" >

    <div class="row">
        <div class="col s12 m6">
            <div class="card">
                <div class="card-image">
                    <img class="ballons" src=""/> alt="">
                    <span class="card-title"><c:out value="${produit['nomArticle']}"/></span>
                    <a class="btn-floating halfway-fab waves-effect waves-light red"  type="submit" name="addToCart" value="Ajouter !"><i class="material-icons">add</i></a>
                </div>
                <div class="card-content">
                    <p> <c:out value="${produit['prixArticle']}"/> euros </p>
                </div>
            </div>
        </div>
    </div>

</c:forEach>   


</body>
</html>
