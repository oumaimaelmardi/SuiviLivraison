package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Colis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String trackingNumber;
	private String destination;
	@OneToMany
	private List<Location> currentLocations;

	private String Status;

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
		currentLocations = currentLocations;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
