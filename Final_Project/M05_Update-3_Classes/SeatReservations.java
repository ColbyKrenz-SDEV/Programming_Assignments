/*
Programmer:	Colby Krenz
Date: 09/23/2023
Program Name: M05 Final Project: Update 3 - Classes/Test Classes
Purpose: Write the Java code for the classes that are required for the application.
Write out test classes to test functionality. (Cinema Seat Saver)
*/


import java.util.*;
import java.io.*;

public class SeatReservations {
	// initialize main method
	public static void main(String[] args) {
		
		//create a 2 dimensional array to hold the seats, 4 rows by 5 columns
		int[][] seats = 
			{
				{11,12,13,14,15},
				{21,22,23,24,25},
				{31,32,33,34,35},
				{41,42,43,44,45},
			};
			
		//display the seats with printSeat method and ask user to begin selection process or quit program
		printSeat(seats);
		System.out.println("\nChoose 1 to select a seat or 2 to quit ");
		Scanner input = new Scanner(System.in);
		
		//get user input and while input isn't 2, continue with the program
		int choice = input.nextInt();
		while (choice != 2) {
			//if user selects 1, call the seatID method
			if (choice == 1) {
				seatID(seats);
			}
			
			//display remaining seats with printSeat method and ask for user input again
			printSeat(seats);
			System.out.println("\nChoose 1 to select a seat or 2 to quit");
			choice = input.nextInt();
		}
	}
	
	//create printSeat method
	static void printSeat(int[][] seats) {
		//display the available and taken seats, displayed as rows and columns
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%8s", seats[i][j]);
			}
			System.out.println();
		}
	}
	
	//create seatID method
	static void seatID(int[][] seats) {
		//get user input for which row number they want to sit and assign to variable
		System.out.println("\nEnter the row you want to sit in: ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		//if user input is more than zero but less than the length of the row, continue
		if(row > 0 && row <= seats.length) {
			//get user input for which seat/column number and assign to variable
			System.out.println("\nEnter the seat number you want: ");
			int col = input.nextInt();
			//if user input is more than zero but less than the length of the column + 1, continue
			if(col > 0 && col <= (seats.length+1)) {
				//if the specified seat isn't equal to zero, assign the seat to the user
				if(seats[row-1][col-1] != 0) {
					seats[row-1][col-1] = 0; 
					System.out.println("\nYou've selected: Row: " + row + ", Seat: " + col);
					String reserveSeat = (row + "-" + col);
				}
				//otherwise warn the user the seat has already been reserved
				else {
					System.out.println("\n**SORRY, ROW " + row + ", SEAT " + col + " IS ALREADY TAKEN!**\n");
				}
			}
			//otherwise warn user it isn't a valid seat and start over
			else {
				System.out.println("\n**SORRY, THAT ISN'T A VALID SEAT!**\n");
			}
		}
		//otherwise warn user it isn't a valid row and start over
		else	
		{
			System.out.println("\n**SORRY, THAT ISN'T A VALID ROW!**\n");
		}
	}
	
}