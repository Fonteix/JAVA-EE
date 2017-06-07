<%-- 
    Document   : inscription
    Created on : 7 juin 2017, 08:55:19
    Author     : p1410833
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/materialize.css">
        <script type="application/javascript" src="js/jquery.js"></script>
        <script type="application/javascript" src="js/materialize.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <!-- MENU -->    
      <nav>
    <div class="nav-wrapper">
      <img src="image/logo.png" style="width:150px;height:50px;">
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="./acceuil">Accueil</a></li>
        <li><a href="badges.html">Panier</a></li>
        <li><a href="./connexion">Connexion</a></li>
        <li><a href="./inscription">Inscription</a></li>
      </ul>
       <ul class="side-nav" id="mobile-demo">
        <li><a href="./acceuil">Acceuil</a></li>
        <li><a href="badges.html">Panier</a></li>
        <li><a href="./connexion">Connexion</a></li>
        <li><a href="./inscription">Inscription</a></li>
        
      </ul>
    </div>
  </nav>
        <script>$( document ).ready(function(){ $(".button-collapse").sideNav();})</script>      
        
    <!--FIN MENU-->
    
    <!--FORMULAIRE-->
    <div class="row">
        <form class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                    <label for="first_name">Nom</label>
                </div>
                <div class="input-field col s6">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Prénom</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="password" type="password" class="validate">
                    <label for="password">Pseudo</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="email" type="email" class="validate">
                    <label for="email">Mot de passe</label>
                </div>
            </div>
        </form>
    </div>
    <!-- FIN FORMULAIRE-->
    <a class="waves-effect waves-light btn">S'inscrire</a>
    </body>
</html>
