package com.edumentor.services;

import com.edumentor.models.Review;
import java.util.List;

/**
 * Service interface for managing {@link Review} entities.
 * Provides methods for saving, deleting, and retrieving reviews,
 * as well as finding reviews by sender or receiver IDs.
 * 
 * This interface defines the contract for any implementation handling review-related operations.
 * 
 * @author adrian
 */
public interface ReviewServiceIntf {

    /**
     * Saves a new {@link Review} to the system.
     *
     * @param review The {@link Review} object to be saved.
     */
    void save(Review review);

    /**
     * Deletes an existing {@link Review} by its unique ID.
     *
     * @param reviewId The ID of the {@link Review} to be deleted.
     */
    void delete(int reviewId);

    /**
     * Retrieves all {@link Review} entities from the system.
     *
     * @return A {@link List} of all {@link Review} objects.
     */
    List<Review> findAll();

    /**
     * Finds a specific {@link Review} by its unique ID.
     *
     * @param reviewId The ID of the {@link Review} to be retrieved.
     * @return The {@link Review} object if found, or null if no such ID exists.
     */
    Review findById(int reviewId);

    /**
     * Retrieves all {@link Review} entities sent by a specific user, identified by their user ID.
     *
     * @param reviewSenderId The ID of the user who sent the reviews.
     * @return A {@link List} of {@link Review} objects sent by the specified user.
     */
    List<Review> findBySenderId(int reviewSenderId);

    /**
     * Retrieves all {@link Review} entities received by a specific user, identified by their user ID.
     *
     * @param reviewReceiverId The ID of the user who received the reviews.
     * @return A {@link List} of {@link Review} objects received by the specified user.
     */
    List<Review> FindByReceiverId(int reviewReceiverId);
}
