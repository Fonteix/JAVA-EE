/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author p1522867
 */
public class ModelInscription {
    
    private DBConnexion dbConnexion;
    private Connection cnx;

    public ModelInscription() {
    }
    
        
    public int enregistrementInscription(String prenom, String nom, String pseudo, String mdp){
        
        dbConnexion = new DBConnexion();
        cnx = dbConnexion.getConnection();
        int id=-1;
        
        try {
            String requete = "INSERT INTO COMPTE (prenom,nom,pseudo,password) VALUE (?,?,?,?)";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            pstmt.setString(1, prenom);
            pstmt.setString(2, nom);
            pstmt.setString(3, pseudo);
            pstmt.setString(4, mdp);
            
            pstmt.executeUpdate();
            
            pstmt.close();
            cnx.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    
}
