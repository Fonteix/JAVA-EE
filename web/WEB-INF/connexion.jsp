<!--HEADER-->
<jsp:include page="Templates/header.jsp" />

<!--MESSAGE ALERTE-->
<% if (request.getAttribute("erreurConnexion")!=null) {%>
    <div class="row">
        <div class="col s8 offset-s2 center-align card-panel red accent-2"><span class="white-text flow-text"><strong>${erreurConnexion}</strong></span></div>
    </div>
<% } %>
    
<% if (request.getAttribute("deconnexion")!=null) {%>
    
    <div class="row">
        <div class="col s8 offset-s2 center-align card-panel red accent-2"><span class="white-text flow-text"><strong>${deconnexion}</strong></span></div>
    </div>
<% } %>

<% if (request.getAttribute("enregistrementOk")!=null) {%>
    
    <div class="row">
        <div class="col s8 offset-s2 center-align card-panel light-green"><span class="white-text flow-text"><strong>${enregistrementOk}</strong></span></div>
    </div>
<% } %>

<!--CONNEXION-->
<section id="connexion">
    <div class="container card-panel" style="padding: 15px;">
        <form class="col s6 center" method="POST" action="validationLogin">



            <div class="col s6 center">


                <div class="input-field col s12">
                    <i class="material-icons prefix">perm_identity</i>
                    <input id="pseudo" name="pseudo" type="text" class="validate">
                    <label for="pseudo">Pseudo</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <i class="material-icons prefix">vpn_key</i>
                    <input name="mdp" id="password" type="password" class="validate">
                    <label for="password">Mot de passe</label>
                </div>
            </div>
            <input type="submit" value="Se connecter" class="waves-effect waves-light btn"/>

        </form>
    </div>
</section>
<!--FIN CONNEXION-->
</body>
</html>
