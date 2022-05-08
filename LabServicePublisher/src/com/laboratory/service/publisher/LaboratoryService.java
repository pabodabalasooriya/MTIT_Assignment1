package com.laboratory.service.publisher;

public interface LaboratoryService {

	public void displayReport();
	public void selectReportType(String labservicetype);
	public void reportPrint(String patientName, String patientNumber, String patientAge, String doctorName, String docName);
	public void laboratoryReportHistory(String patientName);
	public void viewLaboratoryReport(String patientName, String patientNumber, String patientAge, String doctorName, String docName);
	public void viewLaboratoryReportHistory();
	public void cleardata();
	
	
}
