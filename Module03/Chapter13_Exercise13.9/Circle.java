/*
Programmer:	Colby Krenz
Date: 09/08/2023
Program Name: M03 Programming Assignment 1: Chapter 13: Assignment 13.9
Purpose: Rewrite the Circle class from Listing 13.2 to extend GeometricObject and implement the Comparable interface.
*/

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    //create an empty Circle object
    public Circle() {
    }

    //create a default Circle object
    public Circle(double radius) {
		this.radius = radius;
    }

    //return the radius of a Circle object
    public double getRadius() {
		return radius;
    }

    //set a new radius of a Circle object
    public void setRadius(double radius) {
		this.radius = radius;
    }

    @Override
    //return the area of a Circle object
    public double getArea() {
		return radius * radius * Math.PI;
    }

    //return the diameter of a Circle object
    public double getDiameter() {
		return 2 * radius;
    }

    @Override 
    //return the perimeter of a Circle object
    public double getPerimeter() {
		return 2 * radius * Math.PI;
    }

    //override the equals method in the Object class
    @Override 
    /*two objects are equal if the radii are the same 
    and the statement is true if they are equal*/
    public boolean equals(Object o) {
		return this.compareTo((Circle)o) == 0;
    }

    @Override 
    /*implement the compareTo method
    compare the 2 radii and if one is greater or less than the other
    then the equals method will be false, otherwise it is true*/
    public int compareTo(Circle o) {
		if (this.radius > o.radius)
			return 1;
		else if (this.radius < o.radius)
			return -1;
		else
			return 0;
	}

    @Override 
    //return a string representation of a Circle object
    public String toString() {
		return super.toString() + "\nDate created: " + getDateCreated() + "\nRadius: " + radius;
    }
    
}