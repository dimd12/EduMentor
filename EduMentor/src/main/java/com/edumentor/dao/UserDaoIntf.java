package com.edumentor.dao;

import com.edumentor.models.User;
import java.util.List;

/**
 * Interface for managing {@link User} entities in the database.
 * Provides methods for creating, updating, deleting, and retrieving users,
 * as well as assigning roles to users and finding users by specific criteria.
 * 
 * @author adrian
 */
public interface UserDaoIntf {

    /**
     * Saves a new user to the database.
     *
     * @param user The {@link User} object to be saved.
     */
    void save(User user);

    /**
     * Updates an existing user's details in the database.
     *
     * @param user The {@link User} object containing updated information.
     */
    void update(User user);

    /**
     * Deletes a user from the database by their unique ID.
     *
     * @param userId The ID of the user to be deleted.
     */
    void delete(int userId);

    /**
     * Retrieves all users from the database.
     *
     * @return A {@link List} of all {@link User} objects.
     */
    List<User> findAll();

    /**
     * Finds a specific user in the database by their unique ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return The {@link User} object if found, or null if no user exists with the given ID.
     */
    User findById(int userId);

    /**
     * Finds a specific user in the database by their username.
     *
     * @param username The username of the user to be retrieved.
     * @return The {@link User} object if found, or null if no user exists with the given username.
     */
    User findByUsername(String username);

    /**
     * Retrieves all users associated with a specific role.
     *
     * @param roleId The ID of the role whose associated users are to be retrieved.
     * @return A {@link List} of {@link User} objects associated with the given role.
     */
    List<User> findByRole(int roleId);

    /**
     * Assigns a specific role to a user in the database.
     *
     * @param userId The ID of the user to whom the role will be assigned.
     * @param roleId The ID of the role to be assigned to the user.
     */
    void assignRoleToUser(int userId, int roleId);
}
