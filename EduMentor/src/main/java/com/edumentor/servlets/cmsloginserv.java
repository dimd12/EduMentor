package com.edumentor.servlets;

import com.edumentor.models.User;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrian
 */
@WebServlet(name = "cmsloginserv", urlPatterns = {"/cmsloginserv"})
public class cmsloginserv extends HttpServlet {

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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String path;
        
        try{
            validateFields(username, password);
            autentificateUser(username, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("CURRENTUSER", username);
            
            path = "/cms/index.html";
            response.sendRedirect(path);
            
        } catch(Exception ex){
            request.setAttribute("errorMessage", ex);
            path = "WEB-INF/pages/login.jsp";
            request.getRequestDispatcher(path).forward(request, response);
        }
        
    }
    
    private void validateFields(String username, String password) throws Exception{
        if (username.length() < 4 || password.length() < 4){
            throw new Exception("Values must include at least 4 characters");
        }
    }
    
    private void autentificateUser(String username, String password) throws Exception {
        UserServiceIntf userService = UserServiceImpl.getInstance();
        
        User user = userService.findByUsername(username);
        
        if(user == null || !user.getPassword().equals(password)) {
            throw new Exception("Login info wrong");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
