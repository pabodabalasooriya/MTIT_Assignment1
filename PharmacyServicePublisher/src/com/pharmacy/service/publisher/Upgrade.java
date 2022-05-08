package com.pharmacy.service.publisher;

public class Upgrade {
	int id;
	String equipedName;
	String dose;
	int price;
	int count;
	int total;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEquipedName() {
		return equipedName;
	}

	public void setEquipedName(String equipedName) {
		this.equipedName = equipedName;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
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

	public Upgrade(int id, String equipedName, String dose, int price, int count, int total) {
		super();
		this.id = id;
		this.equipedName = equipedName;
		this.dose = dose;
		this.price = price;
		this.count = count;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Upgrade [id=" + id + ", equipedName=" + equipedName + ", dose=" + dose + ", price=" + price
				+ ", count=" + count + ", total=" + total + "]";
	}

	
	
}
