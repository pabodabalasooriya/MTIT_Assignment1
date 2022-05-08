package com.doctor.service.publisher;


import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DoctorServiceImpl implements DoctorService{
	ArrayList<CertifiedUpgrade>upgrades = new ArrayList<CertifiedUpgrade>();
	ArrayList<String>upgradeDose = new ArrayList<String>();
	ArrayList<String>duration = new ArrayList<String>();
	ArrayList<String>dailySummary = new ArrayList<String>();
	ArrayList<String>test = new ArrayList<String>();
	
	int count = 0;

	@Override
	public void upgradeDose(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription) {
		 upgrades.add(new CertifiedUpgrade(patientName, duration, dose));
	}

	@Override
	public void doseTest(String patientName,String patientAge,String discription,String tName) {
		test.add(tName);
	}

	@Override
	public void viewHistory() {
		
		System.out.println("================================View Daily Summary=================================");
		System.out.println("Patients for the day : ");
		
		for(int i = 0; i <= (dailySummary.size() - 1); i++) {
			System.out.println(dailySummary.get(i));
			count = dailySummary.size();
			
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Total number of patients : " + count);
		System.out.println();
		System.out.println("===================================================================================");

	}

	@Override
	public void printUpgradeList(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription) {
		
		try {
			File file = new File("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\upgrade.txt");
			
			FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\upgrade.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================Patient Medical Details============================");
			printWriter.println();
			printWriter.println("Packaged by : MR. "+ docName);
			printWriter.println("Patient Name : "+ patientName + "                                 "+ "Patient : "+ patientAge);
			printWriter.println();
			printWriter.println();
			printWriter.println("Medicine Name :" + medicineName + " "+"Get Dose : "+dose + "  "+"Medicine Get Duration : "+duration+"  ");

			for(int i = 0; i<= upgrades.size()- 1; i++ ) {
				printWriter.println(upgrades.get(i).getName() + "                      " + upgrades.get(i).getDose() + "              " + upgrades.get(i).getDuration());
			}
			printWriter.println("");
			printWriter.println("============================================================================");
			printWriter.close();
			
			
		}catch (IOException e) {
			System.out.println("An error occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
		
	}

	@Override
	public void printTestPrescription(String patientName,String patientAge,String docName,String discription, String tName) {
		try {
		FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\Test.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("===========================Test Prescription============================");
		printWriter.println();
		printWriter.println("Packaged by: Mr. "+docName);
		printWriter.println("Patient Name : "+ patientName + "          ");
		printWriter.println("Discription : "+discription);
		printWriter.println();
		
		
		for (int i = 0; i <= test.size()-1; i++) {
			printWriter.println(test.get(i));
			
		}
		
		printWriter.println("");
		printWriter.println("========================================================================");
		printWriter.close();
		
		}catch (IOException e) {
			System.out.println("An error has occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
	}

	@Override
	public void viewDosePoint(String patientName,String patientAge,String duration,String medicineName,String dose,String docName,String discription)
	{
		System.out.println("===========================Patient Medical Details============================");
		System.out.println();
		System.out.println("Doctor Name : Mr. "+docName);
		System.out.println("Patient Name : "+ patientName + "               "+ "Patient Age : "+ patientAge);
		System.out.println("Discription"+discription);
		System.out.println();
		System.out.println("Medicine Name :" + medicineName + "     "+"Get Dose : "+dose + "   "+"Medicine Get Duration : "+duration+"  ");
		for(int i = 0; i<= upgrades.size()- 1; i++ ) {
			System.out.println(upgrades.get(i).getName() + "                      " + upgrades.get(i).getDose() + "             " + upgrades.get(i).getDuration());
		}
		System.out.println();
		System.out.println("============================================================================");
		
	}

	@Override
	public void viewUpgradedTest(String patientName,String patientAge,String docName,String discription,String tName) {
		System.out.println("===========================Test Prescription============================");
		System.out.println();
		System.out.println("Doctor Name : Mr. "+docName);
		System.out.println("Patient Name : "+ patientName + "                           "+ "Patient Age : "+ patientAge);
		System.out.println();
		
		for(int i = 0; i<= test.size()-1; i++ ) {
			
			System.out.println(test.get(i));
		}
		
		System.out.println();
		System.out.println("========================================================================");

	}

	@Override
	public void clearUpgradeDose() {
		upgrades.clear();
	}

	@Override
	public void clearUpgradeTestDose() {
		test.clear();
		
	}

	@Override
	public void keepPatientSummary(String patientName) {
		if(!dailySummary.isEmpty()) {
			int last = dailySummary.size() - 1;
			String previous = dailySummary.get(last);
			
			if(!previous.equals(patientName)) {
				dailySummary.add(patientName);
			}
			
		}
		
		else {
			dailySummary.add(patientName);
		}
			
	}



}
