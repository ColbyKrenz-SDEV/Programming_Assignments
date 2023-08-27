/*
Programmer:	Colby Krenz
Date: 08/25/2023
Program Name: M01 Programming Assignment 4: Chapter 9: Assignment 9.9
Purpose: Create 3 RegularPolygon objects, created using the no-arg constructor, using RegularPolygon(6, 4),
		 and using RegularPolygon(10, 4, 5.6, 7.8). For each object, display its perimeter and area.
*/

public class NSidedRegularPolygon {
	// Initialize the main method
	public static void main(String[] args) {
		// Create 3 RegularPolygon objects
		RegularPolygon regularPolygon1 = new RegularPolygon();
		RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
		RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
		
		//Display perimeter and area of each RegularPolygon object
		System.out.println("Regular Polygon Objects  |  Perimeter  |  Area");
		System.out.println("----------------------------------------------------------");
		System.out.printf("RegularPolygon# 1         |%5.1f            |%4.1f \n", regularPolygon1.getPerimeter(), regularPolygon1.getArea());
		System.out.printf("RegularPolygon# 2         |%5.1f           |%5.1f \n", regularPolygon2.getPerimeter(), regularPolygon2.getArea());
		System.out.printf("RegularPolygon# 3         |%5.1f           |%5.1f \n", regularPolygon3.getPerimeter(), regularPolygon3.getArea());
	}
}