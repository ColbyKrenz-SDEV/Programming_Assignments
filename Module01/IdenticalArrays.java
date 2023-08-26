/*
Programmer:	Colby Krenz
Date: 08/25/2023
Program Name: M01 Programming Assignment 3: Chapter 8: Assignment 8.29
Purpose: Prompt the user to enter two 3x3 arrays of integers and display if they are identical or not
*/

// Import the Scanner class to obtain user input
import java.util.Scanner;

public class IdenticalArrays {
	// Initialize main method
	public static void main(String[] args) {
		// Prompt user to enter two 3x3 arrays of integers
		System.out.print("Enter List 1: ");
		int[][] list1 = getArray();
		System.out.print("Enter List 2: ");
		int[][] list2 = getArray();
		
		// Display on the screen if the two lists are identical or not
		System.out.println("The two arrays are" + (equals(list1, list2) ? " " : " not ") + "identical.");
	}
	
	// Returns two-dimensional arrays that are 3x3
	public static int[][] getArray() {
		Scanner input = new Scanner(System.in);
		final int ROWS = 3;
		final int COLUMNS = 3;
		int[][] m = new int[ROWS][COLUMNS];
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}
	
	// Method that returns true if m1 and m2 are identical
	// Otherwise it returns false and they are not identical
	public static boolean equals(int[][] m1, int[][] m2) {
		int[] list1 = sort(m1);
		int[] list2 = sort(m2);
		for(int i = 0; i < list1.length; i++) {
			if(list1[i] != list2[i])
				return false;
		}
		return true;
	}
	
	// Assign the arrays to matrix variable and return the list
	public static int[] matrix(int[][] m) {
		int[] list = new int[m.length * m[0].length];
		int k = 0;
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				list[k] = m[i][j];
				k++;
			}
		}
		return list;
	}
	
	// Sort the array in ascending order
	public static int[] sort(int[][] m) {
		int[] list = matrix(m);
		for(int i = 0; i < 3; i++) {
			// Finds smallest number and swaps it with the first element
			// Then finds the smallest number and swaps it with the second element until list is sorted
			// Returns the list
			int min = list[i];
			int minIndex = i;
			for(int j = i + 1; j < 3; j++) {
				if(min > list[j]) {
					min = list[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				list[minIndex] = list[i];
				list[i] = min;
			}
		}
		return list;
	}
}