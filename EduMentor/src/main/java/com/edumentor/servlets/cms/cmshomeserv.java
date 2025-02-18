package com.edumentor.servlets.cms;

import com.edumentor.db.DataSource;
import com.edumentor.models.User;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author adrian
 */
public class cmshomeserv extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            if (session == null) {
                throw new Exception("Session not found");
            }

            String currentUser = (String) session.getAttribute("CURRENTUSER");

            if (currentUser == null) {
                throw new Exception("The user is null");
            }

            UserServiceIntf userService = UserServiceImpl.getInstance();
            User user = userService.findByUsername(currentUser);

            if (user == null) {
                throw new Exception("The user is null");
            }

            request.setAttribute("user", user);

            String path = "/WEB-INF/pages/cms/cmsindex.jsp";
            request.getRequestDispatcher(path).forward(request, response);

        } catch (Exception ex) {
            response.sendRedirect("../login.html");
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
