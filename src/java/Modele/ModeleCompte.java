/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Métier.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author p1522867
 */
public class ModeleCompte {
    
    private DBConnexion dbConnexion;
    private Connection cnx;

    public ModeleCompte() {
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
    
    public Compte chargerProfil(int id) throws SQLException{
        
        dbConnexion = new DBConnexion();
        cnx = dbConnexion.getConnection();
        Compte monCompte = new Compte();
        
            String requete = "SELECT * FROM COMPTE WHERE id=?";
            PreparedStatement pstmt = cnx.prepareStatement(requete);
            pstmt.setInt(1, Integer.valueOf(id));
            
            ResultSet rst = pstmt.executeQuery();
            
            if (rst.next()){
                int num = rst.getInt(1);
                String prenom = rst.getString(2);
                String nom = rst.getString(3);
                String pseudo = rst.getString(4);
                String password = rst.getString(5);
                
                monCompte.setId(num);
                monCompte.setPrenom(prenom);
                monCompte.setNom(nom);
                monCompte.setPseudo(pseudo);
                monCompte.setMdp(password);
                
            }
            
            rst.close();
            pstmt.close();
            cnx.close();
        
        return monCompte;
    }
    
}
