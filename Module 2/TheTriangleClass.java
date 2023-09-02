/*
Programmer:	Colby Krenz
Date: 09/02/2023
Program Name: M02 Programming Assignment 2: Chapter 11: Assignment 11.1
Purpose: Design a class named Triangle that extends GeometricObject
Draw the UML diagrams for Triangle and GeometricObject and implement the classes
*/

import java.util.Scanner;

public class TheTriangleClass {
	//initialize the main method
	public static void main(String[] args) {
		//create scanner object
		Scanner userInput = new Scanner(System.in);
		
		//prompt the user to enter the 3 sides of the triangle and assign to variables
		System.out.println("Enter the three sides of the triangle: ");
		double side1 = userInput.nextDouble();
		double side2 = userInput.nextDouble();
		double side3 = userInput.nextDouble();
				
		//prompt the user to enter the color of the triangle and assign to a variable
		System.out.println("Enter the color of the triangle: ");
		String color = userInput.next();
		
		//prompt the user to select true or false which corresponds to whether the triangle is filled or not
		System.out.println("Is the triangle filled - Enter true or false:");
		boolean filled = userInput.nextBoolean();
		
		//create triangle object with these sides and set the color and filled properties using the input
		Triangle triangle = new Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		
		//display the triangle description, area, perimeter, color and true or false to indicate whether it's filled or not
		System.out.println(triangle.toString());
		System.out.println("\nTriangle Area \n" + triangle.getArea());
		System.out.println("\nTriangle Perimeter \n" + triangle.getPerimeter());
		System.out.println("\nTriangle Color \n" + triangle.getColor());
		System.out.println("\nThe Triangle Is Filled \n" + filled);
	}
}