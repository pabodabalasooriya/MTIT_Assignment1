package com.pharmacy.service.publisher;

public interface PharmacyService {

	public void displayOption();
	public void getUpgradeList();
	public void getOptions(int type);
	public void purchesUpgrades(String upgrade,String dose,int price,int qty);
	public void createBill();
	public void calculateBill();
	public void myHistory();
	public void createPdf();
	public void addPatients(String name);
	public void manageUserBill(int cash);
	public void addUpgradeToMyInventory(String upgradeEquip);
	public void printHistory();
}
