package com.edumentor.servlets.cms;

import com.edumentor.models.Post;
import com.edumentor.models.Question;
import com.edumentor.models.User;
import com.edumentor.services.QuestionServiceIntf;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.QuestionServiceImpl;
import com.edumentor.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminquestionsserv", urlPatterns = {"/admin/adminquestionsserv"})
public class adminquestionsserv extends HttpServlet {

    QuestionServiceIntf questionService = QuestionServiceImpl.getInstance();

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
            System.out.println("current user: " + currentUser);


            if (currentUser == null) {
                throw new Exception("The user is null");
            }

            UserServiceIntf userService = UserServiceImpl.getInstance();
            User currentUserObj = userService.findByUsername(currentUser);
            System.out.println("Current user obj: " + currentUserObj);

            User fullUser = userService.findById(currentUserObj.getUserId());

            System.out.println("Full user: " + fullUser);

            if (currentUserObj == null) {
                throw new Exception("The user is null");
            }

            System.out.println("user role: " + currentUserObj.getRoleId().getRoleName());

            if (currentUserObj.getRoleId() == null || currentUserObj.getRoleId().getRoleName() == null) {
                throw new Exception("User role is not defined.");
            }

            String roleName = currentUserObj.getRoleId().getRoleName();
            System.out.println(roleName);

            if(roleName.equalsIgnoreCase("admin")){

                List<Question> questionList = questionService.findAll();
                request.setAttribute("questionList", questionList);

                String path = "/WEB-INF/pages/cms/adminquestions.jsp";
                request.getRequestDispatcher(path).forward(request, response);

            } else if(roleName.equalsIgnoreCase("user")){

                List<Question> questionList = questionService.findByUserId(currentUserObj.getUserId());
                request.setAttribute("questionList", questionList);

                String path = "/WEB-INF/pages/cms/adminquestions.jsp";
                request.getRequestDispatcher(path).forward(request, response);

            } else{
                throw new Exception("Invalid role");
            }
        } catch (Exception e) {
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
