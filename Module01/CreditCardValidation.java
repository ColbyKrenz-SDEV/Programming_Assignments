/*
Programmer:	Colby Krenz
Date: 08/25/2023
Program Name: M01 Programming Assignment 1: Chapter 6: Assignment 6.31
Purpose: Prompt the user to enter a credit card number as a long integer and display if it is valid or invalid
*/

// Import the Scanner class to obtain user input
import java.util.Scanner;

public class CreditCardValidation {
	// Initialize main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to input credit card number as long integer
		System.out.print("Enter a credit card number as a long integer: ");
		long number	= input.nextLong();
		// Print to the screen whether number is valid or invalid
		System.out.println(
				number + " is " + (isValid(number) ? "valid" : "invalid"));
		
		}
	
	// Return true if the card number is valid
	public static boolean isValid(long number) {
		// Determine if the input is valid
		// Check if it is between 13 and 16 digits
		// Check if it starts with 4, 5, 6, or 37
	
		// Check it against the Luhn check/Mod 10 check method
		boolean valid = 
				(getSize(number) >= 13 && getSize(number) <= 16) &&
				(prefixMatched(number, 4) || prefixMatched(number, 5) ||
				prefixMatched(number, 6) || prefixMatched(number,37)) &&
				((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
		return valid;
	}
	
	// Get the result from Step 2
	// Double every second digit from right to left and add them together
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String num = number + "";
		for(int i = getSize(number) - 2; i >= 0; i -= 2) {
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}
	
	// Return this number if it is a single digit, otherwise return the sum of the two digits
	// If doubling results in a two-digit number, add up the two digits to get a single-digit number
	public static int getDigit(int number) {
		if(number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}
	
	// Return sum of odd-place digits in number
	// Sum up the remaining digits in the odd positions
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String num = number + "";
		for(int i = getSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
	
	// Return true if the number d is a prefix for number
	// d must begin with 4, 5, 37 or 6 to be valid
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}
	
	// Return the number of digits in d
	// d must be between 13 and 16 digits
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}
	
	// Return the first k number of digits from number
	// If the number of digits in number is less than k, return number
	public static long getPrefix(long number, int k) {
		if(getSize(number) > k) {
			String num = number + "";
			return Long.parseLong(num.substring(0, k));
		}
		return number;
	}
}