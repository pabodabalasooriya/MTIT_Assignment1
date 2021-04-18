package com.admin.service.publisher;

public class Customer {
	
	int id;
	String name;
	String age;
	int telephone;
	String address;
	String vehicalNumber;
	String vehicalType;
	
	public Customer(int id, String name, String age, int telephone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.address = address;
	}
	
	public Customer(int id, String name, String age, int telephone, String address, String vehicalNumber,
			String vehicalType) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.address = address;
		this.vehicalNumber = vehicalNumber;
		this.vehicalType = vehicalType;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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

	public String getVehicalNumber() {
		return vehicalNumber;
	}

	public void setVehicalNumber(String vehicalNumber) {
		this.vehicalNumber = vehicalNumber;
	}

	public String getVehicalType() {
		return vehicalType;
	}

	public void setVehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
	}
	
}
