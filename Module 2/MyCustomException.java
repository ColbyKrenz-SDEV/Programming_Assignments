/*
Programmer:	Colby Krenz
Date: 09/02/2023
Program Name: M02 Programming Assignment 3: Chapter 12: Assignment 12.9
Purpose: Define a custom exception called BinaryFormatException and implement the class
*/

public class MyCustomException {
	
	//initialize the main method and declare that the main method can throw the custom exception
	public static void main(String[] args) throws BinaryFormatException {
		//print normal binary to decimal
		System.out.println(bin2Dec("10101010"));
		//throw an error
		System.out.println(bin2Dec("j0e1p0w1"));
	}
	
	//declare the method and that the method can throw the custom error
	public static int bin2Dec(String binaryString) throws BinaryFormatException {
		if(!isBinary(binaryString)) {
			//throw the custom exception if the string is not binary
			throw new BinaryFormatException(binaryString + " is not a binary string.");
		}
		//convert binary to decimal number
		int counter = 0;
		int decimal = 0;
		for (int i = binaryString.length() - 1; i >= 0; i--) {
			if(binaryString.charAt(i) == '1') {
				decimal += Math.pow(2, counter);
			}
			counter++;
		}
		//display the decimal number
		return decimal;
	}
	//convert the string into a character array
	public static boolean isBinary(String binaryString) {
		for(char characterSequence : binaryString.toCharArray()) {
			//if the characters aren't equal to 1 AND 0, it returns false
			if(characterSequence != '1' && characterSequence != '0') return false;
		}
		return true;
	}
}