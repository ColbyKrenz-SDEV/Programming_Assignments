package movieGoing;

/*
Programmer:	Colby Krenz
Date: 09/30/2023
Program Name: M06 Final Project: Update 4 - GUI(JavaFX)
Purpose: Write the Java code to complete the JavaFX GUI widgets.
Work on finalizing the events, have 2 completed.
*/

//import packages
import javafx.application.Application;
//import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MovieGoing extends Application {
	//create the stage
	Stage window = new Stage();
	
	//initialize main method
		public static void main(String[] args) {
			launch(args);
		}
	/*
	//create some variables
	private final SimpleStringProperty userFirstName;
	private final SimpleStringProperty userLastName;
	private final SimpleStringProperty userPhoneNum;
	private final SimpleStringProperty userEmail;
	
	//create a movie goer object
	public MovieGoing(String userFirstName, String userLastName, String userPhoneNum, String userEmail) {
		this.userFirstName = new SimpleStringProperty(userFirstName);
		this.userLastName = new SimpleStringProperty(userLastName);
		this.userPhoneNum = new SimpleStringProperty(userPhoneNum);
		this.userEmail = new SimpleStringProperty(userEmail);
	}
	
	//return and set the first name
		public String getUserFName() {
			return userFirstName.get();
		}
		public void setUserFName(String uFName) {
			userFirstName.set(uFName);
		}
		
		//return and set the last name
		public String getUserLName() {
			return userLastName.get();
		}
		public void setUserLName(String uLName) {
			userLastName.set(uLName);
		}
		
		//return and set the phone number
		public String getUserPhNum() {
			return userPhoneNum.get();
		}
		public void setUserPhNum(String uPhNum) {
			userPhoneNum.set(uPhNum);
		}
		
		//return and set the email
		public String getUserEmail() {
			return userEmail.get();
		}
		public void setUserEmail(String uEmail) {
			userEmail.set(uEmail);
		}
		*/
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
		
		userSubmitBtn.setOnAction(new EventHandler<ActionEvent>() {
			//override the handle method
			@Override
			public void handle(ActionEvent e) {
				userSubmitMsg.setTextFill(Color.BLUE);
				String userFirstName = userFNameTextField.getText();
				userSubmitMsg.setText("User input submitted, thank you " + userFirstName +"!");
			}
		});
				
		
		/*close button
		Button closeButton = new Button("Exit");
		userGridPane.add(closeButton, 0,  6);
		closeButton.setOnAction(e -> window.close());*/
				
		/*create and register the handler
		userSubmitBtn.setOnAction(new EventHandler<ActionEvent>() {
			//override the handle method
			@Override
			public void handle(ActionEvent e) {
				
			}
		});*/
				
				
		//create a scene and put it in the stage
		Scene scene = new Scene(userGridPane, 400, 400);
		//set stage title, put scene in stage, display stage
		primaryStage.setTitle("Cinema Seat Saver");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
			
}