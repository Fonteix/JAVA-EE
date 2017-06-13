<jsp:include page="Templates/header.jsp" />

<c:forEach items="${liste}" var="Article" >
<ul class="collection">
    <li class="collection-item avatar">
        <img src="images/yuna.jpg" alt="" class="circle">
        <span class="title">nomArticle</span>
        <p>type article <br>
            prix
        </p>
    </li>
</ul>
</c:forEach> 

<div class="row">
    <div class="col s12 m5">
        <div class="card-panel teal">
            <span class="white-text"> METTRE LE MONTANT DU PRIX
                <button class="btn waves-effect waves-light" type="submit" name="action">Vider le panier<i class="material-icons">delete</i></button><button class="btn waves-effect waves-light" type="submit" name="action">Valider le panier
                    <i class="material-icons right">send</i>
                </button>    
            </span>
        </div>
    </div>
</div>