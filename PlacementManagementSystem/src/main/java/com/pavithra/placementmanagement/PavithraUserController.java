package com.pavithra.placementmanagement;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * PavithraUserController is a REST controller that handles HTTP requests for user management in the placement management system.
 * It provides API endpoints for adding, updating, retrieving, and deleting users.
 */
@RestController
public class PavithraUserController {
	
	// Automatically injects the PavithraUserService implementation
	@Autowired
	private PavithraUserService service;
	
	/**
     * RESTful API to create a new user.
     * @param u the user object (PavithraUser) to be created, passed in the request body.
     */
	@PostMapping("/user")
	public void add(@RequestBody PavithraUser u)
	{
		service.create(u);// Calls the service method to create the user
	}
	
	/**
     * RESTful API to delete a user by their ID.
     * @param id the ID of the user to be deleted, passed as a path variable.
     */
	@DeleteMapping("/user/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);// Calls the service method to delete the user by ID
	}
	
	/**
     * RESTful API to retrieve a list of all users.
     * @return a list of PavithraUser objects.
     */
	@GetMapping("/user")
	public List<PavithraUser>list()
	{
		return service.listAll();// Returns the list of all users
		
	}
	
	//Retrieve with specific id
	/**
     * RESTful API to retrieve a specific user by their ID.
     * @param id the ID of the user to be retrieved, passed as a path variable.
     * @return ResponseEntity containing the user object if found, or HTTP 404 (Not Found) status if not found.
     */
	@GetMapping("/user/{id}")
	public ResponseEntity<PavithraUser> get(@PathVariable Integer id)
	{
		try {
			PavithraUser u=service.retrieve(id);// Calls service to retrieve the user by ID
			return new ResponseEntity<PavithraUser>(u,HttpStatus.OK);// Returns user object with HTTP 200 (OK) status
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<PavithraUser>(HttpStatus.NOT_FOUND);// Returns HTTP 404 status if user not found
		}
		
	}
	
	/**
     * RESTful API to update an existing user by their ID.
     * @param u  the updated user object (PavithraUser) passed in the request body.
     * @param id the ID of the user to be updated, passed as a path variable.
     * @return ResponseEntity containing the updated user object if the user exists, or HTTP 404 (Not Found) status if not found.
     */
	@PutMapping("/user/{id}")
	public ResponseEntity<PavithraUser> update(@RequestBody PavithraUser u, @PathVariable Integer id)
	{
		try {
			// Checks if the user exists by retrieving the user with the given ID
			@SuppressWarnings("unused")
			PavithraUser u1=service.retrieve(id);
			// If user exists, update the user with new details
			service.create(u);// Service method for update (reuse create method here)
			return new ResponseEntity<PavithraUser>(u,HttpStatus.OK);// Return the updated user with HTTP 200 (OK) status
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<PavithraUser>(HttpStatus.NOT_FOUND);// Return HTTP 404 if user not found
		}
	}
}