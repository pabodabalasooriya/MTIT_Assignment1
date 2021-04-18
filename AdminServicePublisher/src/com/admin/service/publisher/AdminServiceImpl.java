package com.admin.service.publisher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.OpenOption;
import java.rmi.activation.Activator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AdminServiceImpl implements AdminService {

	List<String> newCustomer = new ArrayList<>();
	ArrayList<Customer>customers = new ArrayList<Customer>();

	int selectedDoc ;
	int patientIndex = 1;
	int ID=0;

	@Override
	//DISPALY DOCTORS LIST
	public int getTechList() {
		Scanner customerScanner = new Scanner(System.in);
		int i = 5;
		
		System.out.println("\t1. General Surgeons Specialist  - Dr.B.G.N.Rathnasena");
		System.out.println("\t2.Plastic Surgeons Specialist  - Dr.Chandima Amarasena");
		System.out.println("\t3.Neuro Surgeons Specialist - Dr.H.K.De S.Kularatne ");
		System.out.println("\t4.Genito Urinary Surgeons Specialist - Dr.WAS De Silva");
		
		for (String doc : newCustomer) {
			System.out.println("\t"+i + "." + doc);
			i++;
		}
		System.out.print("\n\tEnter Doctor's index number : ");
		selectedDoc = customerScanner.nextInt();
		return selectedDoc;
		
	}

	@Override
	//ADDING DOCTORS TO THE LIST
	public void addTechnician() {
		Scanner addCustomerScanner = new Scanner(System.in);
		
		System.out.println("\t\t----Enter no to exit----");
		do {
			System.out.print("\tEnter Doctor name :");
			newCustomer.add(addCustomerScanner.next());
			System.out.println("\n \t Doctor added successfully!!!\n");
		
		}while(newCustomer.equals("no"));
		
	}

	@Override
	//DISPLAY MAIN OPTIONS
	public void dispalyOption() {
		System.out.println("\t1. Patient registration ");
		System.out.println("\t2. Add doctors ");
		System.out.println("\t3. Doctor channeling");
		System.out.println("\t4. Patient History");
		System.out.println("\t0. Exit \n");
		
	}

	@Override
	//REGISTER PATIENT
	public void registerCustomer(String name, String age, int telephone, String Address) {
		// TODO Auto-generated method stub
		System.out.println("\n\t----- new patient details -----");
		System.out.println("  \tXXX Hospital Administration  ");
		System.out.println("\n \t \t PATIENT DETAILS :");
		customers.add(new Customer(ID, name, age, telephone, Address));
		ID = ID +1;
		
		System.out.println("\tPatient Name      :- " + name);
		System.out.println("\tPatient Age       :- " + age+" years");
		System.out.println("\tPatient Telephone :- "+telephone);
		System.out.println("\tPatient Address   :- "+Address);
		
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
	
	public void printChargingBill(int patientIndex, String patientName,String docName,double clannelingFee,double bal) {
		try {
			
			
			
			FileWriter fileWriter = new FileWriter("D:\\channelingbill.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("\n\t====================================================");
			printWriter.println("\t -Channeling Details-");
			printWriter.println("patient no : " + patientIndex);
			printWriter.println("patient name :" + patientName);
			printWriter.println("Doctor name : " + docName );
			printWriter.println("time and Venue : " + "2020/3/15 - 4.00pm");
			printWriter.println("Total charge :" + clannelingFee);
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
	public void createTechHireDetails(int type, String pName,String docName,double docCharge,double amount,int patientIndex) {
		System.out.println("\t========================================");
		System.out.println("\t\t -Channeling Details-");
		System.out.println("\tpatient no : " + patientIndex);
		System.out.println("\tpatient name :" + pName);
		System.out.println("\tDoctor name : " +docName );
		System.out.println("\tPaid");
		System.out.println("\ttime and Venue : " + " 2020/3/15 - 2.30pm");
		System.out.println("\tTotal charge :" + docCharge);
		System.out.println("\tbalance      :" + this.calculateHire(type,amount,docCharge));
		System.out.println("\t========================================");
		
		
	}

	@Override
	//GET ALL REGISTERED PATIENTS AND DISPLY
	public void allCustomers(double tot) {
		// TODO Auto-generated method stub
		System.out.println("\n\t==============Patient History================");
		System.out.println("\t Patient Name \t\t\t Address");
		for(int i=0 ; i < customers.size();i++) {
			
			System.out.println("\t" +(i+1)+" "+customers.get(i).getName()+"   \t\t\t"+customers.get(i).getAddress());
			
		}
		
		System.out.println("\n\tTotal income : " + tot);
		
		
	}

}
