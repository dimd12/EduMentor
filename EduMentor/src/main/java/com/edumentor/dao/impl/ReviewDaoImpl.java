package com.edumentor.dao.impl;

import com.edumentor.dao.ReviewDaoIntf;
import com.edumentor.db.DataSource;
import com.edumentor.models.Review;
import com.edumentor.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Implementation of the {@link ReviewDaoIntf} interface.
 * Provides methods for interacting with the database to perform CRUD operations on {@link Review} entities.
 * This class uses a singleton pattern to ensure a single instance is used throughout the application.
 * 
 * Handles operations such as saving, deleting, and retrieving reviews based on sender or receiver IDs.
 * 
 * @author adrian
 */
public class ReviewDaoImpl implements ReviewDaoIntf {

    private static final Logger LOG = Logger.getLogger(ReviewDaoImpl.class.getName());

    // Singleton instance of the DataSource
    private final DataSource dataSource = DataSource.getInstance();

    /**
     * Private constructor to prevent instantiation.
     * Use {@link #getInstance()} to get the singleton instance of this class.
     */
    private ReviewDaoImpl() {
    }

    /**
     * Returns the singleton instance of {@link ReviewDaoImpl}.
     *
     * @return The singleton instance of {@link ReviewDaoImpl}.
     */
    public static ReviewDaoImpl getInstance() {
        return ReviewDaoImplHolder.INSTANCE;
    }

    /**
     * Saves a new review to the database.
     *
     * @param review The {@link Review} object to be saved.
     */
    @Override
    public void save(Review review) {
        String sql = "INSERT INTO reviews (rating, review_sender_id, review_receiver_id, review_message, date_sent) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, review.getRating());
            statement.setInt(2, review.getReviewSenderId().getUserId());
            statement.setInt(3, review.getReviewReceiverId().getUserId());
            statement.setString(4, review.getReviewMessage());
            statement.setDate(5, review.getDateSent());

            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.severe("Error saving review: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes a review from the database by its unique ID.
     *
     * @param reviewId The ID of the review to be deleted.
     */
    @Override
    public void delete(int reviewId) {
        String sql = "DELETE FROM reviews WHERE review_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reviewId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.severe("Error deleting review: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all reviews from the database.
     *
     * @return A {@link List} of all {@link Review} objects in the database.
     */
    @Override
    public List<Review> findAll() {
        String sql = "SELECT * FROM reviews";
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                reviews.add(mapResultSetToReview(rs));
            }
        } catch (SQLException e) {
            LOG.severe("Error finding all reviews: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return reviews;
    }

    /**
     * Finds a specific review in the database by its unique ID.
     *
     * @param reviewId The ID of the review to be retrieved.
     * @return The {@link Review} object if found, or null if no review exists with the given ID.
     */
    @Override
    public Review findById(int reviewId) {
        String sql = "SELECT * FROM reviews WHERE review_id = ?";
        Review review = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reviewId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    review = mapResultSetToReview(rs);
                }
            }
        } catch (SQLException e) {
            LOG.severe("Error finding review by ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return review;
    }

    /**
     * Retrieves all reviews sent by a specific user (review sender).
     *
     * @param reviewSenderId The ID of the user who sent the reviews.
     * @return A {@link List} of {@link Review} objects associated with the given sender.
     */
    @Override
    public List<Review> findBySenderId(int reviewSenderId) {
        String sql = "SELECT * FROM reviews WHERE review_sender_id = ?";
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reviewSenderId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    reviews.add(mapResultSetToReview(rs));
                }
            }
        } catch (SQLException e) {
            LOG.severe("Error finding reviews by sender ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return reviews;
    }

    /**
     * Retrieves all reviews received by a specific user (review receiver).
     *
     * @param reviewReceiverId The ID of the user who received the reviews.
     * @return A {@link List} of {@link Review} objects associated with the given receiver.
     */
    @Override
    public List<Review> FindByReceiverId(int reviewReceiverId) { // Note: Method name should be `findByReceiverId` for consistency.
        String sql = "SELECT * FROM reviews WHERE review_receiver_id = ?";
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reviewReceiverId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    reviews.add(mapResultSetToReview(rs));
                }
            }
        } catch (SQLException e) {
            LOG.severe("Error finding reviews by receiver ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return reviews;
    }

    /**
     * Maps a {@link ResultSet} row to a {@link Review} object.
     *
     * @param rs The {@link ResultSet} containing data from a query result row.
     * @return A {@link Review} object populated with data from the current row of the ResultSet.
     */
    private Review mapResultSetToReview(ResultSet rs) throws SQLException {
        Review review = new Review();
        
        // Populate fields from ResultSet into a Review object
        review.setReviewId(rs.getInt("review_id"));
        review.setRating(rs.getInt("rating"));

        User sender = new User();
        sender.setUserId(rs.getInt("review_sender_id"));
        review.setReviewSenderId(sender);

        User receiver = new User();
        receiver.setUserId(rs.getInt("review_receiver_id"));
        review.setReviewReceiverId(receiver);

        review.setReviewMessage(rs.getString("review_message"));
        review.setDateSent(rs.getDate("date_sent"));

        return review;
    }

    /**
     * Inner static class responsible for holding the singleton instance of {@link ReviewDaoImpl}.
     */
    private static class ReviewDaoImplHolder {

        private static final ReviewDaoImpl INSTANCE = new ReviewDaoImpl();
    }
}
