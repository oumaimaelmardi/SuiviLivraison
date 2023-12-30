package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp(){
		//MockitoAnnotations.initMocks(this);
		User user=new User(1,"user1","userPrenom","user@gmail.com","userpass123");
		entityManager.persist(user);
		//Mockito.when(userRepository.findById(1)).thenReturn(user);
	}
	
	@Test
	public void testFindUserById() {
		//String userName="user1";
		User userById= userRepository.findById(1);
		assertEquals("user1",userById.getNom());
	}

}
