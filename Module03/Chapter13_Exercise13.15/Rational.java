/*
Programmer: Colby Krenz
Date: 09/07/2023
Program Name: M03 Programming Assignment 2: Chapter 13: Assignment 13.15
Purpose: Redesign and implement the Raional class using BigInteger for the numerator and denominator.
Write a test program that prompts the user to enter two rational numbers and display the results.
*/

//import BigInteger from math
import java.math.BigInteger;

//implement the Rational class and extends Number which implements the Comparable method
class Rational extends Number implements Comparable<Rational> {
    //creates the data fields for the numerator and the denominator garnered from user input
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    //constructs an empty Rational
    public Rational() {
    }

    //constructs a Rational with the specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        //if else statement to make sure the denominator is larger than zero and it is not negative
        if (denominator.compareTo(BigInteger.ZERO) > 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        else if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
            this.numerator = numerator;
            this.denominator = denominator;
        }
        BigInteger gcd;
				
        //calculates the greatest common denominator (gcd) of the numerator and the denominator
        gcd = this.numerator.gcd(this.denominator);
        this.numerator = this.numerator.divide(gcd);
        this.denominator = this.denominator.divide(gcd);
    }
    
    //return value of the numerator
    public BigInteger getNumerator() {
        return numerator;
    }
    
    //return value of the denominator
    public BigInteger getDenominator() {
        return denominator;
    }
    
    //create method to add together the two rational numbers
    public Rational add(Rational secondRational) {
        BigInteger n1 = numerator.multiply(secondRational.getDenominator());
        BigInteger n2 = denominator.multiply(secondRational.getNumerator());
        BigInteger n = n1.add(n2);
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
   
    //create method to subtract the two rational numbers
    public Rational subtract(Rational secondRational) {
        BigInteger n1 = numerator.multiply(secondRational.getDenominator());
        BigInteger n2 = denominator.multiply(secondRational.getNumerator());
        BigInteger n = n1.subtract(n2);
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
   
    //create method to multiply the two rational numbers
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    
    //create method to divide the two rational numbers
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new Rational(n, d);
    }
    
    //overrides the toString class in GeometricObject
    //converts the user's input rational number to a String and returns it
    @Override
    public String toString() {
        return (this.numerator + " / " + this.denominator);
    }
    
    /*
    // Override the equals method in the Object class
    @Override
    public boolean equals(GeometricObject other) {
        if ((this.subtract((Rational)(other))).getNumerator() == 0)
            return true;
        else
            return false;
    }
    */
    
    //implements abstract intValue method in Number
    @Override
    public int intValue() {
        return (int) (numerator.doubleValue() / denominator.doubleValue());
    }
    
    //implements abstract floatValue method in Number
    @Override
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }
    
    //implements abstract doubleValue mehtod in Number
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }
    
    //implements abstract longValue method in Number
    @Override
    public long longValue() {
        return (long) (numerator.doubleValue() / denominator.doubleValue());
    }
    
    //impements compareTo method from Comparable
    @Override
    public int compareTo(Rational o) {
        return Double.compare(doubleValue(), o.doubleValue());
    }

}