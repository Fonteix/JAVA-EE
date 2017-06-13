<jsp:include page="Templates/header.jsp" />

<c:forEach items="${liste}" var="Article" >
    <ul class="collection">
        <li class="collection-item avatar">
            <img src="images/yuna.jpg" alt="" class="circle">
            <span class="title">nomArticle</span>
            <p>type article <br>
                Prix/Unité: <c:out value="${articlesPanier.unitCost}"/> euros</BR>
        </p>
        </li>
    </ul>
</c:forEach> 

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
        </li>
    </ul>
</div>
