package com.edumentor.servlets;

import com.edumentor.models.Category;
import com.edumentor.services.CategoryServiceIntf;
import com.edumentor.services.impl.CategoryServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to display the about page.
 * Retrieves and sets the list of categories as a request attribute before forwarding to the about page.
 *
 * @author adrian
 */
@WebServlet(name = "aboutserv", urlPatterns = {"/aboutserv"})
public class aboutserv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * <p>This method retrieves the list of all categories using {@link CategoryServiceIntf},
     * sets the category list as a request attribute, and forwards the request to the about page.</p>
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the category service implementation
        CategoryServiceIntf categoryService = CategoryServiceImpl.getInstance();
        // Get the list of all categories
        List<Category> categoryList = categoryService.findAll();
        // Set the list of categories as an attribute of the request
        request.setAttribute("categoryList", categoryList);

        // Forward the request to the about page
        String path = "/WEB-INF/pages/about.jsp";
        request.getRequestDispatcher(path).forward(request, response);

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
        return "Servlet to display the about page";
    }// </editor-fold>

}
