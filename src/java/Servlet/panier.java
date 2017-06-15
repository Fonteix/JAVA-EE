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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class panier extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        Cookie[] cookies = request.getCookies();
        ModeleArticle monModel = new ModeleArticle();
        String leCookie="";
        List<String> listeNum;
        List<Article> listeArticle = new ArrayList<>();
        float prix=0;
                
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("panier")){
                leCookie = cookie.getValue();
                listeNum = new ArrayList<>(Arrays.asList(leCookie.split("-")));
                for(String num : listeNum){
                    listeArticle.add(monModel.selectionArticle(Integer.valueOf(num)));
                }
                request.setAttribute("listeArticle", listeArticle);
                break;
            }
        }
        for (Article article : listeArticle){
            prix+=article.getPrixArticle();
        }
        System.out.println("GET PANIER");
        request.setAttribute("prix", prix);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("WEB-INF/panier.jsp");
        rd.include(request, response);
        
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
        String vider = request.getParameter("vider");
        String valider = request.getParameter("valider");
        Cookie[] cookies = request.getCookies();
        Cookie leCookie = new Cookie("panier","");
            for(int i=0; i < cookies.length; i++) {
                Cookie cookie= cookies[i];
                if (cookie.getName().equals("panier")) {
                    leCookie = cookie;
                }
            }
            
        if (vider !=null){
            leCookie.setMaxAge(0);
            response.addCookie(leCookie);
            
        }else if (valider!=null){
            HttpSession session = request.getSession();
            if (session.getAttribute("id")==null){
                
                request.setAttribute("connexionAchat", "Veuillez vous connecter pour continuer l'achat");
                this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
            }
            request.setAttribute("confirmationAchat", "Votre achat a bien été effectué");
            leCookie.setMaxAge(0);
            response.addCookie(leCookie);
        }
        
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/panier.jsp").forward(request, response);
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
