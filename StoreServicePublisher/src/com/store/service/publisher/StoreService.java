package com.store.service.publisher;

public interface StoreService {

	public void displayOption();
	public void getUpgradeList();
	public void getOptions(int type);
	public void purchesUpgrades(String medicine,String Dose,int price,int count);
	public void createBill();
	public void calculateBill();
	public void myHistory();
	public void createPdf();
	public void addCustomers(String name);
	public void manageUserBill(int cash);
	public void addUpgradeToMyInventory(String medicineName);
	public void printHistory();
}
