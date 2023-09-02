/*
Programmer:	Colby Krenz
Date: 09/01/2023
Program Name: M02 Programming Assignment 1: Chapter 10: Assignment 10.14
Purpose: Design a class named MyDate, Draw the UML diagram for the class and then implement the class.
Write a test program that creates 2 MyDate objects and displays their year, month and day.
*/

import java.util.GregorianCalendar;

public class MyDate {
	//create the data fields that represent a date
	private int year;
	private int month;
	private int day;

	//no-arg constructor that creates a MyDate object for the current date
	MyDate() {
		GregorianCalendar calender = new GregorianCalendar();
		year = calender.get(GregorianCalendar.YEAR);
		month = calender.get(GregorianCalendar.MONTH);
		day = calender.get(GregorianCalendar.DAY_OF_MONTH);
	}

	//constructor that creates a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds
	MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}

	//constructor that creates a MyDate object with the specified year, month, and day
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	//3 getter methods for the data fields year, month, and day, respectively
	public int getYear() {
		return year;
	}
	public int getMonth() {
		int currentMonth = Integer.valueOf(month + 1);
		return currentMonth;
	}
	public int getDay() {
		return day;
	}

	//method that sets a new date for the object using the elapsed time
	public void setDate(long elapsedTime) {
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTimeInMillis(elapsedTime);
		year = calender.get(GregorianCalendar.YEAR);
		month = calender.get(GregorianCalendar.MONTH);
		day = calender.get(GregorianCalendar.DAY_OF_MONTH);
	} 
}