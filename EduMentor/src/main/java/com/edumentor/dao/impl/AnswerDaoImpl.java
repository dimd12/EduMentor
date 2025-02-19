package com.edumentor.dao.impl;

import com.edumentor.dao.AnswerDaoIntf;
import com.edumentor.db.DataSource;
import com.edumentor.models.Answer;
import com.edumentor.models.Question;
import com.edumentor.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class AnswerDaoImpl implements AnswerDaoIntf {

    private static final Logger LOG = Logger.getLogger(AnswerDaoImpl.class.getName());
    
    private final DataSource dataSource = DataSource.getInstance();
    
    private AnswerDaoImpl() {
    }
    
    public static AnswerDaoImpl getInstance() {
        return AnswerDaoImplHolder.INSTANCE;
    }

    @Override
    public void save(Answer answer) {
        String sql = "INSERT INTO answers (question_id, user_id, response, image_url, date_created) " +
                "VALUES (?, ?, ?, ?, ?) ";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, answer.getQuestionId().getQuestionId());
            statement.setInt(2, answer.getUserId().getUserId());
            statement.setString(3, answer.getResponse());
            statement.setString(4, answer.getImageUrl());
            statement.setDate(5, answer.getDateCreated());

            statement.executeUpdate();
            
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error saving answer: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int answerId) {
        String sql = "DELETE FROM answers WHERE answer_id = ?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, answerId);

            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error deleting answer: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static final String BASE_ANSWER_QUERY =
            "SELECT * FROM answers " +
                    "LEFT JOIN questions ON answers.question_id = questions.question_id " +
                    "LEFT JOIN users ON answers.user_id = users.user_id ";

    @Override
    public List<Answer> findByQuestionId(int questionId) {
        String sql = BASE_ANSWER_QUERY + "WHERE answers.question_id = ?";
        List<Answer> answers = new ArrayList<>();
        Answer answer = null;
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, questionId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    answer = mapResultSetToAnswer(rs);
                    answers.add(answer);
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error finding answers by question ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return answers;
    }

    @Override
    public List<Answer> findByUserId(int userId) {
        String sql = BASE_ANSWER_QUERY + "WHERE user_id = ?";
        List<Answer> answers = new ArrayList<>();
        Answer answer = null;
        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    answer = mapResultSetToAnswer(rs);
                    answers.add(answer);
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOG.severe("Error finding answers by user ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return answers;
    }

    private Answer mapResultSetToAnswer(ResultSet rs) throws SQLException {
        Answer answer = new Answer();

        answer.setAnswerId(rs.getInt("answer_id"));

        Question question = new Question();
        question.setQuestionId(rs.getInt("question_id"));
        answer.setQuestionId(question);

        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        answer.setUserId(user);

        answer.setResponse(rs.getString("response"));
        answer.setImageUrl(rs.getString("image_url"));
        answer.setDateCreated(rs.getDate("date_created"));

        return answer;
    }

    private static class AnswerDaoImplHolder {

        private static final AnswerDaoImpl INSTANCE = new AnswerDaoImpl();
    }
}
