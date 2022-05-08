package com.admin.service.publisher;

public class Patient {
	
	int id;
	String name;
	int telephone;
	String address;
	String patientNumber;
	String patientAge;
	
	public Patient(int id, String name, int telephone, String address, String patientNumber,
			String patientAge) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.patientNumber = patientNumber;
		this.patientAge = patientAge;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
}
