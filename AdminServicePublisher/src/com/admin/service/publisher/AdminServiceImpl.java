package com.admin.service.publisher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

	List<String> newPatient = new ArrayList<>();
	ArrayList<Patient>patients = new ArrayList<Patient>();

	int selectedDoctor ;
	int patientIndex = 1;
	int ID=0;

	@Override
	//DISPALY TECHNICIAN LIST
	public int getDocList() {
		Scanner patientScanner = new Scanner(System.in);
		int i = 5;
		
		System.out.println("\t1.General Doctor  - Mr.B.G.N.Rathnasena");
		System.out.println("\t2.Eye Doctor  - Mr.Chandima Amarasena");
		System.out.println("\t3.ENT Doctor - Mr.H.K.De S.Kularatne ");
		System.out.println("\t4.Nural Doctor - Mr.WAS De Silva");
		
		for (String doc : newPatient) {
			System.out.println("\t"+i + "." + doc);
			i++;
		}
		System.out.print("\n\tEnter Doctor's index number : ");
		selectedDoctor = patientScanner.nextInt();
		return selectedDoctor;
		
	}

	@Override
	//ADDING TECHNICIANS TO THE LIST
	public void addDoctor() {
		Scanner addPatientScanner = new Scanner(System.in);
		
		System.out.println("\t\t----Enter no to exit----");
		do {
			System.out.print("\tEnter Doctor name :");
			newPatient.add(addPatientScanner.next());
			System.out.println("\n \t Doctor added successfully!!!\n");
		
		}while(newPatient.equals("no"));
		
	}

	@Override
	//DISPLAY MAIN OPTIONS
	public void dispalyOption() {
		System.out.println("\t1. Patient registration ");
		System.out.println("\t2. Add Doctors ");
		System.out.println("\t3. Doctor hiring");
		System.out.println("\t4. Patient History");
		System.out.println("\t0. Exit \n");
		
	}

	@Override
	//REGISTER PATIENT
	public void registerPatient(String name, int telephone, String address, String patientNumber,String patientAge) {

		System.out.println("\n\t----- new patient details -----");
		System.out.println("  \tMedicare Laboratory and Pharmacy Administration  ");
		System.out.println("\n \t \t PATIENT DETAILS :");
		patients.add(new Patient(ID, name, telephone, address, patientAge, patientNumber));
		ID = ID +1;
		
		System.out.println("\tPatient Name      :- " + name);
		System.out.println("\tPatient Telephone :- "+telephone);
		System.out.println("\tPatient Address   :- "+address);
		System.out.println("\tPatient Age     	:- " + patientAge);
		System.out.println("\tPatient Number    :- " + patientNumber);
		
		System.out.println("\n \t Patient Added Successfully!!!\n");
		
	}

	@Override
	//CALCULATE BALANCE
	public double calculateHire(int type, double paymant, double docCharge) {
		double balance = 0;
		if (type == 1) {
			balance = paymant -docCharge;
			
		}
		if (type == 2) {
			balance = paymant -docCharge;
			
		}
		if (type == 3) {
			balance = paymant -docCharge;
			
		}
		
			return balance; 
	}

	@Override
	
	public void printChargingBill(int patientIndex, String patientName,String docName,double hire,double bal) {
		try {
			
			FileWriter fileWriter = new FileWriter("D:\\channelingbill.txt");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("\n\t====================================================");
			printWriter.println("\t -Hiring Details-");
			printWriter.println("patient no : " + patientIndex);
			printWriter.println("patient name :" + patientName);
			printWriter.println("Doctor name : " + docName );
			printWriter.println("time and Venue : " + timestamp);
			printWriter.println("Total charge :" + hire);
			printWriter.println("balance :" + bal );
			printWriter.println("\t====================================================\n");
			printWriter.close();
			
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("\tAn error occured");
		}
		
	}
	
	@Override
	//CREATING BILL INFORMATION
	public void createDocChannelDetails(int type, String patientName,String docName,double docCharge, double amount,int patientIndex) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("\t========================================");
		System.out.println("\t\t -Hiring Details-");
		System.out.println("\tpatient no : " + patientIndex);
		System.out.println("\tpatient name :" + patientName);
		System.out.println("\tDoctor name : " +docName );
		System.out.println("\tPaid");
		System.out.println("\ttime and Venue : " + timestamp);
		System.out.println("\tTotal charge :" + docCharge);
		System.out.println("\tbalance      :" + this.calculateHire(type,amount,docCharge));
		System.out.println("\t========================================");
		
		
	}

	@Override
	//GET ALL REGISTERED PATIENTS AND DISPLAY
	public void allPatients(double tot) {
		System.out.println("\n\t==============Patient History================");
		System.out.println("\t Patient Name \t\t\t Address");
		for(int i=0 ; i < patients.size();i++) {
			
			System.out.println("\t" +(i+1)+" "+patients.get(i).getName()+"   \t\t\t"+patients.get(i).getAddress());
			
		}
		
		System.out.println("\n\tTotal income : " + tot);
		
		
	}

}
