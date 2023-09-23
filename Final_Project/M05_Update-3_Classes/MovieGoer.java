/*
Programmer:	Colby Krenz
Date: 09/23/2023
Program Name: M05 Final Project: Update 3 - Classes/Test Classes
Purpose: Write the Java code for the classes that are required for the application.
Write out test classes to test functionality. Cinema Seat Saver
*/

import javafx.application.Application;
//import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MovieGoer extends Application {
	//protected Text text = new Text("Welcome");
	//protected Slider/pane/label variableName = new Slider/pane/label
	
	//override start method in the Application class		
	@Override 
	public void start(Stage primaryStage) {
		
		//create GridPane to lay out controls
		GridPane userGridPane = new GridPane();
		userGridPane.setAlignment(Pos.CENTER);
		userGridPane.setHgap(10);
		userGridPane.setVgap(10);
		userGridPane.setPadding(new Insets(25, 25, 25, 25));
		
		//add text, labels and text fields to the panes
		Text sceneTitle = new Text("Please Enter User Information:");
		sceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		userGridPane.add(sceneTitle, 0, 0, 2, 1);
		
		//user first name
		Label userFirstName = new Label("First Name:");
		userGridPane.add(userFirstName, 0, 1);
		TextField userFNameTextField = new TextField();
		userGridPane.add(userFNameTextField, 1, 1);
		
		//user last name
		Label userLastName = new Label("Last Name:");
		userGridPane.add(userLastName, 0, 2);
		TextField userLNameTextField = new TextField();
		userGridPane.add(userLNameTextField, 1, 2);
		
		//user phone number
		Label userPhoneNum = new Label("Phone Number:");
		userGridPane.add(userPhoneNum, 0, 3);
		TextField userPhoneTextField = new TextField();
		userGridPane.add(userPhoneTextField, 1, 3);
		
		//user email
		Label userEmail = new Label("Email:");
		userGridPane.add(userEmail, 0, 4);
		TextField userEmailTextField = new TextField();
		userGridPane.add(userEmailTextField, 1, 4);
		
		//submit button
		Button userSubmitBtn = new Button("Submit");
		userGridPane.add(userSubmitBtn, 0, 5);
		Label userSubmitMsg = new Label("");
		userGridPane.add(userSubmitMsg, 1, 5);
				
		//create and register the handler
		userSubmitBtn.setOnAction(new EventHandler<ActionEvent>() {
			//override the handle method
			@Override
			public void handle(ActionEvent e) {
				userSubmitMsg.setTextFill(Color.BLUE);
				String userFirstName = userFNameTextField.getText();
				userSubmitMsg.setText("User input submitted, thank you " + userFirstName +"!");
			}
		});
				
				
		//create a scene and put it in the stage
		Scene scene = new Scene(userGridPane, 400, 400);
		//set stage title, put scene in stage, display stage
		primaryStage.setTitle("Cinema Seat Saver");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
			
}