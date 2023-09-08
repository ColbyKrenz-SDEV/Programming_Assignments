/*
Programmer:	Colby Krenz
Date: 09/07/2023
Program Name: M03 Programming Assignment 2: Chapter 13: Assignment 13.15
Purpose: Redesign and implement the Raional class using BigInteger for the numerator and denominator.
Write a test program that prompts the user to enter two rational numbers and display results.
*/

import java.math.*;
import java.util.Scanner;

public class BigIntegerForRational {
    public static void main(String[] args) {
// Prompt the user to enter two Rational numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first rational number: ");
        String n1 = input.next();
        String d1 = input.next();

        System.out.print("Enter the second rational number: ");
        String n2 = input.next();
        String d2 = input.next();

        Rational r1 = new Rational(new BigInteger(n1), new BigInteger(d1));
        Rational r2 = new Rational(new BigInteger(n2), new BigInteger(d2));

// Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}