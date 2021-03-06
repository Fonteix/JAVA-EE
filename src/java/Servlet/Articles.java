/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modele.ModeleArticle;
import Métier.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p1410833
 */
@WebServlet(name = "Article", urlPatterns = {"/Article"})
public class Articles extends HttpServlet {
    
    private ModeleArticle monModel;
    private List<Article> maListe;
    private int DUREEPANIER = 60*60*24;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void init(){
    }
    
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
        
        maListe = new ArrayList<>();
        monModel = new ModeleArticle();
        monModel.chargerArticles(maListe);
        request.setAttribute("liste", maListe);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Article.jsp").forward(request, response);
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
        String numArticle = request.getParameter("numArticle");
        String nomArticle = request.getParameter("nomArticle");
        Cookie[] cookies = request.getCookies();
        Cookie oldCookie;
        Cookie newCookie;
//        Cookie cookie = new Cookie("test","HelloWorld");
//        cookie.setMaxAge(10);
//        response.addCookie(cookie);
        
        for(int i=0; i < cookies.length; i++) {
            oldCookie= cookies[i];
            if (oldCookie.getName().equals("panier")) {
                System.out.println("par ici");
                String listeArticle = cookies[i].getValue();
                List<String> listNum = new ArrayList<>(Arrays.asList(listeArticle.split("-")));
                listNum.add(numArticle);
                String listeFinale = String.join("-", listNum);
                newCookie = new Cookie("panier",listeFinale);
                newCookie.setMaxAge(3600);
                response.addCookie(newCookie);
                break;
            }
            else{
                List<String> listNum = new ArrayList<>();
                listNum.add(numArticle);
                String listeFinale = String.join("-", listNum);
                newCookie = new Cookie("panier",listeFinale);
                newCookie.setMaxAge(3600);
                response.addCookie(newCookie);
                break;
            }
            
        }
        
        maListe = new ArrayList<>();
        monModel = new ModeleArticle();
        monModel.chargerArticles(maListe);
        request.setAttribute("liste", maListe);
        request.setAttribute("ajoutPanier", "Votre article " + nomArticle+" a bien été ajouté au panier");
        this.getServletContext().getRequestDispatcher("/WEB-INF/Article.jsp").forward(request, response);
        //this.getServletContext().getRequestDispatcher("/WEB-INF/ModeleArticlePanier.jsp").forward(request, response);
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

}
