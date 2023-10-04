/*
Programmer: Colby Krenz
Date: 10/03/2023
Program Name: M07 Programming Assignment 2: Chapter 38: Exercise 38.14
Purpose: Write a JSP program that generates addition quizzes.
After user answers all questions, JSP displays the results.
 */

package colby;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddQuiz extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get the user input from the form and store to variables
        response.setContentType("text/html");
        PrintWriter out;
        out = response.getWriter();
        int count = 0;
        int one = Integer.parseInt(request.getParameter("one").trim());
        int two = Integer.parseInt(request.getParameter("two").trim());
        int three = Integer.parseInt(request.getParameter("three").trim());
        int four = Integer.parseInt(request.getParameter("four").trim());
        int five = Integer.parseInt(request.getParameter("five").trim());
        int six = Integer.parseInt(request.getParameter("six").trim());
        int seven = Integer.parseInt(request.getParameter("seven").trim());
        int eight = Integer.parseInt(request.getParameter("eight").trim());
        int nine = Integer.parseInt(request.getParameter("nine").trim());
        int ten = Integer.parseInt(request.getParameter("ten").trim());
        
        //if statements to see if input matches correct answer
        if (23 + 10 == one) {
            count++;
        }
        if (29 + 5 == two) {
            count++;
        }
        if (20 + 16 == three) {
            count++;
        }
        if (25 + 3 == four) {
            count++;
        }
        if (28 + 9 == five) {
            count++;
        }
        if (29 + 10 == six) {
            count++;
        }
        if (23 + 7 == seven) {
            count++;
        }
        if (25 + 8 == eight) {
            count++;
        }
        if (24 + 5 == nine) {
            count++;
        }
        if (21 + 6 == ten) {
            count++;
        }

        //display the results on the screen along with the total amount correct
        out.println("<html><body>");
        out.println("<p>23 + 10 = " + one + " " + (23 + 10 == one ? "Correct" : "Wrong") + "</p>");
        out.println("<p>29 + 5 = " + two + " " + (29 + 5 == two ? "Correct" : "Wrong") + "</p>");
        out.println("<p>20 + 16 = " + three + " " + (20 + 16 == three ? "Correct" : "Wrong") + "</p>");
        out.println("<p>25 + 3 = " + four + " " + (25 + 3 == four ? "Correct" : "Wrong") + "</p>");
        out.println("<p>28 + 9 = " + five + " " + (28 + 9 == five ? "Correct" : "Wrong") + "</p>");
        out.println("<p>29 + 10 = " + six + " " + (29 + 10 == six ? "Correct" : "Wrong") + "</p>");
        out.println("<p>23 + 8 = " + seven + " " + (23 + 7 == seven ? "Correct" : "Wrong") + "</p>");
        out.println("<p>25 + 8 = " + eight + " " + (25 + 8 == eight ? "Correct" : "Wrong") + "</p>");
        out.println("<p>24 + 5 = " + nine + " " + (24 + 5 == nine ? "Correct" : "Wrong") + "</p>");
        out.println("<p>21 + 6 = " + ten + " " + (21 + 6 == ten ? "Correct" : "Wrong") + "</p>");
        out.println("<p>The total correct count is: " + count + "</p>");
        out.println("</body></html>");

        //close the form
        out.close();
    }
}