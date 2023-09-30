/*
Programmer:	Colby Krenz
Date: 09/30/2023
Program Name: M06 Programming Assignment 2: Chapter 35: Exercise 34.1
Purpose: Write a program that inserts a thousand records into a database and compare with and without batch updates.
*/

package batch;

//import packages
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.scene.layout.BorderPane;
import java.sql.DriverManager;

public class BatchUpdate extends BorderPane{
	
	//call jdbc driver name and database url and provide login info
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/batchUpdate";
	static final String USER = "root";
	static final String PASS = "P455w0rd@$3";
	
	//call main method
	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		double num1, num2, num3;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//open a connection to sql database and create sql statement
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "insert into Temp (num1, num2, num3) values (?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			final int batchSize = 1000;
			System.out.println("Inserting numbers...");
			
			//calculate time before executing the statement
			long startTime = System.nanoTime();
			for (int i = 0; i < batchSize; i++) {
				
				//generate random numbers
				num1 = Math.random();
				num2 = Math.random();
				num3 = Math.random();
				
				//set randomly generated numbers into statement for execution
				pstmt.setDouble(1, num1);
				pstmt.setDouble(2, num2);
				pstmt.setDouble(3, num3);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			
			//insert records that remain
			long estimatedTime = System.nanoTime() - startTime;

			System.out.println("Batch update completed");
			System.out.println("The elapsed time is " + estimatedTime);
			System.out.println("Started inserting numbers using Non-Batch update");
			
			//calculate time before executing statements
			long start = System.nanoTime();
			for (int index = 1; index < batchSize; index++) {
				
				//generate random numbers
				num1 = Math.random();
				num2 = Math.random();
				num3 = Math.random();
				
				//set random numbers into statement for execution
				pstmt.setDouble(1, num1);
				pstmt.setDouble(2, num2);
				pstmt.setDouble(3, num3);
				pstmt.executeUpdate();
			}
			long end = System.nanoTime();
			
			System.out.println("Non-Batch update completed");
			System.out.println("The elapsed time is " + (end - start));

			//close connection and prepared statement
			pstmt.close();
			connection.close();
		}
		//catch and throw errors
		catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		
		System.out.println("Insertions are complete!");
	}
}