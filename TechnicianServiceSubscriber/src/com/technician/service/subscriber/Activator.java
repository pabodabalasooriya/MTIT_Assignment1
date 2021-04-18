package com.technician.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.technician.service.publisher.TechnicianService;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReferenceDoc;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Scanner scanner = new Scanner(System.in);
		String username, password;
		int status = 1,option = 0,statMed,statPrint;
		int correct = 1;
		String pname = "",page = "",dname = "", medName,medDosage,medDuration,testName;
		try {
		System.out.println("=========welcome to Technician Consultation Service========");
		
		Activator.context = bundleContext;
		serviceReferenceDoc = bundleContext.getServiceReference(TechnicianService.class.getName());
		TechnicianService doctorService = (TechnicianService)bundleContext.getService(serviceReferenceDoc);
		
		do {
		System.out.print("Please enter username : ");
		username = scanner.next();
		System.out.println();
		
		System.out.print("Please enter password :");
		password = scanner.next();
		System.out.println();
		
		if(username.equals("doctor") && password.equals("docLogin")) {
			System.out.println("Login Successfull");
			System.out.println();
			correct = 1;
			
		}	
			else {
				System.out.println("Please enter  the correct credentials");
				System.out.println();
				correct = 0;
				
			}
		
		}while(correct != 1);
		
			System.out.println("Please enter your name : ");
			dname = scanner.next();
			
			System.out.println("===========================Welcome Mr.. "+ dname + " =============================== ");
			
			do {
				System.out.println("Choose your preference by typing the relavent number:");
				System.out.println("      1 - Package upgrade. ");
				System.out.println("      2 - Packaging tests. ");
				System.out.println("      3 - View daily history. ");
				option = scanner.nextInt();
				
				if(option == 1 || option == 2) {
					System.out.println("Enter the name of the customer:");
					pname = scanner.next();
					
					System.out.println("Enter the age of the customer:");
					page = scanner.next();
					
					doctorService.keepCustomerSummary(pname);
				}
				
				if(option == 1) {
					System.out.println("====Welcome to P upgrade====");
					System.out.println();
					
					
				do {
			
					System.out.println("Enter Name of the upgrade : ");
					medName = scanner.next();
					
					System.out.println("Enter dosage of the upgrade : ");
					medDosage = scanner.next();
					
					System.out.println("Enter duration of the upgrade : ");
					medDuration = scanner.next();
					
					doctorService.prescribeMedicine(medName,medDosage,medDuration);
					System.out.println("Do  you want to continue with packaging upgrade? ");
					System.out.println("   Press 1 to continue");
					System.out.println("   Press 0 to exit from packaging medicine");
					statMed = scanner.nextInt();
					
					}while(statMed == 1);
					
					doctorService.viewMedicinePrescription(pname,page,dname);
					
					System.out.println("Do you want to print the packaging? ");
					System.out.println("   1 - yes");
					System.out.println("   2 - no");
					statPrint = scanner.nextInt();
					
					if(statPrint == 1) {
						doctorService.printUpgradeList(pname,page,dname);
						
					}
					
					doctorService.clearMedicinePrescription();
					
				}
				
				else if(option == 2) {
					System.out.println("====Welcome to packaging test====");
					System.out.println();
					
					do {
						System.out.println("Enter Name of the test : ");
						testName = scanner.next();
						
						doctorService.prescribeTest(testName);
						System.out.println("Do  you want to continue with packaging test? ");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from prescribing test");
						statMed = scanner.nextInt();
						
						
						}while(statMed == 1);
					
						doctorService.viewPrescribedtest(pname, page,dname);
						
						System.out.println("Do you want to print the test package? ");
						System.out.println("   1 - yes");
						System.out.println("   2 - no");
						statPrint = scanner.nextInt();
						
						if(statPrint == 1) {
							doctorService.printTestPrescription(pname,page,dname);
							
						}
						
						doctorService.clearTestPrescription();
						
					}
				
				else if(option == 3) {
					System.out.println("=====Welcome to View daily Summary====");
					System.out.println();
					doctorService.viewHistory();
					
				}
				
				else {
					System.out.println(" Press a valid number");
				}
			
				System.out.println("Do you want to switch to another service?");
				System.out.println("   Press 1 to continue");
				System.out.println("   Press 0 to exit from Doctor Consultation Service");
				status = scanner.nextInt();
				
			
			}while(status == 1);
				
			System.out.println("Thank you for using Technician Consultation Service");
			System.out.println("Good Bye!....");
			scanner.close();
		
		}catch (Exception e) {
			
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Technician hiring service stop");
	}

}
