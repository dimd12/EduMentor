package com.edumentor.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dispatcher extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = "";
        String pathRequest = request.getServletPath();

        switch(pathRequest){
            case "/login.html" : path = "/showloginserv"; break;
            case "/about.html" : path = "/aboutserv"; break;

            case "/cms/index.html" : path = "/cms/cmshomeserv"; break;

            case "/cms/profile.html" : path = "/cms/cmsprofileserv"; break;

            case "/cms/questions.html" : path = "/cms/cmsviewquestionsserv"; break;
            case "/cms/view-question.html" : path = "/cms/cmsviewquestionserv"; break;

            case "/cms/add-post.html" : path = "/cms/cmsshowaddpostserv"; break;
            case "/cms/add-question.html" : path = "/cms/cmsshowaddquestionserv"; break;

            case "/admin/posts.html" : path="/admin/adminpostsserv"; break;
            case "/admin/delete-post.html" : path="/admin/adminpostdeleteserv"; break;

            case "/admin/questions.html" : path="/admin/adminquestionsserv"; break;
            case "/admin/delete-question.html" : path="/admin/adminquestiondeleteserv"; break;

            case "/admin/users.html" : path="/admin/adminusersserv"; break;
            case "/admin/delete-user.html" : path="/admin/adminuserdeleteserv"; break;

            case "/cms/logout.html" : path = "/cms/cmslogoutserv"; break;

            default : path = "WEB-INF/pages/error.jsp"; break;
        }

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
        return "Short description";
    }// </editor-fold>

}