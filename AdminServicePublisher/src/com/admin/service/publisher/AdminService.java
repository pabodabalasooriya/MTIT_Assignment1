package com.admin.service.publisher;

public interface AdminService {
	public void registerPatient(String name, int telephone, String address, String patientNumber, String patientAge);
	public void allPatients(double tot);
	public int  getDocList();
	public void addDoctor();
	public void dispalyOption();
	public void createDocChannelDetails(int type ,String patientName,String docName, double docCharge, double amount,int patientIndex);
	public double calculateHire(int type, double paymant,double docCharge);
	
	public void printChargingBill(int patientIndex, String patientName,String docName, double hire,double bal);
	
}
