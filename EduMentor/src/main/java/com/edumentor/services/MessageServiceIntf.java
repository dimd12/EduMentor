package com.edumentor.services;

import com.edumentor.models.Message;
import java.util.List;

/**
 * Service interface for managing {@link Message} entities.
 * Provides methods for adding, retrieving, deleting, and counting messages.
 * This interface defines the contract for any implementation handling message-related operations.
 * 
 * @author adrian
 */
public interface MessageServiceIntf {

    /**
     * Adds a new {@link Message} to the system.
     *
     * @param message The {@link Message} object to be added.
     */
    void addMessage(Message message);

    /**
     * Retrieves a specific {@link Message} by its unique ID.
     *
     * @param messageId The ID of the {@link Message} to be retrieved.
     * @return The {@link Message} object if found, or null if no such ID exists.
     */
    Message getMessageById(int messageId);

    /**
     * Retrieves all {@link Message} objects associated with a specific user by their user ID.
     *
     * @param userId The ID of the user whose messages are to be retrieved.
     * @return A {@link List} of {@link Message} objects sent or received by the specified user.
     */
    List<Message> getMessagesByUserId(int userId);

    /**
     * Retrieves all {@link Message} objects exchanged between two users.
     *
     * @param senderId   The ID of the sender user.
     * @param receiverId The ID of the receiver user.
     * @return A {@link List} of {@link Message} objects exchanged between the two users.
     */
    List<Message> getMessagesBetweenUsers(int senderId, int receiverId);

    /**
     * Deletes a specific {@link Message} by its unique ID.
     *
     * @param messageId The ID of the {@link Message} to be deleted.
     */
    void deleteMessage(int messageId);

    /**
     * Counts the number of messages associated with a specific user by their user ID.
     *
     * @param userId The ID of the user whose messages are to be counted.
     * @return The total number of messages associated with the specified user.
     */
    int countMessagesByUserId(int userId);

    /**
     * Retrieves a limited number of recent {@link Message} objects for a specific user.
     *
     * @param userId The ID of the user whose recent messages are to be retrieved.
     * @param limit  The maximum number of recent messages to retrieve.
     * @return A {@link List} of recent {@link Message} objects for the specified user, up to the given limit.
     */
    List<Message> getRecentMessages(int userId, int limit);
}
