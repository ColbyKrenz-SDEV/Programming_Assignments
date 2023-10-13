package application;

/*
Programmer:	Colby Krenz
Date: 10/12/2023
Program Name: M08 Final Project Submission: Cinema Seat Saver: MovieGoerForm Class
Purpose: Create an form to gather user information to create an account.
*/

import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MovieGoerForm extends Application {
	
	Label userFirstName,userLastName,userPhoneNum,userEmail,userSubmitMsg,userIDMsg;
	TextField userFNameTF,userLNameTF,userPhoneTF,userEmailTF;
	Button userSubmitBtn,clearBtn,selectMovieBtn;
	String userFName,userLName,useID;
	
	public MovieGoerForm() {
	}
	
	public MovieGoerForm(String userFName, String userLName, String useID) {
		this.userFName = userFName;
		this.userLName = userLName;
		this.useID = useID;
	}
	
	//override start method in the Application class		
	@Override 
	public void start(Stage primaryStage) {
		
		//movie clapperboard icon found @ https://icons8.com/icon/LyrkX9tAKqNr/clapperboard
		//icon by Icons8 @ https://icons8.com
		Image clapperboard = new Image("icons8-movie-48.png");
		primaryStage.getIcons().add(clapperboard);
				
		//create GridPane to lay out controls
		GridPane userGridPane = new GridPane();
		userGridPane.setAlignment(Pos.CENTER);
		userGridPane.setHgap(15);
		userGridPane.setVgap(15);
		userGridPane.setPadding(new Insets(25, 25, 25, 25));
		userGridPane.setStyle("-fx-background-color: #bbc0c8");
			
		//add text, labels and text fields to the panes
		Text sceneTitle = new Text("Please Enter User Information:");
		sceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		userGridPane.add(sceneTitle, 0, 0, 2, 1);
			
		//user first name emptyLbl2 and text field
		userFirstName = new Label("First Name:");
		userGridPane.add(userFirstName, 0, 1);
		userFNameTF = new TextField();
		userGridPane.add(userFNameTF, 1, 1);
			
		//user last name emptyLbl2 and text field
		userLastName = new Label("Last Name:");
		userGridPane.add(userLastName, 0, 2);
		userLNameTF = new TextField();
		userGridPane.add(userLNameTF, 1, 2);
			
		//user phone number emptyLbl2 and text field
		userPhoneNum = new Label("Phone Number:");
		userGridPane.add(userPhoneNum, 0, 3);
		userPhoneTF = new TextField();
		userGridPane.add(userPhoneTF, 1, 3);
			
		//user email emptyLbl2 and text field
		userEmail = new Label("Email:");
		userGridPane.add(userEmail, 0, 4);
		userEmailTF = new TextField();
		userGridPane.add(userEmailTF, 1, 4);
			
		//submit button
		userSubmitBtn = new Button("Submit");
		userGridPane.add(userSubmitBtn, 0, 5);
		userSubmitBtn.setStyle("-fx-background-color: #5f5b6c");
		userSubmitBtn.setTextFill(Color.WHITE);
		userSubmitBtn.setFont(new Font("Helvetica",16));
		userSubmitBtn.setPadding(new Insets(10,10,10,10));
		
		//create empty labels that will hold messages once submit button is clicked
		userSubmitMsg = new Label("");
		userGridPane.add(userSubmitMsg, 0, 6, 2, 1);
		userIDMsg = new Label("");
		userGridPane.add(userIDMsg, 0, 7, 2, 1);
				
		//disable the submit button if user hasn't filled all text fields
		userSubmitBtn.disableProperty().bind(userFNameTF.textProperty().isEmpty().or(userLNameTF.textProperty().isEmpty()).or(userEmailTF.textProperty().isEmpty()).or(userPhoneTF.textProperty().isEmpty()));
		
		//create and register the handler
		userSubmitBtn.setOnAction(new EventHandler<ActionEvent>() {
			//override the handle method
			@Override
			public void handle(ActionEvent e) {
				//set the emptyLbl2 colors to blue and get the text from user input
				userSubmitMsg.setTextFill(Color.BLUE);
				userIDMsg.setTextFill(Color.BLUE);
				userFName = userFNameTF.getText();
				userLName = userLNameTF.getText();
				//create a random number for the user id
				Random randomNum = new Random();
				int uID = randomNum.nextInt(10000);
				useID = Integer.toString(uID);
				//display the submit and user id message
				userSubmitMsg.setText("User input submitted, thank you " + userFName +"!");
				userIDMsg.setText("Your User ID: " + userFName + userLName + useID);
				
				selectMovieBtn.setVisible(true);
			}
		});
		
		//create a button to clear the user input
		clearBtn = new Button("Clear");
		userGridPane.add(clearBtn, 1, 5);
		clearBtn.setStyle("-fx-background-color: #5f5b6c");
		clearBtn.setTextFill(Color.WHITE);
		clearBtn.setFont(new Font("Helvetica",16));
		clearBtn.setPadding(new Insets(10,10,10,10));
		//create and register the handler
		clearBtn.setOnAction(new EventHandler<ActionEvent>() {
			//override handle method
			@Override
			public void handle(ActionEvent e) {
				userFNameTF.setText("");
				userLNameTF.setText("");
				userPhoneTF.setText("");
				userEmailTF.setText("");
				userSubmitMsg.setText("");
				userIDMsg.setText("");
				selectMovieBtn.setVisible(false);
			}
		});
		
		//create an invisible button that will eventually open the movie selection window
		selectMovieBtn = new Button("Select a Movie");
		selectMovieBtn.setVisible(false);
		userGridPane.add(selectMovieBtn, 1, 9);
		//create the seat selection button,style it and event handler
		selectMovieBtn.setStyle("-fx-background-color: #5f5b6c");
		selectMovieBtn.setTextFill(Color.WHITE);
		selectMovieBtn.setFont(new Font("Helvetica",16));
		selectMovieBtn.setPadding(new Insets(10,10,10,10));
											
		//create a scene and put it in the stage
		Scene scene = new Scene(userGridPane, 400, 400);
		//set stage title, put scene in stage, display stage
		primaryStage.setTitle("Cinema Seat Saver");
		primaryStage.setScene(scene);
		primaryStage.show();
		//set size of the window upon initialization and make it so it can't be resized
		primaryStage.setWidth(450);
		primaryStage.setHeight(500);
		primaryStage.setResizable(false);
	}
	
	//create getters and setters
	public String getUserFName() {
		return userFName;
	}
		
	public void setUserFName(String userFName) {
		if(!userFName.isEmpty()) {
			this.userFName = userFName;
		}
	}
		
	public String getuserLName() {
		return userLName;
	}
		
	public void setUserLN(String userLName) {
		if(!userLName.isEmpty()) {
			this.userLName = userLName;
		}
	}
		
	public String getFullName() {
		return userFName + " " + userLName;
	}
		
	public String getUserID() {
		return useID;
	}
		
	public String setUserID(String useID) {
		return userFName + userLName + useID;
	}
	
	//main method
    public static void main(String[] args) {
        launch(args);
    }
}
