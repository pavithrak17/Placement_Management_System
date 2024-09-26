package com.pavithra.placementmanagement;
import org.springframework.data.jpa.repository.JpaRepository;

/**PavithraUserRepository is a repository interface for performing CRUD (Create, Read, Update, Delete) operations 
 * on the PavithraUser entity. It extends JpaRepository, which provides several methods for interacting 
 * with the database.
 * JpaRepository is part of Spring Data JPA and comes with built-in implementations of basic database operations, 
 * so there is no need to define them manually.
 * This repository will be used by the service layer to perform database operations on PavithraUser entities.
 */
public interface PavithraUserRepository extends JpaRepository<PavithraUser,Integer>{
	// No need to define methods here as JpaRepository provides built-in methods for:
    // - save() for creating or updating an entity
    // - findById() for retrieving an entity by ID
    // - findAll() for retrieving all entities
    // - deleteById() for deleting an entity by ID
    // - and more
}