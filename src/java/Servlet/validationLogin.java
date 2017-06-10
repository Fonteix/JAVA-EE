/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modele.DBConnexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p1522867
 */
public class validationLogin extends HttpServlet {

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
        
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");
        int id = this.verificationLogin(pseudo, mdp);
        if(id>0){
            
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("pseudo", pseudo);
            response.sendRedirect("/projet/accueil");
            
        }
        else{
            request.setAttribute("erreurConnexion", "Identifiant ou mot de passe incorrect");
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
    
    private int verificationLogin(String pseudo, String mdp){
        
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
