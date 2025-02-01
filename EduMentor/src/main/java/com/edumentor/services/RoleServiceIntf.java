package com.edumentor.services;

import com.edumentor.models.Role;
import java.util.List;

/**
 * Service interface for managing {@link Role} entities.
 * Provides methods for adding, deleting, and retrieving roles,
 * as well as finding roles by their unique ID or name.
 * 
 * This interface defines the contract for any implementation handling role-related operations.
 * 
 * @author adrian
 */
public interface RoleServiceIntf {

    /**
     * Adds a new {@link Role} to the system.
     *
     * @param role The {@link Role} object to be added.
     */
    void add(Role role);

    /**
     * Deletes an existing {@link Role} by its unique ID.
     *
     * @param roleId The ID of the {@link Role} to be deleted.
     */
    void delete(int roleId);

    /**
     * Retrieves all {@link Role} entities from the system.
     *
     * @return A {@link List} of all {@link Role} objects.
     */
    List<Role> findAll();

    /**
     * Finds a specific {@link Role} by its unique ID.
     *
     * @param roleId The ID of the {@link Role} to be retrieved.
     * @return The {@link Role} object if found, or null if no such ID exists.
     */
    Role findById(int roleId);

    /**
     * Finds a specific {@link Role} by its name.
     *
     * @param roleName The name of the {@link Role} to be retrieved.
     * @return The {@link Role} object if found, or null if no such name exists.
     */
    Role findByName(String roleName);
}
