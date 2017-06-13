package Modele;

import java.util.ArrayList;

public class ModelePanier {

    private ArrayList articlePanierListe = new ArrayList();
    private int prixTotal;

    protected void calculerPrixTotal() {
        int total = 0;
        for (int cpt = 0; cpt < articlePanierListe.size(); cpt++) {
            ModeleArticlePanier panier = (ModeleArticlePanier) articlePanierListe.get(cpt);
            total += panier.getPrixUnitaire();
        }
        setOrderTotal(total);
    }

    public void addCartItem(int numArticle, int prixUnitaire, String nomArticle) {
        ModeleArticlePanier panier = new ModeleArticlePanier();
        panier.setNumArticle(numArticle);
        panier.setPrixUnitaire(prixTotal);
        panier.setNomArticle(nomArticle);
        articlePanierListe.add(panier);
        calculerPrixTotal();
    }

    public void deleteCartItem(String strArticleIndex) {
        int articleIndex = 0;
        articleIndex = Integer.parseInt(strArticleIndex);
        articlePanierListe.remove(articleIndex); //il faut peut etre rajouter (articleIndex -1);
        calculerPrixTotal();
    }

    public int getNombreArticle() {
        return articlePanierListe.size();
    }

    public ArrayList getArticlePanier() {
        return articlePanierListe;
    }

    public int getOrderTotal() {
        return prixTotal;
    }

    public void setOrderTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

}
