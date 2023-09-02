/*
Programmer:	Colby Krenz
Date: 09/02/2023
Program Name: M02 Programming Assignment 1: Chapter 10: Assignment 10.14
Purpose: Design a class named MyDate, Draw the UML diagram for the class and then implement the class.
Write a test program that creates 2 MyDate objects and displays their year, month and day.
*/

public class TheMyDateClass {
	
	//initialize the main method
	public static void main(String[] args) {
		//create 2 new MyDate objects 
		MyDate firstMyDateObject = new MyDate();
		MyDate secondMyDateObject = new MyDate(34355555133101L);
		
		//display the year, month & day of those MyDate objects
		System.out.println("Current Date \nYear: " + firstMyDateObject.getYear() + "  |  Month: " + firstMyDateObject.getMonth() + "  |  Day:" + firstMyDateObject.getDay());
		System.out.println("\nElapsed Date \nYear: " + secondMyDateObject.getYear() + "  |  Month: " + secondMyDateObject.getMonth() + "  |  Day: " + secondMyDateObject.getDay());
	}
}