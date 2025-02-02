package com.edumentor.services.impl;

import com.edumentor.dao.ReviewDaoIntf;
import com.edumentor.dao.impl.ReviewDaoImpl;
import com.edumentor.models.Review;
import com.edumentor.services.ReviewServiceIntf;
import java.util.List;

/**
 * Implementation of the {@link ReviewServiceIntf} interface.
 * Provides methods for managing {@link Review} entities, including saving, deleting, 
 * and retrieving reviews by various criteria such as sender ID or receiver ID.
 * 
 * This class uses a singleton pattern to ensure a single instance is used throughout the application.
 * It interacts with the {@link ReviewDaoIntf} to perform database operations.
 * 
 * @author adrian
 */
public class ReviewServiceImpl implements ReviewServiceIntf {

    // Reference to the DAO layer for review operations
    private final ReviewDaoIntf reviewDao = ReviewDaoImpl.getInstance();

    /**
     * Private constructor to prevent instantiation.
     * Use {@link #getInstance()} to access the singleton instance of this class.
     */
    private ReviewServiceImpl() {
    }

    /**
     * Returns the singleton instance of {@link ReviewServiceImpl}.
     *
     * @return The singleton instance of {@link ReviewServiceImpl}.
     */
    public static ReviewServiceImpl getInstance() {
        return ReviewServiceImplHolder.INSTANCE;
    }

    /**
     * Saves a new {@link Review} to the database.
     *
     * @param review The {@link Review} object to be saved.
     */
    @Override
    public void save(Review review) {
        reviewDao.save(review);
    }

    /**
     * Deletes an existing {@link Review} by its unique ID.
     *
     * @param reviewId The ID of the {@link Review} to be deleted.
     */
    @Override
    public void delete(int reviewId) {
        reviewDao.delete(reviewId);
    }

    /**
     * Retrieves all {@link Review} entities from the database.
     *
     * @return A {@link List} of all {@link Review} objects.
     */
    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    /**
     * Finds a specific {@link Review} by its unique ID.
     *
     * @param reviewId The ID of the {@link Review} to be retrieved.
     * @return The {@link Review} object if found, or null if no such ID exists.
     */
    @Override
    public Review findById(int reviewId) {
        return reviewDao.findById(reviewId);
    }

    /**
     * Retrieves all {@link Review} entities sent by a specific user, identified by their user ID.
     *
     * @param reviewSenderId The ID of the user who sent the reviews.
     * @return A {@link List} of {@link Review} objects sent by the specified user.
     */
    @Override
    public List<Review> findBySenderId(int reviewSenderId) {
        return reviewDao.findBySenderId(reviewSenderId);
    }

    /**
     * Retrieves all {@link Review} entities received by a specific user, identified by their user ID.
     *
     * @param reviewReceiverId The ID of the user who received the reviews.
     * @return A {@link List} of {@link Review} objects received by the specified user.
     */
    @Override
    public List<Review> FindByReceiverId(int reviewReceiverId) {
        return reviewDao.FindByReceiverId(reviewReceiverId);
    }

    /**
     * Inner static class responsible for holding the singleton instance of {@link ReviewServiceImpl}.
     */
    private static class ReviewServiceImplHolder {

        private static final ReviewServiceImpl INSTANCE = new ReviewServiceImpl();
    }
}
