<!--HEADER-->
<jsp:include page="Templates/header.jsp" />        
    
    <!--SITE-->

    <div class="parallax-container">
        <div class="parallax"><img src="image/image1.png"></div>
        <% if(session.getAttribute("id")!=null){%>
            <div class="row">
                <div class="col s8 offset-s2 center-align card-panel light-green"><span class="white-text flow-text"><strong>Vous êtes connecté</strong></span></div>
            </div>
        <% } %>
    </div>
    <div class="section white">
        <div class="row container">
            <h2 class="header">POKESHOP</h2>
        </div>
        <section id="connexion">
            <div class="row">
                <div class="col s12 center">
                    <ul class="tabs">
                        <li class="tab col s3"><a href="#test1">Pokeballs</a></li>
                        <li class="tab col s3"><a class="active" href="#test2">Pokemons</a></li>
                        <li class="tab col s3"><a href="#test3">Objets</a></li>
                    </ul>
                </div>
                <div id="test1" class="col s12">
                    <a href="./Articles"><img src="image/image3.png" style="width:40px;height:40px;">Voir toutes les pokeballs</a></div>
                <div id="test2" class="col s12"><a href="./Articles"><img src="image/image4.png" style="width:40px;height:40px;">Voir tous les pokemons</a></div>
                <div id="test3" class="col s12"><a href="./Articles"><img src="image/image5.png" style="width:40px;height:40px;">Voir tous les objets</div>
            </div>
        </section>
        <script> $(document).ready(function () {
                $('ul.tabs').tabs();
            });</script>
        <script>$(document).ready(function () {
                $('ul.tabs').tabs('select_tab', 'tab_id');
            });</script>

    </div>
    <div class="parallax-container">
        <div class="parallax"><img src="image/image2.png"></div>
    </div>
    <script> $(document).ready(function () {
            $('.parallax').parallax();
        });</script>

    <script>$( document ).ready(function(){ $(".button-collapse").sideNav();})</script>      
</body>
</html>