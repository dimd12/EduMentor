package com.edumentor.servlets.cms;

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

@WebServlet(name = "cmsprofileeditserv", urlPatterns = {"/cms/cmsprofileeditserv"})
public class cmsprofileeditserv extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("CURRENTUSER") == null) {
                request.setAttribute("errorMessage", "You must be logged in to edit your profile.");
                request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
                return;
            }

            String currentUser = (String) session.getAttribute("CURRENTUSER");
            UserServiceIntf userService = UserServiceImpl.getInstance();
            User user = userService.findByUsername(currentUser);

            if (user == null) {
                throw new Exception("User not found.");
            }

            System.out.println(request.getParameter("firstName"));

            String newFirstName = request.getParameter("firstName");
            System.out.println("newFirstName: " + newFirstName);
            String newLastName = request.getParameter("lastName");
            System.out.println("newLastName: " + newLastName);
            String newEmail = request.getParameter("email");
            System.out.println("newEmail: " + newEmail);
            String newBio = request.getParameter("bio");
            System.out.println("newBio: " + newBio);
            String newProfilePictureUrl = request.getParameter("profilePictureUrl");
            System.out.println("newProfilePictureUrl: " + newProfilePictureUrl);

            if(newEmail == null || newEmail.isEmpty()){
                newEmail = user.getEmail();
            } else if (!newEmail.equals(user.getEmail())) {
                user.setEmail(newEmail);
            }

            if(newFirstName == null || newFirstName.isEmpty()){
                newFirstName = user.getFirstName();
            } else if (!newFirstName.equals(user.getFirstName())) {
                user.setFirstName(newFirstName);
            }

            if(newLastName == null || newLastName.isEmpty()){
                newLastName = user.getLastName();
            } else if (!newLastName.equals(user.getLastName())) {
                user.setLastName(newLastName);
            }

            user.setBio(newBio);

            if(newProfilePictureUrl == null || newProfilePictureUrl.isEmpty()){
                newProfilePictureUrl = ("https://th.bing.com/th/id/OIP.hGSCbXlcOjL_9mmzerqAbQHaHa?rs=1&pid=ImgDetMain");
                user.setProfilePictureUrl(newProfilePictureUrl);
            } else if (!newProfilePictureUrl.equals(user.getProfilePictureUrl())) {
                user.setProfilePictureUrl(newProfilePictureUrl);
            }

            try {
                userService.update(user);
                response.sendRedirect("profile.html");
            } catch (Exception ex) {
                request.setAttribute("message", "Error saving user: " + ex.getMessage());
                request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
            }

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
    }
}    // </editor-fold>