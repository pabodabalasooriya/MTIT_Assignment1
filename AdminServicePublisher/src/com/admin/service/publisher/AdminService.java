package com.admin.service.publisher;

public interface AdminService {
	public void registerCustomer(String name,String age,int telephone,String Address);
	public void allCustomers(double tot);
	public int  getTechList();
	public void addTechnician();
	public void dispalyOption();
	public void createTechHireDetails(int type ,String pName,String docName,double docCharge,double amount,int patientIndex);
	public double calculateHire(int type, double paymant,double docCharge);
	
	public void printChargingBill(int patientIndex, String patientName,String docName,double clannelingFee,double bal);
	
	
}
