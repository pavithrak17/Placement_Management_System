package com.pavithra.placementmanagement;

	import static org.junit.jupiter.api.Assertions.*;

	import java.util.List;
	import java.util.NoSuchElementException;

	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.MethodOrderer;
	import org.junit.jupiter.api.Order;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.TestInstance;
	import org.junit.jupiter.api.TestMethodOrder;
	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.ValueSource;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;

	@SpringBootTest
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class PavithraUserServiceTest {

	    @Autowired
	    private PavithraUserService userService;

	    @Autowired
	    private PavithraUserController userController;

	    private PavithraUser testUser;

	    @BeforeAll
	    public void setUp() {
	        // Sample user to be used in the test
	        testUser = new PavithraUser(1, "Test User", 1, "password123");
	        // Add test user to database
	        userService.create(testUser);
	    }

	    @Test
	    @Order(1)
	    public void testAddUser() {
	        PavithraUser newUser = new PavithraUser(2, "New User", 2, "newpassword");
	        userService.create(newUser);

	        // Verify the user is added
	        PavithraUser retrievedUser = userService.retrieve(2);
	        assertEquals("New User", retrievedUser.getName());
	    }

	    @Test
	    @Order(2)
	    public void testRetrieveUserById() {
	        PavithraUser result = userService.retrieve(1);
	        assertEquals(testUser.getName(), result.getName());
	        assertEquals(testUser.getType(), result.getType());
	    }

	    @Test
	    @Order(3)
	    public void testRetrieveNonExistentUser() {
	        assertThrows(NoSuchElementException.class, () -> {
	            userService.retrieve(999); // Non-existent ID
	        });
	    }

	    @Test
	    @Order(4)
	    public void testDeleteUser() {
	        userService.delete(2);
	        assertThrows(NoSuchElementException.class, () -> {
	            userService.retrieve(2); // Ensure the user is deleted
	        });
	    }

	    @Test
	    @Order(5)
	    public void testGetAllUsers() {
	        List<PavithraUser> users = userService.listAll();
	        assertTrue(users.size() > 0); // At least one user exists (testUser)
	    }

	    @Test
	    @Order(6)
	    public void testControllerGetUser() {
	        ResponseEntity<PavithraUser> response = userController.get(1);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(testUser.getName(), response.getBody().getName());
	    }
	    
	    @Test
	    @Order(7)
	    public void testControllerGetNonExistentUser() {
	        ResponseEntity<PavithraUser> response = userController.get(999); // Non-existent ID
	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	    }
	    
	    @ParameterizedTest
	    @ValueSource(ints = {1})
	    @Order(8)
	    public void testParameterizedGetUsers(int id) {
	        PavithraUser result = userService.retrieve(id);
	        assertNotNull(result);
	        assertEquals(id, result.getId());
	    }
	}