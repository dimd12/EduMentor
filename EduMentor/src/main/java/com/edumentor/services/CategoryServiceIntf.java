package com.edumentor.services;

import com.edumentor.models.Category;
import java.util.List;

/**
 * Service interface for managing {@link Category} entities.
 * Provides methods for saving, deleting, and retrieving categories.
 * This interface defines the contract for any implementation handling category-related operations.
 * 
 * @author adrian
 */
public interface CategoryServiceIntf {

    /**
     * Saves a new {@link Category} to the system.
     *
     * @param category The {@link Category} object to be saved.
     */
    void save(Category category);

    /**
     * Deletes an existing {@link Category} by its unique ID.
     *
     * @param categoryId The ID of the {@link Category} to be deleted.
     */
    void delete(int categoryId);

    /**
     * Retrieves all {@link Category} entities from the system.
     *
     * @return A {@link List} of all {@link Category} objects.
     */
    List<Category> findAll();

    /**
     * Finds a specific {@link Category} by its unique ID.
     *
     * @param categoryId The ID of the {@link Category} to be retrieved.
     * @return The {@link Category} object if found, or null if no such ID exists.
     */
    Category findById(int categoryId);
}
