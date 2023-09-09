/*
Programmer:	Colby Krenz
Date: 09/08/2023
Program Name: M03 Programming Assignment 1: Chapter 13: Assignment 13.9
Purpose: Rewrite the Circle class from Listing 13.2 to extend GeometricObject and implement the Comparable interface.
*/

public class EnableCircleComparable {

    //initiate the main method
    public static void main(String[] args) {
	//create four Circle objects
	Circle circleA = new Circle(7);
	Circle circleB = new Circle(3);
	Circle circleC = new Circle(7);
    Circle circleD = new Circle(6);

	//display each Circle object and its corresponding radius
	System.out.println("Circle A has a radius of: " + circleA.getRadius());
	System.out.println("Circle B has a radius of: " + circleB.getRadius());
	System.out.println("Circle C has a radius of: " + circleC.getRadius());
    System.out.println("Circle D has a radius of: " + circleD.getRadius());

    //compare Circle A with Circle C and display the results
	System.out.println("\nCircle A is " + (circleA.equals(circleC) ? "" : "not ") + "equal to Circle C");
    //compare Circle B with Circle D and display the results
	System.out.println("Circle B is " + (circleB.equals(circleD) ? "" : "not ") + "equal to Circle D");
        
    //compare various combinations of Circles and display the results
	System.out.println("\nCircle A and B are: " + (circleA.equals(circleB) ? "" : "Not ") + "Equal");
    System.out.println("Circle A and C are: " + (circleA.equals(circleC) ? "" : "Not ") + "Equal");
    System.out.println("Circle A and D are: " + (circleA.equals(circleD) ? "" : "Not ") + "Equal");
    System.out.println("Circle B and C are: " + (circleB.equals(circleC) ? "" : "Not ") + "Equal");
    System.out.println("Circle B and D are: " + (circleB.equals(circleD) ? "" : "Not ") + "Equal");
    System.out.println("Circle C and D are: " + (circleC.equals(circleD) ? "" : "Not ") + "Equal");
    }

}