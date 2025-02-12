package com.edumentor.services.impl;

import com.edumentor.dao.PostDaoIntf;
import com.edumentor.dao.QuestionDaoIntf;
import com.edumentor.dao.impl.PostDaoImpl;
import com.edumentor.dao.impl.QuestionDaoImpl;
import com.edumentor.models.Post;
import com.edumentor.models.Question;
import com.edumentor.services.PostServiceIntf;
import com.edumentor.services.QuestionServiceIntf;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author adrian
 */
public class QuestionServiceImpl implements QuestionServiceIntf {

    // Reference to the DAO layer for post operations
    private final QuestionDaoIntf questionDao = QuestionDaoImpl.getInstance();

    /**
     * Private constructor to prevent instantiation.
     * Use {@link #getInstance()} to access the singleton instance of this class.
     */
    private QuestionServiceImpl() {
    }

    /**
     * Returns the singleton instance of {@link PostServiceImpl}.
     *
     * @return The singleton instance of {@link PostServiceImpl}.
     */
    public static QuestionServiceImpl getInstance() {
        return QuestionServiceImplHolder.INSTANCE;
    }

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public void delete(int questionId) {
        questionDao.delete(questionId);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public Question findById(int questionId) {
        return questionDao.findById(questionId);
    }

    @Override
    public List<Question> findByUserId(int userId) {
        return questionDao.findByUserId(userId);
    }

    @Override
    public List<Question> findByCategoryId(int categoryId) {
        return questionDao.findByCategoryId(categoryId);
    }

    @Override
    public List<Question> findByTitle(String title) {
        return questionDao.findByTitle(title);
    }

    @Override
    public List<Question> findByDateRange(Date dateCreated) {
        return questionDao.findByDateRange(dateCreated);
    }


    /**
     * Inner static class responsible for holding the singleton instance of {@link PostServiceImpl}.
     */
    private static class QuestionServiceImplHolder {

        private static final QuestionServiceImpl INSTANCE = new QuestionServiceImpl();
    }
}
