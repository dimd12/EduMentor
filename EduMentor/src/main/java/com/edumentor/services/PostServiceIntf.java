package com.edumentor.services;

import com.edumentor.models.Post;
import java.sql.Date;
import java.util.List;

/**
 * Service interface for managing {@link Post} entities.
 * Provides methods for saving, deleting, and retrieving posts,
 * as well as finding posts by various criteria such as user ID, category ID, title, or date range.
 * 
 * This interface defines the contract for any implementation handling post-related operations.
 * 
 * @author adrian
 */
public interface PostServiceIntf {

    /**
     * Saves a new {@link Post} to the system.
     *
     * @param post The {@link Post} object to be saved.
     */
    void save(Post post);

    /**
     * Deletes an existing {@link Post} by its unique ID.
     *
     * @param postId The ID of the {@link Post} to be deleted.
     */
    void delete(int postId);

    /**
     * Retrieves all {@link Post} entities from the system.
     *
     * @return A {@link List} of all {@link Post} objects.
     */
    List<Post> findAll();

    /**
     * Finds a specific {@link Post} by its unique ID.
     *
     * @param postId The ID of the {@link Post} to be retrieved.
     * @return The {@link Post} object if found, or null if no such ID exists.
     */
    Post findById(int postId);

    /**
     * Retrieves all {@link Post} entities associated with a specific user by their user ID.
     *
     * @param userId The ID of the user whose posts are to be retrieved.
     * @return A {@link List} of {@link Post} objects created by the specified user.
     */
    List<Post> findByUserId(int userId);

    /**
     * Retrieves all {@link Post} entities within a specific category by its category ID.
     *
     * @param categoryId The ID of the category whose posts are to be retrieved.
     * @return A {@link List} of {@link Post} objects belonging to the specified category.
     */
    List<Post> findByCategoryId(int categoryId);

    /**
     * Finds all {@link Post} entities with a title matching the given string.
     *
     * @param title The title or part of the title to search for.
     * @return A {@link List} of {@link Post} objects with titles matching the given string.
     */
    List<Post> findByTitle(String title);

    /**
     * Retrieves all {@link Post} entities created within a specific date range.
     *
     * @param dateCreated The date range to filter posts by their creation date.
     * @return A {@link List} of {@link Post} objects created within the specified date range.
     */
    List<Post> findByDateRange(Date dateCreated);

    /**
     * Uses the searchbar to search for a post.
     *
     * @param searchTerm The term entered in the text field.
     * @return The list of posts found.
     */
    List<Post> searchPosts(String searchTerm);
}
