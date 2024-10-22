package com.pavithra.placementmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * This is an entity class for the PavithraUser.
 * It represents a user in the placement management system.
 * Each instance of this class corresponds to a record in the database.
 * @Entity: Marks the class as a JPA entity, 
 * meaning it will be mapped to a database table.
 */
@Entity
public class PavithraUser {
	
	// Indicates the primary key field of the entity. (unique identifier for each user)
	@Id
	private Integer id;
	// User's name
	private String name;
	// User type (e.g., admin, student, recruiter)
	private String role;
	// User's password for authentication
	private String password;
	// User's email address
	private String email;
	// User's contact number
	private String contactNumber;
	// Status to track if the user is active/inactive
	private boolean status;

	/**
	 * Default constructor for PavithraUser.
	 * Required by JPA (Java Persistence API) for creating an empty object.
	 */
	public PavithraUser() {
		super();
	}
	
	/**
	 * Parameterized constructor for PavithraUser.
	 * Allows for creating an instance of PavithraUser with all properties.
	 * @param id        the unique identifier for the user
	 * @param name      the name of the user
	 * @param role      the role/type of the user
	 * @param password  the user's password
	 * @param email     the user's email
	 * @param contactNumber the user's contact number
	 * @param status    the user's status (active/inactive)
	 */
	public PavithraUser(Integer id, String name, String role, String password, String email, String contactNumber, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.status = status;
	}
	
	// Getters and Setters for the fields
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}