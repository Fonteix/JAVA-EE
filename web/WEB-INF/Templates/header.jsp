<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/materialize.css">
        <link rel="stylesheet" href="css/moncss.css">
        <script type="application/javascript" src="js/jquery.js"></script>
        <script type="application/javascript" src="js/materialize.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--MENU-->
        <nav>
            <div class="nav-wrapper">
                <img src="image/logo.png" style="width:150px;height:50px;">
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="./accueil">Accueil</a></li>
                    <li><a href="./article"><i class="material-icons left">list</i>Article</a></li>
                    <li><a href="./panier"><i class="material-icons left">shopping_cart</i>Panier</a></li>
                        <% if (session.getAttribute("id") == null) {%>
                    <li> <a href="./connexion"><i class="material-icons left">power_settings_new</i>Connexion</a></li>
                        <% } else { %>
                    <li><a href="./deconnexion">Déconnexion</a></li>
                        <% } %>
                    <li><a href="./inscription">Inscription</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="./accueil">Acceuil</a></li>
                    <li><a href="./article">Article</a></li>
                    <li><a href="./panier">Panier</a></li>
                        <% if (session.getAttribute("id") == null) {%>
                    <li><a href="./connexion">Connexion</a></li>
                        <% } else { %>
                    <li><a href="./deconnexion">Déconnexion</a></li>
                        <% }%>
                    <li><a href="./inscription">Inscription</a></li>
                </ul>
            </div>
        </nav>
        <script>$(document).ready(function () {
                $(".button-collapse").sideNav();
            })</script>  
        <!--FIN MENU-->