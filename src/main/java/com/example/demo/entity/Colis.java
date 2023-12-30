package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Colis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public Colis() {
		super();
	}

	public Colis(int id, String trackingNumber, String destination, List<Location> currentLocations, Boolean status,
			User user) {
		super();
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.destination = destination;
		this.currentLocations = currentLocations;
		this.status = status;
		this.user = user;
	}

	private String trackingNumber;
	private String destination;
	
	@OneToMany(mappedBy = "colis")
	private List<Location> currentLocations;

	private Boolean status;

	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Colis(String trackingNumber, String destination, List<Location> currentLocations, Boolean status,
			User user) {
		super();
		this.trackingNumber = trackingNumber;
		this.destination = destination;
		this.currentLocations = currentLocations;
		this.status = status;
		this.user = user;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Location> getCurrentLocations() {
		return currentLocations;
	}

	
	public void setCurrentLocations(List<Location> currentLocations) {
		this.currentLocations = currentLocations;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
