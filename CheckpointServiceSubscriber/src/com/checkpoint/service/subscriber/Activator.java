package com.checkpoint.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.checkpoint.service.publisher.CheckpointService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceReference<CheckpointService>serviceRefrence = context.getServiceReference(CheckpointService.class);
		CheckpointService service = (CheckpointService) context.getService(serviceRefrence);
		
		String MLTname, Password,customerName, techinicianName;
		int LabserviceType =0 ,patientAge =0, command = 0, printCommand, ContinueCommand;
		
		Scanner myscanner = new Scanner(System.in);
				
		
		System.out.println("========= Welcome to ABC Hospital Lab Service =========");
		System.out.println("");
		System.out.println("Please Log in to the LAB");
		int correct;
		do {
			System.out.print("Please enter medical laboratory technician Name : ");
			MLTname = myscanner.next();
			
			
			System.out.print("Please enter password : ");
			Password = myscanner.next();
			
			if(MLTname.equals("MLT") && Password.equals("MLTlog")) {
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
				MLTname = myscanner.next();
				
				System.out.println("===========================Welcome MLT. "+ MLTname + " =============================== ");
				
				do {
					System.out.println("Choose your Lab Service number:");
					System.out.println("      1 - Test Medical Report. ");
					System.out.println("      2 - View Test List. ");
					System.out.println("      3 - View Patient's Report history. ");
					System.out.println("Enter Lab Service Number: ");
					LabserviceType = myscanner.nextInt();
					
					if(LabserviceType == 1) {
						System.out.print("Enter the name of the patient : ");
						customerName = myscanner.next();
						
					
						System.out.print("Enter the age of the patient : ");
						patientAge = myscanner.nextInt();
						System.out.print("Enter the name of the Doctor : ");
						techinicianName = myscanner.next();
						System.out.println("");
						
						service.checkpointReportHistory(customerName);
					
						System.out.println("===========================Welcome to ABC Hospital Laboratory===========================");
						System.out.println();
					
						service.displayReport();
					
						do {
							//System.out.println("enter test: ");
							//LabtestType = myscanner.nextInt();
						
							System.out.println("Enter Lab Test Type : ");
							int testtype = myscanner.nextInt();
							
								if(testtype == 1){
									
									//service.LabTestHistory("CBC");
									service.selectReportType("CBC");
								}else if(testtype == 2) {
									
									//service.LabTestHistory("BMP");
									service.selectReportType("BMP");
								}else if(testtype == 3) {
									
									//service.LabTestHistory("STD");
									service.selectReportType("STD");
								}else if(testtype == 4){
									
									//service.LabTestHistory("CMP");
									service.selectReportType("CMP");
								}else if(testtype == 5) {
									
								//	service.LabTestHistory("Lipid Panel");
									service.selectReportType("Lipid Panel");
								}else if(testtype == 6) {
									
								//	service.LabTestHistory("Liver Panel");
									service.selectReportType("Liver Panel");
								}else if (testtype == 7) {
									
								//	service.LabTestHistory("Thyroid Stimulating Hormon");
									service.selectReportType("Thyroid Stimulating Hormon");
								}else if (testtype == 8) {
									
									//service.LabTestHistory("Hemoglobin A1C");
									service.selectReportType("Hemoglobin A1C");
								}else if (testtype == 9) {
									
								//	service.LabTestHistory("Urinalysis");
									service.selectReportType("Urinalysis");
								}else if(testtype == 10){
									
								//	service.LabTestHistory("Cultures");
									service.selectReportType("Cultures");
								}else{
									
									System.out.println(" Please Contact MLT for any other Lab Reports");
								}
						
								
						System.out.println("Do  you want to add Another Lab service..? ");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from ABC Hospital Laboratory");
						command = myscanner.nextInt();
						
						
						}while(command == 1);
						
						
						System.out.println("Do you want to View the Lab Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						int ViewCommand = myscanner.nextInt();
						
						if(ViewCommand == 1) {
						
							service.viewCheckpointReport( customerName,  patientAge, techinicianName , MLTname);
						
						}
						
						
						System.out.println("Do you want to print the Lab Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						printCommand = myscanner.nextInt();
						
						if(printCommand== 1) {
							service.reportPrint(customerName,  patientAge, techinicianName , MLTname);
							
						}
						
						service.cleardata();
						
						
					}else if(LabserviceType == 2) {
						System.out.println("====ABC Hospital laboratory Test List====");
						System.out.println();
						service.displayReport();
						
							
						
					}else if(LabserviceType == 3) {
						System.out.println("=====Welcome to Lab Report Summary====");
						System.out.println();
						service.viewCheckpointReportHistory();
						
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
		System.out.println("===========================ABC Hospital Laboratory Service Stoped===========================");
	}

}
