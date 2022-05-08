package com.pharmacy.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.pharmacy.service.publisher.PharmacyService;
import com.pharmacy.service.publisher.PharmacyServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceReference<PharmacyService> serviceRefrence = (ServiceReference<PharmacyService>) context.getServiceReference(PharmacyService.class);
		
		PharmacyService service = (PharmacyService) context.getService(serviceRefrence);
		 
		 //DEFINE VARIABLE
		String userName,password;
		int repeat =0;
		Scanner myscanner = new Scanner(System.in);
		
		//START MAIN SYSTEM
		do {
			
			//ACCES CONTROL
			System.out.print("Please Enter User Name - ");
			userName = myscanner.next();
			System.out.print("Please Enter Password  - ");
			password = myscanner.next();
			
		//CHECK USERNAME AND PASSWORD
		if(userName.equalsIgnoreCase("pharmacy") && password.equalsIgnoreCase("PHARMACY")) {
		 
		 //DEFINE AREA
		 PharmacyService pharmacyService = new PharmacyServiceImpl();
		 
		 System.out.println("------- Welcome to Medicare Pharmacy System ---------");
		  int i =0;
		  //START Pharmacy SYSTEM SYSTEM
		  do {
		
		 //DISPLAY OPTIONS
		  System.out.println("Choose Option :");
		  service.displayOption();
		
		  //GET INPUT AND OUTPUT
		  int option = myscanner.nextInt();	
		  
		  //SELECT OPTION 01 => PURCHES EQUIPMENTS
		  if(option == 1) {
			  
			  System.out.print("Please Enter the Patient Name - ");
			  String patientName = myscanner.next();
			  //CALL ADD CUSTOMER METHOD
			  service.addPatients(patientName);
			  
			  int j=0;
			  //START ADD UPGRADES
			  do {
			  System.out.print("Please Enter the Upgrade Name - ");
			  String upgradeName = myscanner.next();
			  
			  System.out.print("Please Enter the Upgrade Dose - ");
			  String nextFix = myscanner.next();
			  
			  System.out.print("Please Enter the medicine Count - ");
			  int qty = myscanner.nextInt();
			  
			  System.out.print("Please Enter the medicine Price - ");
			  int equipedPrice = myscanner.nextInt();
			  
			  
			  //CALL PURCHESMEDICINE
			  service.purchesUpgrades(upgradeName,nextFix,equipedPrice,qty); 
			  
			  //ADD ANOTHER MEDICINE 
			  System.out.print("Do you want to upgrade?(Y or N) - ");
			 String optionContinue = myscanner.next();
			 if(optionContinue.equalsIgnoreCase("y") || optionContinue.equalsIgnoreCase("Y") ) {
				  j = -1;
			  }
			  else if(optionContinue.equalsIgnoreCase("n") || optionContinue.equalsIgnoreCase("N")) {
				  j= 1;
				  
				  service.calculateBill();
				  
				  System.out.print("Cash - ");
				  int cash = myscanner.nextInt();
				  service.manageUserBill(cash);
			
			  }
			  
			  }while(j<0);// END ADD MEDICINE
			  
		  }
		  
		//SELECT OPTION 02 => PHARMACY INVENTORY  
		  else if(option == 2) {
			  
			  System.out.println("============= Medicare Pharmacy Inventory ===============");
			  System.out.println("Please Select Your Options");
			  System.out.println("1. My Current Inventory");
			  System.out.println("2. Upgrade");
			  
			  int IOption = myscanner.nextInt();
			  if(IOption == 1)
				  	service.getUpgradeList();
			  else { 
				  System.out.print("Enter Your Upgrade - ");
				  
				  String medicineName = myscanner.next();
				  service.addUpgradeToMyInventory(medicineName);
			  }
			  
		  }
		//SELECT OPTION 03 => MY HISTORY 
		  else if(option == 3) {
			 service.myHistory();
			 
			 System.out.print("Do you want Genarate Report?(Y or N) - ");
			 String IOption3 = myscanner.next();
			 
			 if(IOption3.equalsIgnoreCase("y")||IOption3.equalsIgnoreCase("Y")) {
				 service.printHistory();
			 }

			  
		  }
		//SELECT OPTION 00 => EXIT
		  else if(option == 0) {
			  System.out.println("Thank You!!");
			  
		  }
		  
		  //SYSTEM RUN AGAIN
		  System.out.println("Do you want Try Again? (Y or N)");
		  String optionContinue = myscanner.next();
		  
		  //CONDIATIONS (YES OR NO)
		  if(optionContinue.equalsIgnoreCase("y") || optionContinue.equalsIgnoreCase("Y") ) {
			  i = -1;
		  }
		  else if(optionContinue.equalsIgnoreCase("n") || optionContinue.equalsIgnoreCase("N")) {
			  i= 1;
		  }
		  
		  else {
			  System.out.println("Please input correct letter");
		  }
		
		  }while(i<0);//END PHARMACY SYSTEM
		  
		  //USERNAME OR PASSWORD INCORRECT
		}else {
			System.out.println("Acces Dined!!");
			System.out.println("Do you want try again ?(-1.Exit , 1.Try Again)");
			repeat = myscanner.nextInt();
		}
		
		}while(repeat>0);//END MAIN SYSTEM
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Pharmacy Sevice Stop");
	}

}
