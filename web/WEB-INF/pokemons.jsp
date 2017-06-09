<!-- ARTICLES-->

<c:forEach items="${liste}" var="article" >

    <div class="row">
        <div class="col s12 m6">
            <div class="card">
                <div class="card-image">
                    <img class="ballons"src="images\chaussures<c:out value="${produit['photoArticle']}"/>" alt="">
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



