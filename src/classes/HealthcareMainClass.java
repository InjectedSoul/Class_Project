package classes;

import java.util.Scanner;

public class HealthcareMainClass {

	public static void main(String[] args) 
	{
		//This variable will help determine the size of the arrays.  
		int numberOfAppointments;
		//This will be used as in index to keep track of which part of the array is currently active.
		int currentPatient=0;
		//This will keep track of how many patients have checked in.
		int numberPatients=0;
		//This will keep track of who is next in the waiting list, who has not been assigned.
		int nextPatient=0;
		
		//For allowing a user to type in data
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("--Start of Day--");
		System.out.println("How many available appointment slots are there for the current business day?");
		
		numberOfAppointments = userInput.nextInt();
		
		//This will be a single dimensional array to keep track of all patients.
		//As a patient checks in we will add them to this array.
		Patient[] patientList = new Patient[numberOfAppointments];
		
		//Create a single dimensional array of meaningless employees.  
		//This can be implemented further to allow user input of real employees.
		Employees[] employeeList = new Employees[3];
		employeeList[0] = new Employees("Employee1", "LastName1", "Nurse", "Check Ups", 60000.00);
		employeeList[1] = new Employees("Employee2", "LastName2", "Doctor", "General Medicine", 100000.00);
		employeeList[2] = new Employees("Employee3", "LastName3", "Surgeon", "Surgery", 150000.00);
	
		
		//Create a Default Patient object for each available slot.
		//These will be updated as users check in.
		for(int index=0; index<numberOfAppointments; index++)
		{
			patientList[index] = new Patient();
		}
		
		//This will be a 2 dimension array where each "row" contains a patient and an employee.
		//That is why the 2nd dimension is a 2.  We will use this to assign the patients who 
		//are waiting to an employee, and use the currentPatient to keep track of where we are.
		//The array is set to hold the type Object, because we want to be able to hold two different classes.
		Object[][] patientAssignments = new Object[numberOfAppointments][2];
		
		//This is a basic menu system to try out some functions.
		int userSelection;
		do
		{
			System.out.println("\n================");
			System.out.println("Please select an action.");
			System.out.println("1: Check in patient");
			System.out.println("2: Assign patient to employee");
			System.out.println("3: View current assigned patient");
			System.out.println("4: View all checked in patients");
			System.out.println("5: Mark current patient as complete");
			System.out.println("6: View patient who is next in line");
			System.out.println("7: End of Day (Exit)");
			userSelection = userInput.nextInt();
			
			switch(userSelection)
			{
				//Take in user date for patient's first and last name.
				//Other data fields can be utilized later.
				//We will then use the numberPatients variable to determine
				//where in the array to add this data.
				case 1:
					String input;
					System.out.println("Check In Patient:");
					System.out.println("Patient's First Name?");
					
					//The following line is to prevent an error where the program jumped to the next step on its own.
					userInput.nextLine();
					
					input = userInput.nextLine();
					
					//Use set methods of patient class
					patientList[numberPatients].setFirstName(input);
					System.out.println("Patients Last Name?");
					input = userInput.nextLine();
					patientList[numberPatients].setLastName(input);
					
					//We have added a patient, so the number of patients is now 1 greater.
					numberPatients++;
					break;
				
				case 2:
					int selection;
					System.out.println("Assign Current Patient to Which Employee?");
					System.out.println("1: Nurse, 2: Doctor, 3: Surgeon");
					selection = userInput.nextInt();
					
					//Here we use the nextPatient variable to determine who is next in line to be
					//assigned to an employee, and assign them to the selected employee.
					if (selection == 1)
					{
						patientAssignments[0][currentPatient]=patientList[nextPatient];
						patientAssignments[1][currentPatient]=employeeList[0];
					}
					if (selection == 2)
					{
						patientAssignments[0][currentPatient]=patientList[nextPatient];
						patientAssignments[1][currentPatient]=employeeList[1];
					}
					if (selection == 3)
					{
						patientAssignments[0][currentPatient]=patientList[nextPatient];
						patientAssignments[1][currentPatient]=employeeList[2];
					}
					
					//Since the patient is now assigned, the nextPatient variable should increase, so that it
					//represents the next patient in line.
					nextPatient++;
					break;
				
				case 3:
					
					//This code will show who the patient currently being helped is.
					//If there is not a patient currently assigned, it will throw a NullPointerException,
					//So a try/catch is used to prevent crashing.
					try
					{
						System.out.println("Current Patient Is:");
						System.out.println("Patient:");
						System.out.println(patientAssignments[0][currentPatient].toString());
						System.out.println("Assigned to Employee:");
						System.out.println(patientAssignments[1][currentPatient].toString());
					}
					catch(NullPointerException e)
					{
						//Simple error message.
						System.out.println("No patient currently assigned.");
					}
					break;
					
				case 4:
					//We don't need to display anyone below the current patient, because
					//all of these patients have already been helped and are done with
					//the service.  This will display the patient currently assigned, along
					//with all the patients who are waiting.
					
					for (int i=currentPatient; i<numberPatients; i++)
					{
						System.out.println(patientList[i].toString());
					}
					break;
					
				case 5: 
					//This is pretty simple code, all it is doing is increasing the currentPatient
					//variable by 1, therefore marking the previous patient who was assigned to an employee
					//as complete.
					
					System.out.println("Current Patient Complete!");
					System.out.println("System Updated.");
					currentPatient++;
					break;
					
				case 6:
					//This will just display the next patient who is waiting to be assigned.
					//The nextPatient variable is increased whenever a patient is assigned, moving up the array.
					
					System.out.println("\nIn the waiting list, the next patient to be helped:");
					System.out.println(patientList[nextPatient].toString());
					break;
				case 7:
					//This is just to exit, and a simple message to user.
					
					System.out.println("Good Night!");
					break;
			
			}
			
		}
		//when a 7 is entered, loop is exited, program closes.
		while(userSelection != 7);
		userInput.close();
		
	}

}
