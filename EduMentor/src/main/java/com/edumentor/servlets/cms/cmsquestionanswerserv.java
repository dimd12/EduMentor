/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edumentor.servlets.cms;

import com.edumentor.models.Answer;
import com.edumentor.models.Category;
import com.edumentor.models.Question;
import com.edumentor.models.User;
import com.edumentor.services.AnswerServiceIntf;
import com.edumentor.services.CategoryServiceIntf;
import com.edumentor.services.QuestionServiceIntf;
import com.edumentor.services.UserServiceIntf;
import com.edumentor.services.impl.AnswerServiceImpl;
import com.edumentor.services.impl.CategoryServiceImpl;
import com.edumentor.services.impl.QuestionServiceImpl;
import com.edumentor.services.impl.UserServiceImpl;

import java.io.IOException;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adima
 */
@WebServlet(name = "cmsquestionanswerserv", urlPatterns = {"/cms/cmsquestionanswerserv"})
public class cmsquestionanswerserv extends HttpServlet {

    QuestionServiceIntf questionService = QuestionServiceImpl.getInstance();
    AnswerServiceIntf answerService = AnswerServiceImpl.getInstance();


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

            String questionIdStr = request.getParameter("questionId");
            String questionResponse = request.getParameter("response");
            String imageUrl = request.getParameter("imageUrl");

            if (questionIdStr == null || questionIdStr.isEmpty() || questionResponse == null || questionResponse.isEmpty()) {
                request.setAttribute("message", "Question ID and Response Text are required.");
                String questionViewUrl = "/cms/view-question.html?id=" + questionIdStr;
                request.getRequestDispatcher(questionViewUrl).forward(request, response);
                return;
            }

            try{
                Integer questionId = Integer.parseInt(questionIdStr);
                Question question = questionService.findById(questionId);
                if(question == null){
                    request.setAttribute("message", "Question not found.");
                    String questionViewUrl = "/cms/view-question.html?id=" + questionIdStr;
                    request.getRequestDispatcher(questionViewUrl).forward(request, response);
                    return;
                }

                Answer answer = new Answer();
                answer.setQuestionId(question);
                answer.setUserId(user);
                answer.setResponse(questionResponse);
                answer.setImageUrl(imageUrl);
                java.util.Date utilDate = Calendar.getInstance().getTime();
                Date sqlDate = new Date(utilDate.getTime());
                answer.setDateCreated(sqlDate);

                answerService.save(answer);
                response.sendRedirect("/cms/view-question.html?id=" + questionId);
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid Question ID format.");
                String questionViewUrl = "/cms/view-question.html?id=" + questionIdStr;
                request.getRequestDispatcher(questionViewUrl).forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", "Error saving answer: " + e.getMessage());
                String questionViewUrl = "/cms/view-question.html?id=" + questionIdStr;
                request.getRequestDispatcher(questionViewUrl).forward(request, response);
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
