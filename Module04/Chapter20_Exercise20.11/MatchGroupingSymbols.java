/*
Programmer:	Colby Krenz
Date: 09/13/2023
Program Name: M04 Programming Assignment 1: Chapter 20: Exercise 20.11
Purpose: Write a program to check whether a Java source-code file has correct pairs of grouping symbols.
Pass the source-code file name as a command line argument
*/

import java.io.*;
import java.util.*;

public class MatchGroupingSymbols {

    //initialize main method
    public static void main(String[] args) throws IOException {
		
		//check if an argument is passed
		if(args.length != 1) {
			System.exit(0);
		}
        
        //check to see if the file exists - if not, throw a warning and exit the program
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println(args[0] + " is not a file.");
            System.exit(0);
        }
        
        //create a stack to store the symbols
        Stack<Character> groupingSymbols = new Stack<>();
        
        //create a try-with-resource to open the file
        try(Scanner input = new Scanner(file);) {
                
            //read the characters from the input
            while(input.hasNext()) {
                String line = input.nextLine();
                for(int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    //add elements to the top of the stack
                    if(ch == '(' || ch == '{' || ch == '[') {
                        groupingSymbols.push(ch);
                    }
                    //process the stack
                    else if(ch == ')' || ch == '}' || ch == ']') {
                        processGroupingSymbols(groupingSymbols, ch);
                    }
                }
            }
        }
        
        //print if the pairs of grouping symbols are correct
        System.out.println("The Java source-code file has correct pairs of grouping symbols.");
    }
    
    //create a method that will match grouping symbols
    private static void processGroupingSymbols(Stack<Character> stack, Character ch) {
        //if the symbols match, remove them from the stack
        if((stack.peek() == '{' && ch == '}') || (stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']')) {
            stack.pop();
        }
        //if the symbols don't match, throw a warning and exit the program
        else if((stack.peek() != '{' && ch == '}') || (stack.peek() != '(' && ch == ')') || (stack.peek() != '[' && ch == ']')) {
            System.out.println("The Java source-code file does not have correct pairs of grouping symbols.");
            System.exit(1);
        }
    }
}