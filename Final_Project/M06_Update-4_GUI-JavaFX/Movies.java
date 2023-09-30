package movieGoing;

/*
Programmer:	Colby Krenz
Date: 09/30/2023
Program Name: M06 Final Project: Update 4 - GUI(JavaFX)
Purpose: Write the Java code to complete the JavaFX GUI widgets.
Work on finalizing the events, have 2 completed.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Movies extends Application {
	//create variables
	final VBox labelVB = new VBox();
	final VBox mNameVB = new VBox();
	final VBox mDayVB = new VBox();
	final VBox mTimeVB = new VBox();
	final HBox mLayout = new HBox();
	final VBox vBox = new VBox();
	final VBox btnBox = new VBox();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//create a scene with size parameters and set the title
		Scene scene = new Scene(new Group());
		primaryStage.setTitle("Movies Selection");
		primaryStage.setHeight(550);
		primaryStage.setWidth(650);
				
		//create radio button objects for movie names
		ToggleGroup movieName = new ToggleGroup();
		RadioButton optBarbie = new RadioButton("Barbie");
		RadioButton optExpen = new RadioButton("Expend4bles");
		RadioButton optNun = new RadioButton("The Nun II");
		RadioButton optSaw = new RadioButton("Saw X");
		optBarbie.setToggleGroup(movieName);
		optExpen.setToggleGroup(movieName);
		optNun.setToggleGroup(movieName);
		optSaw.setToggleGroup(movieName);
		
		//create radio button objects for days
		ToggleGroup movieDay = new ToggleGroup();
		RadioButton optWed = new RadioButton("Wednesday");
		RadioButton optTh = new RadioButton("Thursday");
		RadioButton optFri = new RadioButton("Friday");
		RadioButton optSat = new RadioButton("Saturday");
		optWed.setToggleGroup(movieDay);
		optTh.setToggleGroup(movieDay);
		optFri.setToggleGroup(movieDay);
		optSat.setToggleGroup(movieDay);
		
		//create radio button objects for times
		ToggleGroup movieTime = new ToggleGroup();
		RadioButton optTen = new RadioButton("10:00 am");
		RadioButton optOne = new RadioButton("1:00 pm");
		RadioButton optFive = new RadioButton("5:00 pm");
		RadioButton optEight = new RadioButton("8:00 pm");
		optTen.setToggleGroup(movieTime);
		optOne.setToggleGroup(movieTime);
		optFive.setToggleGroup(movieTime);
		optEight.setToggleGroup(movieTime);
		
		//add instructions for the user
		final Label label = new Label("Make your selections below.");
		labelVB.setSpacing(10);
		labelVB.setPadding(new Insets(20, 20, 20, 20));
		labelVB.getChildren().add(label);
				
		//create layout for movie options and add radio butttons
		mNameVB.setSpacing(10);
		mNameVB.setPadding(new Insets(20, 20, 20, 20));
		mNameVB.getChildren().addAll(optBarbie, optExpen,optNun, optSaw);
		
		//create layout for day options and add radio buttons
		mDayVB.setSpacing(10);
		mDayVB.setPadding(new Insets(20, 20, 20, 20));
		mDayVB.getChildren().addAll(optWed, optTh, optFri, optSat);
		
		//create layout for day options and add radio buttons
		mTimeVB.setSpacing(10);
		mTimeVB.setPadding(new Insets(20, 20, 20, 20));
		mTimeVB.getChildren().addAll(optTen, optOne, optFive, optEight);
				
		//create layout for all radio button groups and add to layout
		vBox.getChildren().addAll(mNameVB, mDayVB, mTimeVB);
		vBox.setSpacing(5);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		
		//submit button
		Button userSubmitBtn = new Button("Submit");
		btnBox.getChildren().add(userSubmitBtn);
		btnBox.setSpacing(5);
		btnBox.setPadding(new Insets(20, 20, 20, 20));
						
		userSubmitBtn.setOnAction(e -> {
			System.out.println("Event Handler Action");
			//event handler to take user's selection and display it 
					});
		
		//create layout
		mLayout.getChildren().addAll(labelVB, vBox, btnBox);
		mLayout.setSpacing(5);
		mLayout.setPadding(new Insets(20, 20, 20, 20));
		((Group) scene.getRoot()).getChildren().addAll(mLayout);
		
		//put scene in stage and display stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
