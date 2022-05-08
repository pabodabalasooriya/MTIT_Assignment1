package com.doctor.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.doctor.service.publisher.DoctorService;

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
		int status = 1,option = 0, check = 0,statUp,statPrint;
		int correct;
		String patientName = "",patientAge = "",discription= "",duration = "", medicineName = "",dose= "",testName,docName="";
		
				System.out.println("=========welcome to Doctor Consultation Service========");
				System.out.println();
				System.out.println();
				
				Activator.context = bundleContext;
				serviceReferenceDoc = bundleContext.getServiceReference(DoctorService.class.getName());
				DoctorService docService = (DoctorService)bundleContext.getService(serviceReferenceDoc);
				
				do {
				System.out.print("Please enter username : ");
				username = scanner.next();
				
				
				System.out.print("Please enter password :");
				password = scanner.next();
				System.out.println();
				
				if(username.equals("doctor") && password.equals("DOCTOR")) {
					System.out.println("Login Successfull");
					System.out.println();
					correct = 1;
					
				}	
					else {
						System.out.println("\tPlease enter  the correct credentials");
						System.out.println();
						correct = 0;
						
					}
				
				}while(correct != 1);
				
					System.out.print("\tEnter your Name :  ");
					docName = scanner.next();
					
					do {
						System.out.println("\n\tChoose your preference by typing the relavent number: ");
						System.out.println("      1 - Add Patient Details ");
						System.out.println("      2 - Add Medicine Details. ");
						System.out.println("      3 - Add Details for Lab Report ");
						System.out.println("      4 - View Summary ");
						option = scanner.nextInt();
						
						if(option == 1  ) {
							
							System.out.println("==== Enter Patient Details ====");
							System.out.println();
							
							
							System.out.print("\n\tEnter the name of the patient:");
							patientName = scanner.next();
							
							System.out.print("\tEnter the age of the patient:");
							 patientAge= scanner.next();
							
							System.out.print("\tDiscription:");
							discription = scanner.next();
							
							
							System.out.println("\n\tSuccsessfully Enter Patient Details \n ");
							
							docService.keepPatientSummary(patientName);
						}
						
						if(option == 2) {
							System.out.println();
							System.out.println("==== Enter Medical Details ====");
							System.out.println();
							
						 do {
							 
							System.out.print("\n\tEnter the name of the patient:");
							patientName = scanner.next();
								
							System.out.print("\nEnter the age of the patient:");
							patientAge= scanner.next();
								
							System.out.print("\nDiscription:");
							discription = scanner.next();
					
							System.out.println("\nEnter Name of the Medicine : ");
							medicineName = scanner.next();
												
							
							System.out.println("\nEnter dose of the Medicine : ");
							dose = scanner.next();
														
							System.out.println("\nEnter duration of take the Medicine : ");
							duration = scanner.next();
							
							System.out.println();
							System.out.println("\n\tSuccsessfuly Enter Medicine Details \n ");
							
							docService.upgradeDose(patientName,patientAge,duration,medicineName,dose,docName,discription);
							
							
							/*System.out.println("\tDo you want to View Medicine Details ? ");
							System.out.println("   Press 0 to Yes");
							System.out.println("   Press 1 to exit");
							status = scanner.nextInt();*/
							
							//System.out.println("\n\tSuccsessfuly Enter Medicine Details \n ");
							
							System.out.println("Do  you want to add Another Medicine Details..? ");
							System.out.println("   Press 0 to continue");
							System.out.println("   Press 1 to exit from Medicare Laboratory and Pharmacy");
							status = scanner.nextInt();
							
							} while(status == 0);
						 
						 	if (status == 1) {
							
						 		System.out.println("\tDo you want to View Medicine Details ? ");
						 		System.out.println("   Press 1 to Yes");
						 		System.out.println("   Press 0 to exit");
						 		int viewStatus = scanner.nextInt();
						 		
						 		if(viewStatus == 1) {
						 					
						 			docService.viewDosePoint(patientName,patientAge,duration,medicineName,dose,docName,discription);
							 		 
						 		
							 	System.out.println("\nDo you want to print the Medicine Details? ");
								System.out.println("  1 - yes");
								System.out.println("  2 - no");
								int printStatus = scanner.nextInt();
								
									if(printStatus == 1) {
									
										//docService.printUpgradeList(patientName,patientAge,duration,medicineName,dose,docName,discription);
										System.out.println(" printed successfully. You can get the prescription now....\nThank you !.");
									 
									}
								
								docService.clearUpgradeDose();
							
						 		}
						 	}
												
						}
						else if(option == 3) {
							System.out.println("====Welcome to Add Details for Lab Report====");
							System.out.println();
							
							do {
								
								System.out.print("\n\tEnter the name of the patient:");
								patientName = scanner.next();
								
								System.out.print("\tEnter the age of the patient:");
								patientAge= scanner.next();
								
								System.out.print("\tDescription:");
								discription = scanner.next();
								
								System.out.println("Enter Name of the test : ");
								testName = scanner.next();
												
								
								docService.doseTest(patientAge,patientName, discription, testName);
								System.out.println("Do you want to continue with this test? ");
								System.out.println("   Press 1 to continue");
								System.out.println("   Press 0 to exit from upgrade test");
								status = scanner.nextInt();
								
								}while(status == 1);
							
								docService.viewUpgradedTest(patientName,patientAge,docName,discription, testName);
								
								System.out.println("Do you want to print the test ? ");
								System.out.println("   1 - yes");
								System.out.println("   2 - no");
								int printTest = scanner.nextInt();
								
								if(printTest == 1) {
									//docService.printTestPrescription(patientName,patientAge,docName,discription, testName);
									System.out.println(" printed successfully. You can get the test description now....\nThank you !.");
									
								}
								
								docService.clearUpgradeTestDose();
								
							}
						
						else if(option == 4) {
							System.out.println("=====Welcome to Summary====");
							System.out.println();
							docService.viewHistory();
							
						}
						
						else {
							
							System.out.println(" Press a valid number");
						}
					
						System.out.println("Do you want to switch to another service?");
						System.out.println(" Press a valid number");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from Doctor Consultation Service");
						option = scanner.nextInt();
						
					
					}while(option < 4);
						
					System.out.println("Thank you for using Doctor Consultation Service");
					System.out.println("Good Bye!....");
					scanner.close();
				
				
			}

		public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Doctor hiring service stop");
	}

}
