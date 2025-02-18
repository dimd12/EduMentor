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

            // Debug statement to print user object
            System.out.println("User before update: " + user);

            // Retrieve updated fields from form submission
            String newFirstName = request.getParameter("firstName");
            String newLastName = request.getParameter("lastName");
            String newEmail = request.getParameter("email");
            String newBio = request.getParameter("bio");
            String newProfilePictureUrl = request.getParameter("profilePictureUrl");

            // Debug statements to print retrieved parameters
            System.out.println("Retrieved First Name: " + newFirstName);
            System.out.println("Retrieved Last Name: " + newLastName);
            System.out.println("Retrieved Email: " + newEmail);
            System.out.println("Retrieved Bio: " + newBio);
            System.out.println("Retrieved Profile Picture URL: " + newProfilePictureUrl);

            // Update user object
            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
            user.setBio(newBio);
            user.setProfilePictureUrl(newProfilePictureUrl);

            // Debug statement to print updated user object
            System.out.println("Updated User Object: " + user);

            // Save changes
            userService.update(user);

            // Debug statement to print updated user object
            System.out.println("Updated User Object: " + user);

            // Set success message and redirect
            session.setAttribute("profileUpdateMessage", "Profile updated successfully.");
            response.sendRedirect(request.getContextPath() + "/cms/profile.html");

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Error updating profile: " + ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
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