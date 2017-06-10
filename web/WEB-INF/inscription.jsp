<!--FORMULAIRE-->


<c:if test="${not empty erreurNom}">
    <p>${erreurNom}</p>
</c:if>

<section id="connexion">
    <div class="container card-panel" style="padding: 15px;">
        <div class="col s6 center">
            <form method="POST" action="validationInscription">

                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_identity</i>
                    <input name="nom" id="first_name" type="text" class="validate">
                    <label for="first_name">Nom</label>
                </div>
                
                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_identity</i> 
                    <input name="prenom" id="last_name" type="text" class="validate">
                    <label for="last_name">Prenom</label>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person_pin</i> 
                        <input name="pseudo" id="pseudo" type="text" class="validate">
                        <label for="pseudo">Pseudo</label>
                    </div>
                </div>
                
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">vpn_key</i>
                        <input name="password" id="password" type="password" class="validate">
                        <label for="password">Mot de passe</label>
                    </div>
                </div>
                
                <input type="submit" value="S'inscrire" class="waves-effect waves-light btn"/>
                
            </form>
        </div>
    </div>
</section>
<!-- FIN FORMULAIRE-->


</body>
</html>







