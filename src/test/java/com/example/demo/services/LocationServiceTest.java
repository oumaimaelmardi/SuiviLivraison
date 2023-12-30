package com.example.demo.services;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
@SpringBootTest
class LocationServiceTest {

	@Autowired
    private LocationService locationService;

	@MockBean
    private LocationRepository locationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    String dest="Destination";
    String warH="Warehouse A";
    String addr="123 Main St";
    
    @Test
    public void testSaveLocation() {
        // Arrange
    	Colis mockColis = new Colis();
        mockColis.setId(1);
        mockColis.setTrackingNumber("ABC123");
        mockColis.setDestination(dest);
    	
        LocalDateTime timestamp = LocalDateTime.now();
        Location locationToSave = new Location(1, warH, timestamp, addr, mockColis);
        
        // Mocking the behavior of locationRepository.save
        when(locationRepository.save(locationToSave)).thenReturn(locationToSave);

        // Act
        Location savedLocation = locationService.save(locationToSave);

        // Assert
        assertEquals(locationToSave, savedLocation);
        verify(locationRepository, times(1)).save(locationToSave);
    }

    @Test
    public void testFindAllLocations() {
    	LocalDateTime timestamp = LocalDateTime.now();
    	Colis mockColis1 = new Colis();
    	mockColis1.setId(1);
    	mockColis1.setTrackingNumber("ABC1244");
    	mockColis1.setDestination(dest);
        
        Colis mockColis2 = new Colis();
        mockColis2.setId(2);
        mockColis2.setTrackingNumber("ABC1222");
        mockColis2.setDestination(dest);
        // Arrange
        List<Location> locationList = Arrays.asList(
                new Location(1, warH, timestamp, addr, mockColis1),
                new Location(2, warH, timestamp, addr, mockColis2)
        );

        // Mocking the behavior of locationRepository.findAll
        when(locationRepository.findAll()).thenReturn(locationList);

        // Act
        List<Location> foundLocations = locationService.findAll();

        // Assert
        assertEquals(locationList.size(), foundLocations.size());
        assertTrue(foundLocations.containsAll(locationList));
        verify(locationRepository, times(1)).findAll();
    }

    @Test
    public void testFindLocationById() {
    	Colis mockColis1 = new Colis();
    	mockColis1.setId(1);
    	mockColis1.setTrackingNumber("ABC1244");
    	mockColis1.setDestination(dest);
    	
    	LocalDateTime timestamp = LocalDateTime.now();
        // Arrange
        int locationId = 1;
        Location expectedLocation = new Location(locationId, warH, timestamp, addr, mockColis1);

        
        when(locationRepository.findById(locationId)).thenReturn(expectedLocation);

        // Act
        Location foundLocation = locationService.findById(locationId);

        // Assert
        assertEquals(expectedLocation, foundLocation);
        verify(locationRepository, times(1)).findById(locationId);
    }

    @Test
    public void testUpdateLocation() {
        // Arrange
        LocalDateTime timestamp = LocalDateTime.now();

        // Create a mock Colis object for testing
        Colis mockColis = new Colis();
        mockColis.setId(1);
        mockColis.setTrackingNumber("ABC123");
        mockColis.setDestination(dest);

        Location locationToUpdate = new Location(1, warH, timestamp, addr, mockColis);

       

        // Mocking the behavior of locationRepository.save
        when(locationRepository.save(locationToUpdate)).thenReturn(locationToUpdate);

        // Act
        Location updatedLocation = locationService.update(locationToUpdate);

        // Assert
        assertEquals(locationToUpdate, updatedLocation);
        verify(locationRepository, times(1)).save(locationToUpdate);
    }


    @Test
    public void testDeleteAllLocations() {
        // Act
        locationService.deleteAll();

        // Assert
        verify(locationRepository, times(1)).deleteAll();
    }

}
