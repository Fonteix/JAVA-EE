<%-- 
    Document   : acceuil
    Created on : 7 juin 2017, 08:59:33
    Author     : p1410833
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/materialize.css">
        <script type="application/javascript" src="js/jquery.js"></script>
        <script type="application/javascript" src="js/materialize.js"></script>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <nav>
            <div class="nav-wrapper">
                <img src="image/logo.png" style="width:150px;height:50px;">
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="./accueil">Accueil</a></li>
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
    </body>
</html>