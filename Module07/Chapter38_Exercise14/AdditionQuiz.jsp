<%-- 
Programmer: Colby Krenz
Date: 10/03/2023
Program Name: M07 Programming Assignment 2: Chapter 38: Exercise 38.14
Purpose: Write a JSP program that generates addition quizzes.
After user answers all questions, JSP displays the results.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addition Quiz</title>
    </head>
    
    <body>
        
        <%-- text fields for user input --%>
        <form action="./AddQuiz">
            <p>23 + 10 = <input type="text" name="one" size=2/></p>
            <p>29 + 5 = <input type="text" name="two" size=2/></p>
            <p>20 + 16 = <input type="text" name="three" size=2/></p>
            <p>25 + 3 = <input type="text" name="four" size=2/></p>
            <p>28 + 9 = <input type="text" name="five" size=2/></p>
            <p>29 + 10 = <input type="text" name="six" size=2/></p>
            <p>23 + 7 = <input type="text" name="seven" size=2/></p>
            <p>25 + 8 = <input type="text" name="eight" size=2/></p>
            <p>24 + 5 = <input type="text" name="nine" size=2/></p>
            <p>21 + 6 = <input type="text" name="ten" size=2/></p>
            
            <%--create submit button--%>
            <input type="submit" value="Submit"/>
        </form>
            
    </body>
    
</html>
