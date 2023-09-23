/*
Programmer:	Colby Krenz
Date: 09/23/2023
Program Name: M05 Final Project: Update 3 - Classes/Test Classes
Purpose: Write the Java code for the classes that are required for the application.
Write out test classes to test functionality. (Cinema Seat Saver)
*/

import java.util.*;
import java.io.*;

public class MGTesting {
	// initialize main method
	public static void main(String[] args) {
		
		MGTesting userInput = new MGTesting();
		userInput.getInput();
		
	}
	Scanner input = new Scanner(System.in);	
	//String movieGoer = movieGoer.getInput();
	
		
	public void getInput() {
		
		//prompt user to input information:
		System.out.print("Enter your first name: ");
		String firstName = getUserFName();
		
		System.out.print("Enter your last name: ");
		String lastName = getUserLName();
		
		System.out.print("Enter your phone number: ");
		String phoneNumber = getUserPNumber();
		
		System.out.print("Enter your email: ");
		String email = getUserEmail();
		
		System.out.print("User ID: " + getUserID());
		
	}
	
	public String getUserFName() {
		//Scanner input = new Scanner(System.in);
		String userFirstName = input.next(); 
		return userFirstName;
	}
	
	public String getUserLName() {
		//Scanner input = new Scanner(System.in);
		String userLastName = input.next(); 
		return userLastName;
	}
	
	public String getUserPNumber() {
		//Scanner input = new Scanner(System.in);
		String userPhoneNumber = input.next();
		return userPhoneNumber;	
	}
	
	public String getUserEmail() {
		//Scanner input = new Scanner(System.in);
		String userEmail = input.next();
		return userEmail;	
	}
	
	public int getUserNum() {
		Random rand = new Random();
		int userNumber = rand.nextInt(10000);
		return userNumber;
	}
	
	public String getUserID() {
		String movieGoer = "\nUserID: " + getUserFName() + getUserLName() + getUserNum();
		return movieGoer;
		
	}
	
				
}