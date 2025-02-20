/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edumentor.servlets.cms;

import com.edumentor.models.*;
import com.edumentor.services.*;
import com.edumentor.services.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author adima
 */
@WebServlet(name = "cmspostreviewserv", urlPatterns = {"/cms/cmspostreviewserv"})
public class cmspostreviewserv extends HttpServlet {

    PostServiceIntf postService = PostServiceImpl.getInstance();
    ReviewServiceIntf reviewService = ReviewServiceImpl.getInstance();


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

            String postIdStr = request.getParameter("postId");
            String ratingStr = request.getParameter("rating");
            String reviewMessage = request.getParameter("reviewMessage");

            if (postIdStr == null || postIdStr.isEmpty() || ratingStr == null || ratingStr.isEmpty() || reviewMessage == null || reviewMessage.isEmpty() ) {
                request.setAttribute("message", "Post ID and Response Text are required.");
                String questionViewUrl = "/cms/view-post.html?id=" + postIdStr;
                request.getRequestDispatcher(questionViewUrl).forward(request, response);
                return;
            }

            try{
                Integer postId = Integer.parseInt(postIdStr);
                Post post = postService.findById(postId);
                if(post == null){
                    request.setAttribute("message", "Post not found.");
                    String questionViewUrl = "/cms/view-post.html?id=" + postIdStr;
                    request.getRequestDispatcher(questionViewUrl).forward(request, response);
                    return;
                }

                Review review = new Review();
                review.setRating(Integer.parseInt(ratingStr));
                review.setUserId(user);
                review.setPostId(post);
                review.setReviewMessage(reviewMessage);
                java.util.Date utilDate = Calendar.getInstance().getTime();
                Date sqlDate = new Date(utilDate.getTime());
                review.setDateSent(sqlDate);

                reviewService.save(review);
                response.sendRedirect("/cms/view-post.html?id=" + postIdStr);
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid Post ID format.");
                String postViewUrl = "/cms/view-post.html?id=" + postIdStr;
                request.getRequestDispatcher(postViewUrl).forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", "Error saving review: " + e.getMessage());
                String postViewUrl = "/cms/view-post.html?id=" + postIdStr;
                request.getRequestDispatcher(postViewUrl).forward(request, response);
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
