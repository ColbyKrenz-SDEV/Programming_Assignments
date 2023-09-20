/*
Programmer:	Colby Krenz
Date: 09/20/2023
Program Name: M05 Programming Assignment 1: Chapter 14: Exercise 14.1
Purpose: Write a program that displays four images in a grid pane.
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DisplayImages extends Application {
	
	//override the start method in Application class
	@Override
	public void start(Stage primaryStage) {
		
		//create a GridPane that holds the images/nodes in a grid formation and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10.5);
		pane.setVgap(10.5);
		
		//put nodes in the pane
		pane.add(new ImageView(new Image("image/uk.gif", 160, 72, false, false)), 0, 0);
		pane.add(new ImageView(new Image("image/ca.gif", 160, 72, false, false)), 1, 0);
		pane.add(new ImageView(new Image("image/china.gif", 160, 72, false, false)), 0, 1);
		pane.add(new ImageView(new Image("image/us.gif", 160, 72, false, false)), 1, 1);
		
		//create the scene and put it in the stage
		Scene scene = new Scene(pane);
		//set the stage title and put the scene in the stage, then display the stage
		primaryStage.setTitle("Chapter  14.1: Display Images");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//call the main method
	public static void main(String[] args) {
		launch(args);
	}
}