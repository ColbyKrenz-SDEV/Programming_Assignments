/*
Programmer:	Colby Krenz
Date: 09/02/2023
Program Name: M02 Programming Assignment 3: Chapter 12: Assignment 12.9
Purpose: Define a custom exception called BinaryFormatException and implement the class
*/

//define a class that extends the IllegalArgumentException
public class BinaryFormatException extends IllegalArgumentException {
	//create a constructor that takes in the binary string
	//define a custom exception that displays a message	
	public BinaryFormatException(String errorMessage) {
		//call the exception directly
		super(errorMessage);
	}
}
