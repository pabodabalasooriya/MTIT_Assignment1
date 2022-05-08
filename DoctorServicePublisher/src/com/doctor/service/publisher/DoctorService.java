package com.doctor.service.publisher;

import java.util.ArrayList;

public interface DoctorService {
	
		
	public void upgradeDose(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription);
	public void viewDosePoint(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription);
	public void doseTest(String patientName,String patientAge,String discription,String tName);
	public void viewUpgradedTest(String patientName,String patientAge,String docName,String discription,String tName);
	public void viewHistory();
	public void printUpgradeList(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription);
	public void printTestPrescription(String patientName,String patientAge,String docName,String discription,String tName);
	public void clearUpgradeDose();
	public void clearUpgradeTestDose();
	public void keepPatientSummary(String patientName);
}
