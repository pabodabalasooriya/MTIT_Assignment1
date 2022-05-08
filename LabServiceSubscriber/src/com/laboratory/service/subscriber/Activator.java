package com.laboratory.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.laboratory.service.publisher.LaboratoryService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		ServiceReference<LaboratoryService>serviceRefrence = context.getServiceReference(LaboratoryService.class);
		LaboratoryService service = (LaboratoryService) context.getService(serviceRefrence);
		
		String docName, password,patientName, doctorName, patientNumber, patientAge;
		int LabserviceType =0 ,pAge =0, command = 0, printCommand, ContinueCommand;
		
		Scanner myscanner = new Scanner(System.in);
				
		
		System.out.println("========= Welcome to Medicare Laboratory and Pharmacy Service =========");
		System.out.println("");
		System.out.println("Please Log in to the Laboratory");
		int correct;
		do {
			System.out.print("Please enter Laboratory doctor Name : ");
			docName = myscanner.next();
			
			System.out.print("Please enter password : ");
			password = myscanner.next();
			
			if(docName.equals("lab") && password.equals("LAB")) {
				System.out.println("");
				System.out.println("Login Successfull");
				System.out.println("");
				correct = 1;
				
			}	
				else {
					System.out.println("Please enter  the correct credentials");
					System.out.println();
					correct = 0;
					
				}
			
			}while(correct != 1);
			
				System.out.print("Please enter your Name : ");
				docName = myscanner.next();
				
				System.out.println("===========================Welcome MLT. "+ docName + " =============================== ");
				
				do {
					System.out.println("Choose your Laboratory Service number:");
					System.out.println("      1 - Test Medical Report. ");
					System.out.println("      2 - View Test List. ");
					System.out.println("      3 - View Patient's Report history. ");
					System.out.println("Enter Laboratory Service Number: ");
					LabserviceType = myscanner.nextInt();
					
					if(LabserviceType == 1) {
						System.out.print("Enter the name of the patient : ");
						patientName = myscanner.next();
						
						System.out.print("Enter the patient Number : ");
						patientNumber = myscanner.next();
						
						System.out.print("Enter the patient Age : ");
						patientAge = myscanner.next();
						
						System.out.print("Enter the name of the doctor : ");
						doctorName = myscanner.next();
						
						System.out.println("");
						
						service.laboratoryReportHistory(patientName);
					
						System.out.println("===========================Welcome to Medicare Laboratory and Pharmacy===========================");
						System.out.println();
					
						service.displayReport();
					
						do {
							//System.out.println("enter test: ");
							//LabtestType = myscanner.nextInt();
						
							System.out.println("Enter Laboratory Test Type : ");
							int testtype = myscanner.nextInt();
							
								if(testtype == 1){
									
									//service.LabTestHistory("Full Blood Report");
									service.selectReportType("Full Blood Report");
								}else if(testtype == 2) {
									
									//service.LabTestHistory("Complete blood count ");
									service.selectReportType("\r\n" + 
											"Complete blood count ");
								}else if(testtype == 3) {
									
									//service.LabTestHistory("Blood cholesterol test");
									service.selectReportType("Blood cholesterol test");
								}else if(testtype == 4){
									
									//service.LabTestHistory("Blood culture");
									service.selectReportType("Blood culture");
								}else if(testtype == 5) {
									
								//	service.LabTestHistory("Blood gases test");
									service.selectReportType("Blood gases test");
								}else if(testtype == 6) {
									
								//	service.LabTestHistory("Urine test");
									service.selectReportType("Urine test");
								}else if (testtype == 7) {
									
								//	service.LabTestHistory("Blood glucose tests");
									service.selectReportType("Blood glucose tests");
								}else if (testtype == 8) {
									
									//service.LabTestHistory("C-reactive protein (CRP) test");
									service.selectReportType("C-reactive protein (CRP) test");
								}else if (testtype == 9) {
									
								//	service.LabTestHistory("Liver function test");
									service.selectReportType("Liver function test");
								}else if(testtype == 10){
									
								//	service.LabTestHistory("Thyroid function test");
									service.selectReportType("Thyroid function test");
								}else{
									
									System.out.println(" Please Contact MLT for any other Laboratory Reports");
								}
						
								
						System.out.println("Do  you want to add Another Laboratory service..? ");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from Medicare Laboratory and Pharmacy");
						command = myscanner.nextInt();
						
						
						}while(command == 1);
						
						
						System.out.println("Do you want to View the Laboratory Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						int ViewCommand = myscanner.nextInt();
						
						if(ViewCommand == 1) {
						
							service.viewLaboratoryReport( patientName, patientNumber, patientAge, doctorName, docName);
						
						}
						
						System.out.println("Do you want to print the Laboratory Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						printCommand = myscanner.nextInt();
						
						if(printCommand== 1) {
							service.reportPrint(patientName, patientNumber, patientAge, doctorName, docName);
							
						}
						
						service.cleardata();
						
					}else if(LabserviceType == 2) {
						System.out.println("====Medicare Laboratory and Pharmacy Test List====");
						System.out.println();
						service.displayReport();
						
							
						
					}else if(LabserviceType == 3) {
						System.out.println("=====Welcome to Laboratory Report Summary====");
						System.out.println();
						service.viewLaboratoryReportHistory();
						
					}
					
					else {
						System.out.println(" Press a valid Command");
					}
				
					System.out.println("Do you want to switch to another service?");
					System.out.println("   Press 1 to continue");
					System.out.println("   Press 0 to exit from Laboratory Service");
					ContinueCommand = myscanner.nextInt();
					
				
				}while(ContinueCommand == 1);
			
			
			myscanner.close();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println();
		System.out.println("===========================Medicare Laboratory and Pharmacy Service Stoped===========================");
	}

}
