package com.laboratory.service.publisher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LaboratoryServiceImpl implements LaboratoryService {
	
	ArrayList<Laboratory> labName = new ArrayList<Laboratory>(); 
	ArrayList<Double> labResult = new ArrayList<Double>();
	ArrayList<String> labHistory = new ArrayList<String>();
	ArrayList<String> labTestHistory = new ArrayList<String>();
	
	@Override
	public void displayReport() {
		
		System.out.println("====== Lab Reports ======");
		System.out.println("--1. Full Blood Report");
		System.out.println("--2. Complete blood count");
		System.out.println("--3. Blood cholesterol test");
		System.out.println("--4. Blood culture");
		System.out.println("--5. Blood gases test");
		System.out.println("--6. Urine test");
		System.out.println("--7. Blood glucose tests");
		System.out.println("--8. C-reactive protein (CRP) test");
		System.out.println("--9. Liver function test");
		System.out.println("--10. Thyroid function test");
		
	}

	@Override
	public void selectReportType(String labservicetype) {
		
	labName.add( new Laboratory (labservicetype));
	labTestHistory.add(labservicetype);
	
	double max = 10; 
    double min = 1; 
    double range = max - min + 1; 

    // generate random numbers within 1 to 10 
    for (int i = 0; i < 10; i++) { 
        double rand = (Math.random() * range) + min; 
        labResult.add(rand);
    	}

	}		
	
	@Override
	public void laboratoryReportHistory(String patientName) {
		// TODO Auto-generated method stub
		if(!labHistory.isEmpty()){
			int last = labHistory.size() - 1;
			String previous = labHistory.get(last);
		
			if(!previous.equals(patientName)) {
				labHistory.add(patientName);
			}
		}else{
			labHistory.add(patientName);	
		}	
	}
	
	@Override
	public void reportPrint(String patientName, String patientNumber, String patientAge, String doctorName, String docName) {
		
		try {
			File file = new File("C:\\Users\\Hp\\Desktop\\LabReport.txt");
			
			FileWriter fileWriter = new FileWriter("C:\\Users\\Hp\\Desktop\\LabReport.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================Checkpoint Report============================");
			printWriter.println("Order Investigation by : Mr. " + doctorName);
			printWriter.println("Patient Age : " + patientAge + "                                 Patient Number: "+ patientNumber);
			printWriter.println("Patient  Name : " + patientName);
			for(int i = 0; i<= labName.size()- 1; i++ ) {
				printWriter.println(labName.get(i).getLabtestType() + "                				Test Result :" + labResult.get(i));
			}
			printWriter.println("");
			printWriter.println("============================================================================");
			printWriter.close();
			
		}catch (IOException e) {
			
			System.out.println("An error occured");
		}
    }

	@Override
	public void viewLaboratoryReport(String patientName, String patientNumber, String patientAge, String doctorName, String docName){

		System.out.println("=================================Checkpoint Report=================================");
		System.out.println("");
		System.out.println("Requested by : Mr. " + doctorName);
		System.out.println("Patient Age : " + patientAge +"                                 Patient Number: "+ patientNumber);
		System.out.println("Patient  Name : " + patientName);
		System.out.println("");
		for(int i = 0; i<= labName.size()- 1; i++ ) {
			System.out.println(labName.get(i).getLabtestType() + "                                        test Result: "+ labResult.get(i));
		}
		System.out.println("");
		System.out.println("============================================================================");
		
	}

	@Override
	public void cleardata() {
	
		labResult.clear();
		labName.clear();
		
	}

	@Override
	public void viewLaboratoryReportHistory() {
		
		int Patientcount = 0, Tcount = 0;
		
		System.out.println("================================View Checkpoint Report Summary=================================");
		System.out.println("Patient  Names for the day : ");
		
		for(int i = 0; i <= (labHistory.size() - 1); i++) {
			System.out.println(i+1+"."+labHistory.get(i));
				
			Patientcount = labHistory.size();
			 Tcount = labTestHistory.size();
			 	 
		}
		for(int x = 0 ; x<= (labTestHistory.size() -1) ;x++) {
							System.out.println("              - " + labTestHistory.get(x) );
						}
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Total number of Patient s : "+ Patientcount+"           Total number of Patient s : "+Tcount );
		System.out.println();
		System.out.println("===================================================================================");
		
		
		
	}
	
	}


