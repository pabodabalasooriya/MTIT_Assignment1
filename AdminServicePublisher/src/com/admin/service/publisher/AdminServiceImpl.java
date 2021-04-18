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
		
		System.out.println("\t1. General Technician  - Mr.B.G.N.Rathnasena");
		System.out.println("\t2.Hybrid Technician  - Mr.Chandima Amarasena");
		System.out.println("\t3.Electrical Technician - Mr.H.K.De S.Kularatne ");
		System.out.println("\t4.Assistant Technician - Mr.WAS De Silva");
		
		for (String doc : newCustomer) {
			System.out.println("\t"+i + "." + doc);
			i++;
		}
		System.out.print("\n\tEnter Technician's index number : ");
		selectedDoc = customerScanner.nextInt();
		return selectedDoc;
		
	}

	@Override
	//ADDING DOCTORS TO THE LIST
	public void addTechnician() {
		Scanner addCustomerScanner = new Scanner(System.in);
		
		System.out.println("\t\t----Enter no to exit----");
		do {
			System.out.print("\tEnter Technician name :");
			newCustomer.add(addCustomerScanner.next());
			System.out.println("\n \t Technician added successfully!!!\n");
		
		}while(newCustomer.equals("no"));
		
	}

	@Override
	//DISPLAY MAIN OPTIONS
	public void dispalyOption() {
		System.out.println("\t1. Customer registration ");
		System.out.println("\t2. Add Technicians ");
		System.out.println("\t3. Technician hiring");
		System.out.println("\t4. Customer History");
		System.out.println("\t0. Exit \n");
		
	}

	@Override
	//REGISTER PATIENT
	public void registerCustomer(String name, String age, int telephone, String Address) {
		// TODO Auto-generated method stub
		System.out.println("\n\t----- new customer details -----");
		System.out.println("  \tXXX Service station Administration  ");
		System.out.println("\n \t \t CUSTOMER DETAILS :");
		customers.add(new Customer(ID, name, age, telephone, Address));
		ID = ID +1;
		
		System.out.println("\tCustomer Name      :- " + name);
		System.out.println("\tCustomer Age       :- " + age+" years");
		System.out.println("\tCustomer Telephone :- "+telephone);
		System.out.println("\tCustomer Address   :- "+Address);
		
		System.out.println("\n \t Customer Added Successfully!!!\n");
		
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
			printWriter.println("\t -Hiring Details-");
			printWriter.println("customer no : " + patientIndex);
			printWriter.println("customer name :" + patientName);
			printWriter.println("Technician name : " + docName );
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
		System.out.println("\t\t -Hiring Details-");
		System.out.println("\tcustomer no : " + patientIndex);
		System.out.println("\tcustomer name :" + pName);
		System.out.println("\tTechnician name : " +docName );
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
		System.out.println("\t Customer Name \t\t\t Address");
		for(int i=0 ; i < customers.size();i++) {
			
			System.out.println("\t" +(i+1)+" "+customers.get(i).getName()+"   \t\t\t"+customers.get(i).getAddress());
			
		}
		
		System.out.println("\n\tTotal income : " + tot);
		
		
	}

}
