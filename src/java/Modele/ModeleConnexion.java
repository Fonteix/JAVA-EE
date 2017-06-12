/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author p1522867
 */
public class ModeleConnexion {
    
    private DBConnexion dbConnexion;
    private Connection cnx;

    public ModeleConnexion() {
    }
    
        
    public int verificationLogin(String pseudo, String mdp){
        
        dbConnexion = new DBConnexion();
        cnx = dbConnexion.getConnection();
        int id=-1;
        
        try {
            String requete = "SELECT id FROM COMPTE WHERE pseudo= ? AND password=?";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            pstmt.setString(1, pseudo);
            pstmt.setString(2, mdp);
            
            ResultSet rst = pstmt.executeQuery();
            
            if (rst.next()){
                id = rst.getInt(1);
            }
            
            rst.close();
            pstmt.close();
            cnx.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    
}
