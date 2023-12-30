package com.example.demo.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.entity.User;
import com.example.demo.repository.ColisRepository;
import com.example.demo.repository.LocationRepository;

@SpringBootTest
class ColisServiceTest {

	@Autowired
	private ColisService colisService;
	
	@MockBean
	private ColisRepository colisRepository;
	
	@MockBean
	private LocationRepository locationRepository;
	
	@BeforeEach
	void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	User user1 = new User(3, "user1", "userPrenom", "user@gmail.com", "userpass123");

    @Test
    public void testSaveColis() {
        // Arrange
    	
        Colis colisToSave = new Colis(1, "ABC123", "Destination", new ArrayList<>(), true, user1);
        Location location = new Location();
        colisToSave.setCurrentLocations(List.of(location));

        // Mocking the behavior of colisRepository.save and locationRepository.save
        when(colisRepository.save(colisToSave)).thenReturn(colisToSave);
        when(locationRepository.save(location)).thenReturn(location);

        // Act
        Colis savedColis = colisService.save(colisToSave);

        // Assert
        assertEquals(colisToSave, savedColis);
        verify(colisRepository, times(2)).save(colisToSave);
        verify(locationRepository, times(1)).save(location);
    }

    @Test
    public void testUpdateColis() {
        // Arrange
        Colis colisToUpdate = new Colis();

        // Mocking the behavior of colisRepository.save
        when(colisRepository.save(colisToUpdate)).thenReturn(colisToUpdate);

        // Act
        Colis updatedColis = colisService.update(colisToUpdate);

        // Assert
        assertEquals(colisToUpdate, updatedColis);
        verify(colisRepository, times(1)).save(colisToUpdate);
    }

    @Test
    public void testFindColisById() {
        // Arrange
        int colisId = 1;
        Colis expectedColis = new Colis();

        // Mocking the behavior of colisRepository.findById
        when(colisRepository.findById(colisId)).thenReturn(expectedColis);

        // Act
        Colis foundColis = colisService.findById(colisId);

        // Assert
        assertEquals(expectedColis, foundColis);
        verify(colisRepository, times(1)).findById(colisId);
    }


    
    @Test
    public void testFindAllColis() {
        // Arrange
    	

        List<Colis> colisList = new ArrayList<>();
        colisList.add(new Colis(1,"ABC126", "dsv1", new ArrayList<>(), true, user1));
        colisList.add(new Colis(2,"ABC127", "dtint42", new ArrayList<>(), true, user1));

        // Mocking the behavior of colisRepository.findAll
        when(colisRepository.findAll()).thenReturn(colisList);

        // Act
        List<Colis> foundColisList = colisService.findAll();

        // Assert
        assertEquals(colisList.size(), foundColisList.size());
        assertTrue(foundColisList.containsAll(colisList));
        verify(colisRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteColisById() {
        // Arrange
        int colisId = 1;

        // Act
        colisService.deleteById(colisId);

        // Assert
        verify(colisRepository, times(1)).deleteById(colisId);
    }

    @Test
    public void testDeleteAllColis() {
        // Act
        colisService.deleteAll();

        // Assert
        verify(colisRepository, times(1)).deleteAll();
    }
    
    
    
    
    @Test
    public void testUpdateColisLocations() {
        // Arrange
        int colisId = 1;
        Location newLocation = new Location();
        
       
        Colis existingColis = new Colis("ABC128", "dstx5", new ArrayList<>(), true, user1);
        existingColis.setId(colisId);
        existingColis.setCurrentLocations(new ArrayList<>());

        // Mocking the behavior of colisRepository.findById and colisRepository.save
        when(colisRepository.findById(colisId)).thenReturn(existingColis);
        when(colisRepository.save(existingColis)).thenReturn(existingColis);
        when(locationRepository.save(newLocation)).thenReturn(newLocation);

        // Act
        Colis updatedColis = colisService.updateColisLocations(colisId, newLocation);

        // Assert
        assertNotNull(updatedColis);
        assertEquals(colisId, updatedColis.getId());
        assertEquals(existingColis.getTrackingNumber(), updatedColis.getTrackingNumber());
        assertTrue(updatedColis.getCurrentLocations().contains(newLocation));
       
        verify(colisRepository, times(1)).findById(colisId);
        verify(colisRepository, times(1)).save(existingColis);
        verify(locationRepository, times(1)).save(newLocation);
    }

    
    @Test
    public void testFindByTrackingNumber() {
        // Arrange
    	        String trackingNumber = "ABC129";
        Colis colis = new Colis(3,trackingNumber, "dtest2", new ArrayList<>(), true, user1);

        // Mocking the behavior of colisRepository.findByTrackingNumber
        when(colisRepository.findByTrackingNumber(trackingNumber)).thenReturn(colis);

        // Act
        Colis foundColis = colisService.findByTrackingNumber(trackingNumber);

        // Assert
        assertNotNull(foundColis);
        assertEquals(trackingNumber, foundColis.getTrackingNumber());
        assertEquals(colis.getDestination(), foundColis.getDestination());
        verify(colisRepository, times(1)).findByTrackingNumber(trackingNumber);
    }

    @Test
    public void testFindByUserId() {
        // Arrange
    	
        int userId = 1;
        List<Colis> colisList = new ArrayList<>();
        colisList.add(new Colis(3,"tt1239", "dxestin2", new ArrayList<>(), true, user1));
        colisList.add(new Colis(8,"tt1239", "decstina12", new ArrayList<>(), true, user1));

        // Mocking the behavior of colisRepository.findByUserId
        when(colisRepository.findByUserId(userId)).thenReturn(colisList);

        // Act
        List<Colis> foundColisList = colisService.findByUserId(userId);

        // Assert
        assertEquals(colisList.size(), foundColisList.size());
        assertTrue(foundColisList.containsAll(colisList));
        verify(colisRepository, times(1)).findByUserId(userId);
    }
    
}
