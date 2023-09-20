/*
Programmer:	Colby Krenz
Date: 09/20/2023
Program Name: M05 Programming Assignment 2: Chapter 15: Exercise 15.7
Purpose: Write a program that displays the color of a circle as black when the mouse button is pressed,
and as white when the mouse button is released.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ChangeColorUsingMouse extends Application {
	
	//override start method in Application class
	@Override
	public void start(Stage primaryStage) {
		
		//create a StackPane (places nodes in center of pane)
		StackPane pane = new StackPane();

		/*create a circle with a set radius, outline it in black,
		fill it with white and add it to the pane*/
		Circle circle = new Circle();
		circle.setRadius(175);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		pane.getChildren().add(circle);
		
		//create event handler to fill circle with black when mouse is pressed
		pane.setOnMousePressed(e -> { 
			circle.setFill(Color.BLACK);
		});
		
		//create event handler to fill circle with white when mouse is released
		pane.setOnMouseReleased(e -> {
			circle.setFill(Color.WHITE);
		});

		//create a scene and put it in the stage
		Scene scene = new Scene(pane, 600, 600);
		//set stage title, put scene in stage, display stage
		primaryStage.setTitle("ChangeColorUsingMouse");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	//call the main method
	public static void main(String[] args) {
		launch(args);
	}
}