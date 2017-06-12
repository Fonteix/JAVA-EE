/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

/**
 *
 * @author p1410833
 */
public class Article {
    
     private int numArticle;
    private String nomArticle;
    private int prixArticle;
    private String typeArticle;

    public Article() {
    }
    
    public Article(int numArticle, String nomArticle, int prixArticle, String typeArticle){
        this.numArticle = numArticle;
        this.nomArticle = nomArticle;
        this.prixArticle = prixArticle ;
        this.typeArticle = typeArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public int getNumArticle() {
        return numArticle;
    }

    public int getPrixArticle() {
        return prixArticle;
    }

    public String getTypeArticle() {
        return typeArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public void setNumArticle(int numArticle) {
        this.numArticle = numArticle;
    }

    public void setPrixArticle(int prixArticle) {
        this.prixArticle = prixArticle;
    }

    public void setTypeArticle(String typeArticle) {
        this.typeArticle = typeArticle;
    }

    @Override
    public String toString() {
        return "Article{" + "numArticle=" + numArticle + ", nomArticle=" + nomArticle + ", prixArticle=" + prixArticle + ", typeArticle=" + typeArticle + '}';
    }
    
    
    
    
}
