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
	
	String name="user1";
	String gmail="user@gmail.com";
	String password="userpass123";
	String prenom="userPrenom";
	String newU="New User";
	
	@Test
    public void testFindUserById() {
        // Arrange
        int userId = 1;
        User expectedUser = new User(userId, name, prenom, gmail, password);
        
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
        User userToSave = new User(1, name, prenom, gmail, password);
        userToSave.setNom(newU);

        User savedUser = new User(1, name, prenom, gmail, password);
        savedUser.setId(1);
        savedUser.setNom(newU);

        when(userRepository.save(userToSave)).thenReturn(savedUser);

        User returnedUser = userService.save(userToSave);

        assertNotNull(returnedUser);
        assertEquals(1, returnedUser.getId());
        assertEquals(newU, returnedUser.getNom());
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
	                new User(1, name, prenom, gmail, password),
	                new User(2, "user2", prenom, gmail, password)
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
