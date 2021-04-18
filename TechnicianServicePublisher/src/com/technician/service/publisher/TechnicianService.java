package com.technician.service.publisher;

import java.util.ArrayList;

public interface TechnicianService {
	
	public void prescribeMedicine(String name, String dose, String dur);
	public void viewMedicinePrescription(String pname,String page,String dname);
	public void prescribeTest(String tName);
	public void viewPrescribedtest(String pname,String page,String dname);
	public void viewHistory();
	public void printUpgradeList(String pname,String page, String dname);
	public void printTestPrescription(String pname,String page, String dname);
	public void clearMedicinePrescription();
	public void clearTestPrescription();
	public void keepCustomerSummary(String pname);
}
