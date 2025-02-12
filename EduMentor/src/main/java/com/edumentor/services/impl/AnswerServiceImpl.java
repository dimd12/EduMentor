package com.edumentor.services.impl;

import com.edumentor.dao.AnswerDaoIntf;
import com.edumentor.dao.impl.AnswerDaoImpl;
import com.edumentor.models.Answer;
import com.edumentor.services.AnswerServiceIntf;
import java.util.List;

/**
 * 
 * @author adrian
 */
public class AnswerServiceImpl implements AnswerServiceIntf {

    // Reference to the DAO layer for category operations
    private final AnswerDaoIntf answerDao = AnswerDaoImpl.getInstance();

    /**
     * Private constructor to prevent instantiation.
     * Use {@link #getInstance()} to access the singleton instance of this class.
     */
    private AnswerServiceImpl() {
    }

    /**
     * Returns the singleton instance of {@link AnswerServiceImpl}.
     *
     * @return The singleton instance of {@link AnswerServiceImpl}.
     */
    public static AnswerServiceImpl getInstance() {
        return AnswerServiceImplHolder.INSTANCE;
    }

    @Override
    public void save(com.edumentor.models.Answer answer) {
        answerDao.save(answer);
    }

    @Override
    public void delete(int answerId) {
        answerDao.delete(answerId);
    }

    @Override
    public List<Answer> findByQuestionId(int questionId) {
        return answerDao.findByQuestionId(questionId);
    }

    @Override
    public List<Answer> findByUserId(int userId) {
        return answerDao.findByUserId(userId);
    }


    /**
     * Inner static class responsible for holding the singleton instance of {@link AnswerServiceImpl}.
     */
    private static class AnswerServiceImplHolder {

        private static final AnswerServiceImpl INSTANCE = new AnswerServiceImpl();
    }
}
