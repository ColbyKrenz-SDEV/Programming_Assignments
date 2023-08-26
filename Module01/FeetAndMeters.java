/*
Programmer:	Colby Krenz
Date: 08/24/2023
Program Name: M01 Programming Assignment 1: Chapter 6: Assignment 6.9
Purpose: To convert between feet and meters and display a table with the results
*/

public class FeetAndMeters {
	// Initialize main method
	public static void main(String[] args) {
		// Display results in a table
		System.out.println("\n Feet    Meters   |    Meters    Feet\n" + "-----------------------------------------");
		// Create a for loop that increments feet by 1 and provides the subsequent equivalent in meters
		// Also increments meters by 5 and provides the subsequent equivalent in feet
		for (double feet = 1.0, meters = 20.0; feet <= 10.0; feet++, meters +=5) {
			System.out.printf("%4.1f     ", feet);
			System.out.printf("%5.3f", footToMeter(feet));
			System.out.printf("    |    ");
			System.out.printf("%-10.1f", meters);
			System.out.printf("%5.3f\n", meterToFoot(meters));
		}
	}
	
	// Convert from feet to meters
	public static double footToMeter(double foot) {
		return 0.305 * foot;
	}
	
    // Convert from meters to feet
	public static double meterToFoot(double meter) {
		return 3.279 * meter;
	}
}