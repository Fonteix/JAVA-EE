/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


import Métier.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

 

/**
 *
 * @author p1410833
 */
public class ModeleArticle {
    
    private DBConnexion dbConnexion;
    private Connection cnx;

    public ModeleArticle() {
    }
    
    public void chargerArticles(List<Article> listeArticle){
        dbConnexion = new DBConnexion();
        cnx = dbConnexion.getConnection();
        
        try {
            String requete = "SELECT * FROM ARTICLE";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            ResultSet rst = pstmt.executeQuery();
            
            while (rst.next()){
                int id = rst.getInt(1);
                String nom = rst.getString(2);
                int prix = rst.getInt(3);
                String type = rst.getString(4);
                String image = rst.getString(5);
                Article article = new Article(id, nom, prix, type, image);
                listeArticle.add(article);
            }
            
            rst.close();
            pstmt.close();
            cnx.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Article selectionArticle(int numArticle){
        dbConnexion = new DBConnexion();
        cnx = dbConnexion.getConnection();
        Article article = new Article();
        
        try {
            String requete = "SELECT numArticle, nomArticle, prixArticle, typeArticle FROM ARTICLE where numArticle = ?";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            pstmt.setInt(1, numArticle);
            ResultSet rst = pstmt.executeQuery();
            
            while (rst.next()){
                int id = rst.getInt(1);
                String nom = rst.getString(2);
                int prix = rst.getInt(3);
                String type = rst.getString(4);
                article.setNumArticle(id);
                article.setNomArticle(nom);
                article.setPrixArticle(prix);
                article.setTypeArticle(type);
            }
            
            rst.close();
            pstmt.close();
            cnx.close();
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return article;
    }
    }

