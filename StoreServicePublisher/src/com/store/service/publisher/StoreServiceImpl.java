package com.store.service.publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.IIOException;

public class StoreServiceImpl implements StoreService{

	ArrayList<Upgrade>upgrade = new ArrayList<Upgrade>();
	ArrayList<String> customerBasedList = new ArrayList<String>();
//	ArrayList<String> medicineNameLst;
//	ArrayList<String> medicineDoseLst;
	ArrayList<String> MyInventory = new ArrayList<String>();
//	ArrayList<Integer> medicineTabletPriceLst;
//	ArrayList<Integer> medicineTotalPriceLst;
//	ArrayList<Integer> medicineTabletCount;
	ArrayList<Integer> TotalIncome = new ArrayList<Integer>();
	String customerName="";
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
		
		// DISPLAY THE PHARMACY INVENTORY
		System.out.println("===== Upgrade Inventory =====");
		System.out.println("1. Tyres 165 /70/R13      1tablet = Rs. 25.00");
		System.out.println("2. Honda Civic Beat Silencer    1tablet = Rs. 30.00");
		System.out.println("3. Aqua Car Silencer       1tablet = Rs. 15.00");
		System.out.println("4. 4d506 Engine       1tablet = Rs. 12.00");
		
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
		System.out.println("==============Auto Miraj Store================");
		System.out.println("--------------------YOUR BILL----------------------");
		  System.out.println("Store" +"         "+"Dose"+"      "+"Price" +  "   " +"Quntity"+"      "+"Total");
		 
		 
		  
		 
		  	for(int i=0 ; i < upgrade.size();i++) {
			  
		  		 System.out.println(i+1 +"."+upgrade.get(i).getName()+"     "+upgrade.get(i).getDose()+"     "+upgrade.get(i).getPrice()+"      "+upgrade.get(i).getCount()+"		"+upgrade.get(i).getTotal());
			 
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
		
		
		FileWriter fileWriter = new FileWriter("D:\\pharmacy_bill.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("===========================STORE BILL============================");
		printWriter.println("ISSUED BY : Mr. PASAN PRAMUDITHA");
		printWriter.println("Customer Name : "+ customerName );
		
		for(int i=0 ; i < upgrade.size();i++) {
			  
			printWriter.println(i+1 +"."+upgrade.get(i).getName()+"     "+upgrade.get(i).getDose()+"     "+upgrade.get(i).getPrice()+"   "+upgrade.get(i).getCount()+"		"+upgrade.get(i).getTotal());
		 
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
		// TODO: handle exception
		System.out.println("An error occured");
	}
		

		
		
	}
	

	@Override
	public void purchesUpgrades(String medicine,String Dose,int price,int count) {
		// ADD MEDICINE TO BILL
				
		  int total = price * count;
		  TotalIncome.add(total);
		  upgrade.add(new Upgrade(ID, medicine, Dose, price,count,total));
		  ID++;
	}

	

	@Override
	public void myHistory() {
		// DISPLAY PHARMACY HISTORY
		System.out.println("---------------Auto Miraj Store System History List---------------");
		if(upgrade.isEmpty()) {
			System.out.println("History is Empty");
		}
		else {
			
			System.out.println("=========UPGRADE LIST=========");
			for(int i=0;i<upgrade.size();i++) {
				
				System.out.println(i+1+"."+upgrade.get(i).getName());
				
			}
			System.out.println("=========DETAILS=========");
		
			int totalIncome=0;
			for(int i=0;i<upgrade.size();i++) {
				
			
				totalIncome = totalIncome + TotalIncome.get(i);
				
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("Customer Count 	-  "+customerBasedList.size());
			System.out.println("My Total Income -  "+totalIncome);
		}
			
		
	}

	@Override
	public void addCustomers(String name) {
		// TODO Auto-generated method stub
		customerBasedList.add(name);
		customerName= name;
		
	}

	@Override
	public void manageUserBill(int cash) {
		// TODO Auto-generated method stub
		this.cash = cash;
		 balance = cash - tot;
		 System.out.println("Your balance is - "+ balance);
		
		  createBill();
		
	}

	@Override
	public void addUpgradeToMyInventory(String medicineName) {
		// TODO Auto-generated method stub
		MyInventory.add(medicineName);
		System.out.println("Upgrade Add Successfully");
		
	}

	@Override
	public void printHistory() {
		// TODO Auto-generated method stub
		try {
			
			FileWriter fileWriter = new FileWriter("D:\\History.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================HISTORY REPORT============================");
			
			
			printWriter.println("=========Upgrade HISTORY=========");
			for(int i=0;i<upgrade.size();i++) {
				
				printWriter.println(i+1+"."+upgrade.get(i).getName());
				
			}
			printWriter.println("=========DETAILS=========");
		
			int totalIncome=0;
			for(int i=0;i<upgrade.size();i++) {
				
				totalIncome = totalIncome + TotalIncome.get(i);
				
			}
			printWriter.println("----------------------------------------------------------");
			printWriter.println("Customer Count 	-  "+customerBasedList.size());
			printWriter.println("My Total Income -  "+totalIncome);
			
		  
			printWriter.println("-------Thank You----------");
			printWriter.print("");
			printWriter.print("============================================================================");
			printWriter.close();
			
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occured");
		}
			
	}

	
}
