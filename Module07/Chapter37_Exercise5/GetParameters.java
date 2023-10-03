/*
Programmer: Colby Krenz
Date: 10/03/2023
Program Name: M07 Programming Assignment 1: Chapter 37: Exercise 37.5
Purpose: Write an HTML form that prompts user to enter loan amount, interest rate and number of years.
Create a servlet that is invoked by a submit button to compute monthly + total loan payments.
 */

package colby;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetParameters extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //get data from the form and assign to variables
        response.setContentType("text/html");
        PrintWriter out;
        out = response.getWriter();
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
                
        //caclulate the loan payments
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        //display the results of the loan calculation
        out.println("<html><head><title> Loan Payment</title></head><body>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Annual Interest Rate: " + annualInterestRate + "%</p>");
        out.println("<p>Number of Years: " + numberOfYears + "</p>");
        out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
        out.println("<p>Total Payment: $" + totalPayment + "</p");
        out.println("</body></html>");
        
        //close out form
        out.close();
    }
}
