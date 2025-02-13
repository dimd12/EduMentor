package com.edumentor.services;

import com.edumentor.models.User;
import java.util.List;

/**
 * Service interface for managing {@link User} entities.
 * Provides methods for saving, updating, deleting, and retrieving users,
 * as well as assigning roles and finding users by specific criteria.
 * 
 * This interface defines the contract for any implementation handling user-related operations.
 * 
 * @author adrian
 */
public interface UserServiceIntf {

    /**
     * Saves a new {@link User} to the system.
     *
     * @param user The {@link User} object to be saved.
     */
    void save(User user);

    /**
     * Updates an existing {@link User}'s details in the system.
     *
     * @param user The {@link User} object containing updated information.
     */
    void update(User user);

    /**
     * Deletes an existing {@link User} by their unique ID.
     *
     * @param userId The ID of the {@link User} to be deleted.
     */
    void delete(int userId);

    /**
     * Retrieves all {@link User} entities from the system.
     *
     * @return A {@link List} of all {@link User} objects.
     */
    List<User> findAll();

    /**
     * Finds a specific {@link User} by their unique ID.
     *
     * @param userId The ID of the {@link User} to be retrieved.
     * @return The {@link User} object if found, or null if no such ID exists.
     */
    User findById(int userId);

    /**
     * Finds a specific {@link User} by their username.
     *
     * @param username The username of the target {@link User}.
     * @return The {@link User} object if found, or null if no such username exists.
     */
    User findByUsername(String username);

    /**
     * Retrieves all {@link User} entities associated with a specific role ID.
     *
     * @param roleId The ID of the role whose associated users are to be retrieved.
     * @return A {@link List} of {@link User} objects associated with the given role ID.
     */
    List<User> findByRole(int roleId);

    /**
     * Assigns a specific role to a given {@link User}.
     *
     * @param userId The ID of the target {@link User}.
     * @param roleId The ID of the role to assign to the target {@link User}.
     */
    void assignRoleToUser(int userId, int roleId);

    /**
     * Finds the users similar to the search.
     *
     * @param searchTerm The term that was searched in the search bar.
     * @return The list of users with a similar username, first name, last name to the search.
     */
    List<User> searchUsers(String searchTerm);
}
