package com.checkpoint.service.publisher;

public interface CheckpointService {

	public void displayReport();
	public void selectReportType(String labservicetype);
	public void reportPrint(String patientName, int patientAge, String doctorName, String mLTname);
	public void checkpointReportHistory(String PatientName);
	public void viewCheckpointReport(String PatientName, int PatientAge,String DoctorName ,String MLTname);
	public void viewCheckpointReportHistory();
	public void cleardata();
//	public void LabTestHistory(String labTtype);
	
	
}
