package com.example.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testFindUserById() {
        // Arrange
        int userId = 1;
        User expectedUser = new User(userId, "user1", "userPrenom", "user@gmail.com", "userpass123");

        // Mocking the behavior of userRepository.findById
        when(userRepository.findById(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.findById(userId);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userRepository, times(1)).findById(userId);
    }
	


	@Test
    void testSave() {
        User userToSave = new User(1, "user1", "userPrenom", "user@gmail.com", "userpass123");
        userToSave.setNom("New User");

        User savedUser = new User(1, "user1", "userPrenom", "user@gmail.com", "userpass123");
        savedUser.setId(1);
        savedUser.setNom("New User");

        when(userRepository.save(userToSave)).thenReturn(savedUser);

        User returnedUser = userService.save(userToSave);

        assertNotNull(returnedUser);
        assertEquals(1, returnedUser.getId());
        assertEquals("New User", returnedUser.getNom());
        verify(userRepository, times(1)).save(userToSave);
    }
	
	 @Test
	    public void testDeleteUserById() {
	        // Arrange
	        int userId = 1;

	        // Act
	        userService.delete(userId);

	        // Assert
	        verify(userRepository, times(1)).deleteById(userId);
	    }
	 
	 @Test
	    public void testFindAllUsers() {
	        // Arrange
	        List<User> userList = Arrays.asList(
	                new User(1, "user1", "userPrenom1", "user1@gmail.com", "userpass123"),
	                new User(2, "user2", "userPrenom2", "user2@gmail.com", "userpass123")
	        );

	        // Act
	        when(userRepository.findAll()).thenReturn(userList);
	        List<User> foundUsers = userService.findAll();

	        // Assert
	        assertEquals(userList.size(), foundUsers.size());
	        for (int i = 0; i < userList.size(); i++) {
	            assertEquals(userList.get(i), foundUsers.get(i));
	        }
	        verify(userRepository, times(1)).findAll();
	    }
	 
	 @Test
	    public void testDeleteAllUsers() {
	        // Act
	        userService.deleteAll();

	        // Assert
	        verify(userRepository, times(1)).deleteAll();
	    }

}
