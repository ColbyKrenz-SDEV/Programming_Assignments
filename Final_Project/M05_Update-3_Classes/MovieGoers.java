/*
Programmer:	Colby Krenz
Date: 09/23/2023
Program Name: M05 Final Project: Update 3 - Classes/Test Classes
Purpose: Write the Java code for the classes that are required for the application.
Write out test classes to test functionality. (Cinema Seat Saver)
*/

import java.util.*;
import java.io.*;

public class MovieGoers {
	// initialize main method
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//prompt user to input information:
		System.out.print("Enter your first name: ");
		String userFirstName = input.next(); 
		
		System.out.print("Enter your last name: ");
		String userLastName = input.next();
		
		System.out.print("Enter your phone number: ");
		String userPhoneNumber = input.next();
		
		System.out.print("Enter your email: ");
		String userEmail = input.next();
		
		//create random number for user id
		Random rand = new Random();
		int userID = rand.nextInt(10000);
		
		String movieGoer = userFirstName + userLastName + userID;
		
		//print user information
		System.out.println("\nHello " + userFirstName + " " + userLastName + "!\n\nHere is you UserID:\n" + movieGoer);			
	}	
}