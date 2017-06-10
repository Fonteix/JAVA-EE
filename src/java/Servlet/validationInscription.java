/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modele.DBConnexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class validationInscription extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DBConnexion dbConnexion;
    private Connection cnx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        
        Pattern patternTxt= Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        Pattern patternPwd = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        
        if(patternTxt.matcher(prenom).find() || patternTxt.matcher(nom).find() || prenom.trim().length()<2|| nom.trim().length()<2){
            request.setAttribute("erreurChamp", "Nom ou Prénom Incorrect !");
            getServletContext().getRequestDispatcher("/inscription").forward(request, response);
        }
        else if(patternPwd.matcher(pseudo).find() ||  pseudo.trim().length()<2 ){
            request.setAttribute("erreurChamp", "Le pseudo ne doit contenir que des lettres et des chiffres");
            getServletContext().getRequestDispatcher("/inscription").forward(request, response);
        }
        else if (patternPwd.matcher(password).find() || password.trim().length()<4){
            request.setAttribute("erreurChamp", "Le mot de passe ne doit contenir que des lettres et des chiffres et doit contenir 4 caractères au minimum");
            getServletContext().getRequestDispatcher("/inscription").forward(request, response);
        }
        else{
            enregistrementInscription(prenom,nom,pseudo,password);
            request.setAttribute("enregistrementOk", "Votre compte a bien été créé !");
            getServletContext().getRequestDispatcher("/connexion").forward(request, response);
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private int enregistrementInscription(String prenom, String nom, String pseudo, String mdp){
        
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
