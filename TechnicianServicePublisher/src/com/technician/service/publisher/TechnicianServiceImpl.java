package com.technician.service.publisher;


import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TechnicianServiceImpl implements TechnicianService{
	ArrayList<CertifiedUpgrade>medicine = new ArrayList<CertifiedUpgrade>();
	ArrayList<String>medicineDosage = new ArrayList<String>();
	ArrayList<String>duration = new ArrayList<String>();
	ArrayList<String>dailySummary = new ArrayList<String>();
	ArrayList<String>test = new ArrayList<String>();
	
	int count = 0;
	
	
	
	

	@Override
	public void prescribeMedicine(String name, String dose, String dur) {
		// TODO Auto-generated method stub
		 medicine.add(new CertifiedUpgrade(name, dur, dose)); 
//		medicineName.add(name);
//		medicineDosage.add(dose);
//		duration.add(dur);
		
	}

	@Override
	public void prescribeTest(String tName) {
		test.add(tName);
	}

	@Override
	public void viewHistory() {
		
		System.out.println("================================View Daily Summary=================================");
		System.out.println("Customers for the day : ");
		
		for(int i = 0; i <= (dailySummary.size() - 1); i++) {
			System.out.println(dailySummary.get(i));
			count = dailySummary.size();
			
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Total number of customers : "+count);
		System.out.println();
		System.out.println("===================================================================================");
		
		
		
	}

	@Override
	public void printUpgradeList(String pname, String page, String dname) {
		// TODO Auto-generated method stub
		
		try {
			File file = new File("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\prescription.txt");
			
			
			FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\prescription.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================Upgrade Prescription============================");
			printWriter.println();
			printWriter.println("Packaged by : mR.. "+dname);
			printWriter.println("Customer Name : "+ pname + "                                 age: "+ page + "yr");
			printWriter.println();
			printWriter.println();
			printWriter.println("Upgrade                Dosage        Duration"  );

			for(int i = 0; i<= medicine.size()- 1; i++ ) {
				printWriter.println(medicine.get(i).getName() + "                      " + medicine.get(i).getDose() + "              " + medicine.get(i).getDuration());
			}
			printWriter.println("");
			printWriter.println("============================================================================");
			printWriter.close();
			
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
		
	}

	@Override
	public void printTestPrescription(String pname, String page, String dname) {
		// TODO Auto-generated method stub
		try {
		FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\prescriptiontest.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("===========================Test Prescription============================");
		printWriter.println();
		printWriter.println("Packaged by: Mr. "+dname);
		printWriter.println("Customer Name : "+ pname + "                                 age: "+ page+ " yr");
		printWriter.println();
		
		
		for (int i = 0; i <= test.size()-1; i++) {
			printWriter.println(test.get(i));
			
		}
		
		printWriter.println("");
		printWriter.println("========================================================================");
		printWriter.close();
		
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error has occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
	}

	

	@Override
	public void viewMedicinePrescription(String pname, String page, String dname) {
		System.out.println("===========================Upgrade Prescription============================");
		System.out.println();
		System.out.println("Packaged by : Mr. "+dname);
		System.out.println("Customer Name : "+ pname + "                                 age: "+ page + "yr");
		System.out.println();
		System.out.println("Upgrade                Dosage        Duration");
		for(int i = 0; i<= medicine.size()- 1; i++ ) {
			System.out.println(medicine.get(i).getName() + "                      " + medicine.get(i).getDose() + "             " + medicine.get(i).getDuration());
		}
		System.out.println();
		System.out.println("============================================================================");

		
		
		
	}



	@Override
	public void viewPrescribedtest(String pname, String page, String dname) {
		System.out.println("===========================Test Prescription============================");
		System.out.println();
		System.out.println("Packaged by: Mr. "+dname);
		System.out.println("Customer Name : "+ pname + "                                 age: "+ page+ " yr");
		System.out.println();
		
		for(int i = 0; i<= test.size()-1; i++ ) {
			
			System.out.println(test.get(i));
		}
		
		System.out.println();
		System.out.println("========================================================================");

	}

	@Override
	public void clearMedicinePrescription() {
		// TODO Auto-generated method stub
		medicine.clear();
//		medicineDosage.clear();
//		duration.clear();
//		
	}

	@Override
	public void clearTestPrescription() {
		// TODO Auto-generated method stub
		test.clear();
		
	}

	@Override
	public void keepCustomerSummary(String pname) {
		// TODO Auto-generated method stub
		if(!dailySummary.isEmpty()) {
			int last = dailySummary.size() - 1;
			String previous = dailySummary.get(last);
			
			if(!previous.equals(pname)) {
				dailySummary.add(pname);
			}
			
		}
		
		else {
			dailySummary.add(pname);
		}
			
	}

}
