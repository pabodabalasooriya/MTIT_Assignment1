package com.store.service.publisher;

public class Upgrade {
	int id;
	String Name;
	String Dose;
	int price;
	int count;
	int total;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDose() {
		return Dose;
	}

	public void setDose(String dose) {
		Dose = dose;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Upgrade(int id, String name, String dose, int price, int count, int total) {
		super();
		this.id = id;
		Name = name;
		Dose = dose;
		this.price = price;
		this.count = count;
		this.total = total;
	}
	
}
