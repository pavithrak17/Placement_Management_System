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
	// User type 
	private Integer type;
	// User's password for authentication
	private String password;
	
	 /**
     * Default constructor for PavithraUser.
     * Required by JPA (Java Persistence API) for creating an empty object.
     */
	public PavithraUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Parameterized constructor for PavithraUser.
     * Allows for creating an instance of PavithraUser with all properties. 
     * id       the unique identifier for the user
     * name     the name of the user
     * type     the type of the user (role)
     * password the user's password
     */
	public PavithraUser(Integer id, String name, Integer type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
	}
	
	//Getters/Setters: Allow for accessing and modifying the fields.
	// Getter for 'id'
	public Integer getId() {
		return id;
	}
	
	// Setter for 'id'
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Getter for 'name'
	public String getName() {
		return name;
	}
	
	// Setter for 'name'
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter for 'type'
	public Integer getType() {
		return type;
	}
	
	// Setter for 'type'
	public void setType(Integer type) {
		this.type = type;
	}
	
	// Getter for 'password'
	public String getPassword() {
		return password;
	}
	
	// Setter for 'password'
	public void setPassword(String password) {
		this.password = password;
	}
}