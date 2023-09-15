/*
Programmer:	Colby Krenz
Date: 09/14/2023
Program Name: M04 Programming Assignment 2: Chapter 21: Exercise 21.3
Purpose: Revise the program in Listing 21.7
If a keyword is in a comment or a string, don't count it
*/

import java.util.*;
import java.io.*;

public class CountTheKeywords {
    //initialize the main method
    public static void main(String[] args) throws Exception {
		
        //displays the number of keywords in the file
        File file = null;
        if (0 < args.length) {
            file = new File(args[0]);
            System.out.println("The number of keywords in " + args[0] + " is " + countKeywords(file));

        } else {
            //if there isn't an argument return a warning message and exit the program
            System.err.println("There is no file.");
            System.exit(1);
        }

    }

    //create a method that will count the keywords
    public static int countKeywords(File file) throws Exception {
        //create an array to hold the keywords we are looking for
        String[] keywordString = {"abstract", "assert", "boolean", "break",
                "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto", "if",
                "implements", "import", "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "try",
                "void", "volatile", "while", "true", "false", "null"};

        //create a hash set to store keyword strings
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        //create a scanner to open the file
        Scanner input = new Scanner(file);
        //read each line of the file
        while (input.hasNextLine()) {
            String line = input.nextLine();
            //create a word variable and add characters to the word
            String word = "";
            int i = 0;
            //create a while loop that goes the length of the line
            while (i < line.length()) {
                //if there is a forward slash, stop checking that line
                if (line.charAt(i) == '/') {
                    break;
                }
                //if there is not a space, double quote or semi-colon, add to the word variable
                if (line.charAt(i) != ' ' && line.charAt(i) != '"' && line.charAt(i) != ';') {
                    word += line.charAt(i);
                }
                //if there's double quotes, add to i until subsequent double quote
                if (line.charAt(i) == '"') {
                    while (i < line.length() && line.charAt(i) != '"') {
                        i++;
                    }
                }
                //if the word is a valid keyword, increase the count
                if (line.charAt(i) == ' ' || i == line.length() - 1) {
                    if (keywordSet.contains(word)) {
                        count++;
                    }
                    word = "";
                }

                //add to the count
                i++;
            }
        }
        //return the number of keywords
        return count;

    }
}