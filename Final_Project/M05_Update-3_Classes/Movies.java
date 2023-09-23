/*
Programmer:	Colby Krenz
Date: 09/23/2023
Program Name: M05 Final Project: Update 3 - Classes/Test Classes
Purpose: Write the Java code for the classes that are required for the application.
Write out test classes to test functionality. (Cinema Seat Saver)
*/


import java.util.*;
import java.io.*;

public class Movies {
	// initialize main method
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//display all the movie choices
		String[] movieName = {"Barbie", "Expend4bles", "Oppenheimer", "The Nun II", "Saw X"};
		for (int i = 0; i < movieName.length; i++) {
			System.out.print(movieName[i] + "     ");
		}
		//ask for user input and assign to variable
		System.out.print("\nSelect a movie: ");		
		String nameChoice = input.next();
		
		/*//working on validation for choices, but only getting "Movie not found" even if input matches
		//in the gui for this app, may not need validation since the selections will be checkboxes
		boolean found = false;
		for (int n = 0; n < movieName.length; n++) {
			if(movieName[n].equals(nameChoice)) { found = true; } }
		if(found) { System.out.println("Okay"); }
		else { System.out.println("Movie not found"); }*/
		
		//display the day choices
		String[] movieDay = {"\nMonday", "Tuesday", "Thursday", "Friday", "Saturday"};
		for (int i = 0; i < movieDay.length; i++) {
			System.out.print(movieDay[i] + "     ");
		}
		//ask for user input and assign to variable
		System.out.print("\nSelect a day to see " + nameChoice + ": ");
		String dayChoice = input.next();
		
		//display the time choices
		String[] movieTime = {"\n9:00am", "11:30am", "2:00pm", "5:00pm", "8:30pm"};
		for (int i = 0; i < movieTime.length; i++) {
			System.out.print(movieTime[i] + "     ");
		}
		//ask for user input and assign to variable
		System.out.print("\nSelect a time to see " + nameChoice + " on " + dayChoice + ": ");
		String timeChoice = input.next();
		
		//display user's choices
		System.out.print("\nYou have a ticket for " + nameChoice + " on " + dayChoice + " at " + timeChoice);
	}
}
		
		