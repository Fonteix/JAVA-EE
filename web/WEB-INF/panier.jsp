<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Templates/header.jsp" />


<!--Acienne version --> 
<c:forEach items="${liste}" var="Article" >
    <ul class="collection">
        <li class="collection-item avatar">
            <img src="images/yuna.jpg" alt="" class="circle">
            <span class="title">nomArticle</span>
            <p>type article <br>
                Prix/Unit�: <c:out value="${articlesPanier.unitCost}"/> euros</BR>
        </p>
        </li>
    </ul>
</c:forEach> 

<!-- version exp�rimentale-->
<div class="col-10 panier">
    <jsp:useBean id="panier" scope="session" class="Modele.ModelePanier" />
    <ul class="collection">
        <li class="collection-item avatar">
        
                        
                        <c:out value="${panier.numArticle}"/> </BR> 
                        <!--panier viens de ModelePanier.java-->
                        <!--numArticle viens de ModeleArticlePanier-->
                           
                    
        </li>
    </ul>
</div>


<!--boutons vider/valider le panier-->
<div class="row">
    <div class="col s12 m5">
        <div class="card-panel teal">
            <span class="white-text">
                <button class="btn waves-effect waves-light" type="submit" name="action" value="Delete">Vider le panier<i class="material-icons">delete</i></button>
                <button class="btn waves-effect waves-light" type="submit" name="action">Valider le panier<i class="material-icons right">send</i></button>    
            </span>
        </div>
    </div>
</div>