package com.edumentor.servlets;

import com.edumentor.models.Role;
import com.edumentor.models.User;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author adrian
 */
@WebServlet(name = "cmssignupserv", urlPatterns = {"/cmssignupserv"})
public class cmssignupserv extends HttpServlet {

    UserServiceIntf userService = UserServiceImpl.getInstance();

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
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        // Email regex pattern
        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        if(username == null || username.isEmpty() ||
                email == null || email.isEmpty() ||
                firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                password == null || password.isEmpty()) {

            request.setAttribute("message", "Please fill all the fields");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }

        if (username.length() < 4) {
            request.setAttribute("message", "Username must be at least 4 characters long");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }

        if (!Pattern.matches(emailPattern, email)) {
            request.setAttribute("message", "Please enter a valid email address");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setProfilePictureUrl("https://th.bing.com/th/id/OIP.hGSCbXlcOjL_9mmzerqAbQHaHa?rs=1&pid=ImgDetMain");
        user.setBio(null);
        user.setRoleId(new Role(2));

        try {
            userService.save(user);
            response.sendRedirect("login.html");
        } catch (Exception ex) {
            request.setAttribute("message", "Error saving user: " + ex.getMessage());
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
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
