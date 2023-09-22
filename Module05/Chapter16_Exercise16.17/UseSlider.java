/*
Programmer:	Colby Krenz
Date: 09/21/2023
Program Name: M05 Programming Assignment 3: Chapter 16: Exercise 16.17
Purpose: Write a program that uses scrollbars or sliders to select the color for a text.
Four horizontal scroll bars are used for selecting the colors: red, green, blue, opacity percentage.
*/

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class UseSlider extends Application {
	protected Text text = new Text("SHOW COLORS");
	protected Slider slColorRed = new Slider();
	protected Slider slColorGreen = new Slider();
	protected Slider slColorBlue = new Slider();
	protected Slider slOpacity = new Slider();
	
	@SuppressWarnings("unchecked")
	//override start method in the Application class		
	@Override 
	public void start(Stage primaryStage) {
		
		//create stack pane and place the color changing text
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 20, 20, 20));
		text.setFont(Font.font("verdana", FontWeight.BOLD, 30));
		paneForText.setAlignment(Pos.CENTER);

		//set properties for the color sliders
		slColorRed.setMin(0.0);
		slColorRed.setMax(1.0);
		slColorGreen.setMin(0.0);
		slColorGreen.setMax(1.0);
		slColorBlue.setMin(0.0);
		slColorBlue.setMax(1.0);
		slOpacity.setMin(0.0);
		slOpacity.setMax(1.0);

		//register the listeners to call setColor method for the value of the sliders
		slColorRed.valueProperty().addListener(ov -> setColor());
		slColorGreen.valueProperty().addListener(ov -> setColor());
		slColorBlue.valueProperty().addListener(ov -> setColor());
		slOpacity.valueProperty().addListener(ov -> setColor());
		slOpacity.setValue(1);


		//initialize the GridPane
		GridPane paneForSliders = new GridPane();
		//put nodes/sliders in panes and align them within the grid
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setVgap(25);
		paneForSliders.setHgap(25);
		paneForSliders.add(new Label("Red"), 0, 0);
		paneForSliders.add(slColorRed, 1, 0);
		paneForSliders.add(new Label("Green"), 0, 1);
		paneForSliders.add(slColorGreen, 1, 1);
		paneForSliders.add(new Label("Blue"), 0, 2);
		paneForSliders.add(slColorBlue, 1, 2);
		paneForSliders.add(new Label("Opacity"), 0, 3);
		paneForSliders.add(slOpacity, 1, 3);

		//initialize the VBox
		VBox vBox = new VBox();
		//set space and alignment between nodes in pane
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		//retrieve observable list of VBox
		ObservableList list = vBox.getChildren();
		//add nodes to observable list
		list.addAll(paneForText, paneForSliders);

		//create a scene and put it in the stage
		Scene scene = new Scene(vBox, 500, 300);
		//set stage title, put scene in stage, display stage
		primaryStage.setTitle("UseSlider");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//create setColor method to change text color
	private void setColor() {
		text.setFill(new Color(slColorRed.getValue(), slColorGreen.getValue(), slColorBlue.getValue(), slOpacity.getValue()));
	}
	
	//call main method
	public static void main(String[] args) {
		launch(args);
	}
}