package com.pavithra.placementmanagement;

import java.util.List;

/**
 * This interface defines the contract for user-related services in the placement management system.
 * It is used to declare methods for managing users, such as getting all users, adding, updating, or deleting a user.
 * The implementation of these methods will be provided by a class that implements this interface.
 */
public interface PavithraIUserService {
	
	 /**
     * Retrieves all users from the system.
     * @return a list of PavithraUser objects representing all users.
     */
	List<PavithraUser> getAllUsers();
	
	/**
     * Retrieves a specific user based on the user ID.
     * @param id the ID of the user to be retrieved.
     * @return the PavithraUser object corresponding to the given ID.
     */
	PavithraUser getUserById(Long id);
	
    /**
     * Adds a new user to the system.
     * @param u the PavithraUser object representing the new user to be added.
     */
	void addUser(PavithraUser u);
	
	/**
     * Deletes a user from the system based on the user ID.
     * @param id the ID of the user to be deleted.
     */
	void deleteUser(Long id);
	
	/**
     * Updates an existing user in the system.
     * @param id the ID of the user to be updated.
     * @param u  the PavithraUser object containing updated user information.
     */
	void updateUser(Long id, PavithraUser u);
}

