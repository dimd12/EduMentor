/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edumentor.servlets.cms;

import com.edumentor.models.Category;
import com.edumentor.models.Post;
import com.edumentor.models.Question;
import com.edumentor.models.User;
import com.edumentor.services.CategoryServiceIntf;
import com.edumentor.services.PostServiceIntf;
import com.edumentor.services.QuestionServiceIntf;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.CategoryServiceImpl;
import com.edumentor.services.impl.PostServiceImpl;
import com.edumentor.services.impl.QuestionServiceImpl;
import com.edumentor.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author adima
 */
@WebServlet(name = "cmsaddquestionserv", urlPatterns = {"/cms/cmsaddquestionserv"})
public class cmsaddquestionserv extends HttpServlet {

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

            if (currentUser == null) {
                throw new Exception("The user is null");
            }

            UserServiceIntf userService = UserServiceImpl.getInstance();
            User user = userService.findByUsername(currentUser);

            if (user == null) {
                throw new Exception("The user is null");
            }

            CategoryServiceIntf categoryService = CategoryServiceImpl.getInstance();
            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryList", categoryList);

            request.setAttribute("user", user);

            String title = request.getParameter("title");
            String details = request.getParameter("details");
            String imageUrl = request.getParameter("imageUrl");
            String categoryId = request.getParameter("category"); // Get the category ID from the request

            if(title == null || title.isEmpty() ||
                    categoryId == null || categoryId.isEmpty()){
                request.setAttribute("message", "Please fill all the fields");
                request.getRequestDispatcher("WEB-INF/pages/cms/cmsaddquestion.jsp").forward(request, response);
                return;
            }

            // Find the Category object based on the ID
            Category selectedCategory = null;
            try {
                int categoryIdInt = Integer.parseInt(categoryId); // Convert to integer
                selectedCategory = categoryService.findById(categoryIdInt); // Retrieve category by ID

                if (selectedCategory == null) {
                    throw new Exception("Invalid category selected");
                }

            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid category ID format.");
                request.getRequestDispatcher("WEB-INF/pages/cms/cmsaddquestion.jsp").forward(request, response);
                return;
            } catch (Exception e) {
                request.setAttribute("message", "Error finding category: " + e.getMessage());
                request.getRequestDispatcher("WEB-INF/pages/cms/cmsaddquestion.jsp").forward(request, response);
                return;
            }



            Question question = new Question();
            question.setTitle(title);
            question.setDetails(details);
            question.setImageUrl(imageUrl);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
            question.setDateCreated(ourJavaDateObject);

            question.setCategoryId(selectedCategory);
            question.setUserId(user);

            try{
                questionService.save(question);
                response.sendRedirect("/admin/questions.html");
            } catch(Exception ex){
                request.setAttribute("message", "Error saving post: " + ex.getMessage());
                request.getRequestDispatcher("/WEB-INF/pages/cms/cmsaddquestion.jsp").forward(request, response);
                return;
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
    }// </editor-fold>

}
