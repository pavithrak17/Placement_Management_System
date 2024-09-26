package com.pavithra.placementmanagement;
import org.springframework.data.jpa.repository.JpaRepository;

/*JPARepository is exists in Spring Data JPA dependencies and it contains
 * all the CRUD operation of Spring JPA
 */
public interface PavithraUserRepository extends JpaRepository<PavithraUser,Integer>{

}