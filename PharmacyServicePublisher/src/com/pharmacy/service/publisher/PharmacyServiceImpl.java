package com.pharmacy.service.publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.IIOException;

public class PharmacyServiceImpl implements PharmacyService{

	ArrayList<Upgrade>upgrade = new ArrayList<Upgrade>();
	ArrayList<String> patientBasedList = new ArrayList<String>();
	ArrayList<String> MyInventory = new ArrayList<String>();
	ArrayList<Integer> TotalIncome = new ArrayList<Integer>();
	String patientName="";
	int ID=1;
	
	 int tot = 0;
	 int cash =0;
	 int balance=0;
	 Scanner myscanner = new Scanner(System.in);
	
	 @Override
		public void displayOption() {
			// DISPLAY THE MAIN MENU
			 
			  System.out.println("1.Issue Upgrade");
			  System.out.println("2.My Inventory");
			  System.out.println("3.My History");
			  System.out.println("0.Exit");
			
		}
	 
	@Override
	public void getUpgradeList() {
		
		// DISPLAY THE STORE INVENTORY
		System.out.println("===== Upgrade Inventory =====");
		System.out.println("1. Acetylsalicylic Acid 300mg	1tablet = Rs. 0.01");
		System.out.println("2. Ascorbic Acid 250mg	1tablet = Rs. 0.04");
		System.out.println("3. Aluminium Hydroxyde 500mg	1tablet = Rs. 0.03");
		System.out.println("4. Amoxicillin       1tablet = Rs. 0.18");
		
		for(int i=0;i<MyInventory.size();i++) {
			System.out.println(MyInventory.get(i));
		}
		
	}

	@Override
	public void getOptions(int option) {
	
		
	}
	
	@Override
	public void calculateBill() {
		// CALCULATE THE TOTAL BILL
				  
		  for(int i=0 ; i < upgrade.size();i++) {
			  		
			
			  tot = tot + upgrade.get(i).getTotal();
	  }
		  
		  System.out.println("--------------------------");
		  System.out.println("Total - "+tot);
		  System.out.println("--------------------------");
		 
	}
	
	@Override
	public void createBill() {
		// CONSOLE CREATE THE BILL
		System.out.println("==============Medicare Pharmacy================");
		System.out.println("--------------------YOUR BILL----------------------");
		  System.out.println("Store" +"         "+"Dose"+"      "+"Price" +  "   " +"Quntity"+"      "+"Total");
		 
		  	for(int i=0 ; i < upgrade.size();i++) {
			  
		  		 System.out.println(i+1 +"."+upgrade.get(i).getEquipedName()+"     "+upgrade.get(i).getDose()+"     "+upgrade.get(i).getPrice()+"      "+upgrade.get(i).getCount()+"		"+upgrade.get(i).getTotal());
			 
		  	}
		  
		  System.out.println("--------------------------");
		  System.out.println("Total - "+tot);
		  System.out.println("--------------------------");
		  System.out.println("Cash - " + cash);
		  System.out.println("Balance - " + balance);
		  
		  System.out.println("Thank You");
		 
		  
		  System.out.println("Do you want to genarate bill?(Y or N)");
			 String optionContinue = myscanner.next();
			 
			 if(optionContinue.equalsIgnoreCase("y") || optionContinue.equalsIgnoreCase("Y") ) {
				 System.out.println("Bill Created Sucessfully");
				  createPdf();
			  }
			  else if(optionContinue.equalsIgnoreCase("n") || optionContinue.equalsIgnoreCase("N")) {
				  
				 System.out.println("Thank You!!");
			  }
		
	}
	
	@Override
	public void createPdf() {
		
		try {
	//	File file = new File("D:\\pharmacy_bill.txt");
		
		FileWriter fileWriter = new FileWriter("D:\\store_bill.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("===========================STORE BILL============================");
		printWriter.println("ISSUED BY : Mr. PASAN PRAMUDITHA");
		printWriter.println("Patient Name : "+ patientName );
		
		for(int i=0 ; i < upgrade.size();i++) {
			  
			printWriter.println(i+1 +"."+upgrade.get(i).getEquipedName()+"     "+upgrade.get(i).getDose()+"     "+upgrade.get(i).getPrice()+"   "+upgrade.get(i).getCount()+"		"+upgrade.get(i).getTotal());
		 
	  	}
		
		printWriter.println("--------------------------");
		printWriter.println("Total - "+tot);
		printWriter.println("--------------------------");
		printWriter.println("Cash - " + cash);
		printWriter.println("Balance - " + balance);
	  
	  System.out.println("Thank You");
	  
		printWriter.print("");
		printWriter.print("============================================================================");
		printWriter.close();
		
		
		}catch (IOException e) {
			System.out.println("An error occured");
		}
	
	}

	@Override
	public void purchesUpgrades(String upgrades,String dose,int price,int count) {
		// ADD UPGRADES TO BILL
				
		  int total = price * count;
		  TotalIncome.add(total);
		  upgrade.add(new Upgrade(ID, upgrades, dose, price,count,total));
		  ID++;
	}

	@Override
	public void myHistory() {
		// DISPLAY STORE HISTORY
		System.out.println("---------------Medicare pharmacy System History List---------------");
		if(upgrade.isEmpty()) {
			System.out.println("History is Empty");
		}
		else {
			
			System.out.println("=========UPGRADE LIST=========");
			for(int i=0;i<upgrade.size();i++) {
				
				System.out.println(i+1+"."+upgrade.get(i).getEquipedName());
				
			}
			System.out.println("=========DETAILS=========");
		
			int totalIncome=0;
			for(int i=0;i<upgrade.size();i++) {
			
				totalIncome = totalIncome + TotalIncome.get(i);
				
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("Patient Count 	-  "+patientBasedList.size());
			System.out.println("My Total Income -  "+totalIncome);
		}
		
	}

	@Override
	public void addPatients(String name) {
		patientBasedList.add(name);
		patientName= name;
		
	}

	@Override
	public void manageUserBill(int cash) {
		this.cash = cash;
		 balance = cash - tot;
		 System.out.println("Your balance is - "+ balance);
		
		  createBill();
		
	}

	@Override
	public void addUpgradeToMyInventory(String upgradeEquip) {
		MyInventory.add(upgradeEquip);
		System.out.println("Upgrade Add Successfully");
		
	}

	@Override
	public void printHistory() {
		try {
			
			FileWriter fileWriter = new FileWriter("D:\\History.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================HISTORY REPORT============================");
			
			
			printWriter.println("=========Upgrade HISTORY=========");
			for(int i=0;i<upgrade.size();i++) {
				
				printWriter.println(i+1+"."+upgrade.get(i).getEquipedName());
				
			}
			printWriter.println("=========DETAILS=========");
		
			int totalIncome=0;
			for(int i=0;i<upgrade.size();i++) {
				
				totalIncome = totalIncome + TotalIncome.get(i);
				
			}
			printWriter.println("----------------------------------------------------------");
			printWriter.println("Patient Count 	-  " + patientBasedList.size());
			printWriter.println("My Total Income -  "+totalIncome);
			
		  
			printWriter.println("-------Thank You----------");
			printWriter.print("");
			printWriter.print("============================================================================");
			printWriter.close();
			
			
		}catch (IOException e) {
			System.out.println("An error occured");
		}
			
	}

	
}
