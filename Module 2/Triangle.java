/*
Programmer:	Colby Krenz
Date: 09/02/2023
Program Name: M02 Programming Assignment 2: Chapter 11: Assignment 11.1
Purpose: Design a class named Triangle that extends GeometricObject
Draw the UML diagrams for Triangle and GeometricObject and implement the classes
*/

//implement triangle class
public class Triangle extends GeometricObject {
	//create 3 double data fields, 1 for each side of the triangle
	//instansiates with default value of 1.0
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	//no-arg constructor that creates a default triangle 
	protected Triangle() {
	}
	
	//constructor that creates a triangle with specified side1, side2, and side3
	Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//create accessor methods to return side 1, 2 and 3
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	
	//create a method that will return the area of this triangle
	public double getArea() {
		double allSides = (side1 + side2 + side3) / 2;
		double triangleArea = Math.sqrt(allSides * (allSides - side1) * (allSides - side2) * (allSides - side3));
		return triangleArea;
	}
	
	//create a method that will return the perimeter of this triangle
	public double getPerimeter() {
		double trianglePerimeter = side1 + side2 + side3;
		return trianglePerimeter;
	}
	
	//create a method that will return a string description for this triangle
	public String toString() {
		return "\nTriangle Sides: \nside1 = " + side1 + "  |  side2 = " + side2 + "  |  side3 = " + side3;
	}
}