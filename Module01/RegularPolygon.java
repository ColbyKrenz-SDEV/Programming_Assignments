/*
Programmer:	Colby Krenz
Date: 08/26/2023
Program Name: M01 Programming Assignment 4: Chapter 9: Assignment 9.9
Purpose: Create public class RegularPolygon to be used in NSidedRegularPolygon program
*/

public class RegularPolygon {
	// Create an int data field that defines number of sides
	// Create a double data field that stores length of the side
	// Create a double data field that defines x-coordinate of polygon's center
	// Create a double data field that defines y-coordinate of polygon's center 
	private int n;
	private double side;
	private double x;
	private double y;
	
	// Create regular polygon with default values
	RegularPolygon() {
		// Set n with default value 3
		// Set side with default value 1
		// Set x and y with default value 0
		n = 3;
		side = 1;
		x = y = 0;
	}
	// Create a RegularPolygon object with specified number of sides and length of side, centered at (0, 0)
	RegularPolygon(int newN, double newSide) {
		n = newN;
		side = newSide;
		x = y = 0;
	}
	
	// Create a RegularPolygon with specified number of sides, length of side, and x and y coordinates
	RegularPolygon(int newN, double newSide, double newX, double newY) {
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	}
	
	// Sets new n and returns n
	public void setN(int newN) {
		n = newN;
	}
	public int getN() {
		return n;
	}
	
	// Sets new side and returns side
	public void setSide(double newSide) {
		side = newSide;
	}
	public double getSide() {
		return side;
	}
	
	// Sets new x coordinate and returns x coordinate
	public void setX(double newX) {
		x = newX;
	}
	public double getX() {
		return x;
	}
	
	// Sets new y coordinate and returns y coordinate
	public void setY(double newY) {
		y = newY;
	}	
	public double getY() {
		return y;
	}
	
	// Returns the perimeter of the polygon
	public double getPerimeter() {
		return side * n;
	}
	
	// Returns the area of the polygon with the formula for computing the area of a regualr polygon
	public double getArea() {
		return(n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
	}
}
