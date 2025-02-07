package com.edumentor.dao.impl;

import com.edumentor.dao.QuestionDaoIntf;
import com.edumentor.db.DataSource;
import com.edumentor.models.Category;
import com.edumentor.models.Question;
import com.edumentor.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class QuestionDaoImpl implements QuestionDaoIntf {

    private static final Logger LOG = Logger.getLogger(QuestionDaoImpl.class.getName());

    private final DataSource dataSource = DataSource.getInstance();

    private QuestionDaoImpl() {
    }
    
    public static QuestionDaoImpl getInstance() {
        return QuestionDaoImplHolder.INSTANCE;
    }

    @Override
    public void save(Question question) {
        String sql = "INSERT INTO questions (user_id, title, details, image_url, date_created, category_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, question.getUserId().getUserId());
            statement.setString(2, question.getTitle());
            statement.setString(3, question.getDetails());
            statement.setString(4, question.getImageUrl());
            statement.setDate(5, question.getDateCreated());
            statement.setInt(6, question.getCategoryId().getCategoryId());

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error saving question: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int questionId) {
        String sql = "DELETE FROM questions WHERE question_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, questionId);

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error deleting question: " + e.getMessage());
        }
    }

    @Override
    public List<Question> findAll() {
        String sql = "SELECT * FROM questions";
        List<Question> questions = new ArrayList<>();
        Question question = null;
        try(Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()) {
                question = mapResultSetToQuestion(rs);
                questions.add(question);
            }
        } catch (SQLException e) {
            LOG.severe("Error finding all questions: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public Question findById(int questionId) {
        String sql = "SELECT * FROM questions WHERE question_id = ?";
        Question question = null;
        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, questionId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    question = mapResultSetToQuestion(rs);
                }
            }
        } catch (SQLException e) {
            LOG.severe("Error finding question by ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return question;
    }

    @Override
    public List<Question> findByUserId(int userId) {
        String sql = "SELECT * FROM questions WHERE user_id = ?";
        List<Question> questions = new ArrayList<>();
        Question question = null;
        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    question = mapResultSetToQuestion(rs);
                    questions.add(question);
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error finding questions by user ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public List<Question> findByCategoryId(int categoryId) {
        String sql = "SELECT * FROM questions WHERE category_id = ?";
        List<Question> questions = new ArrayList<>();
        Question question = null;
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, categoryId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    question = mapResultSetToQuestion(rs);
                    questions.add(question);
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error finding questions by category ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public List<Question> findByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findByDateRange(Date dateCreated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Question mapResultSetToQuestion(java.sql.ResultSet rs) throws SQLException {
        Question question = new Question();

        question.setQuestionId(rs.getInt("question_id"));

        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        question.setUserId(user);

        question.setTitle(rs.getString("title"));
        question.setDetails(rs.getString("details"));
        question.setImageUrl(rs.getString("image_url"));
        question.setDateCreated(rs.getDate("date_created"));

        Category category = new Category();
        category.setCategoryId(rs.getInt("category_id"));
        question.setCategoryId(category);

        return question;
    }
    
    private static class QuestionDaoImplHolder {

        private static final QuestionDaoImpl INSTANCE = new QuestionDaoImpl();
    }
}
