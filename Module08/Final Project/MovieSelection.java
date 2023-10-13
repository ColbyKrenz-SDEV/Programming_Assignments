package application;

/*
Programmer:	Colby Krenz
Date: 10/12/2023
Program Name: M08 Final Project Submission: Cinema Seat Saver: MovieSelection Class
Purpose: Allow a user to select a movie, day and time from the given choices.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class MovieSelection extends Application {
	
	Image clapperboard;
	Button confirmBtn,seatSelectBtn;
	Label nameLbl,dayLbl,timeLbl,confirmLbl,selectionChoiceLbl,selectionLblN,selectionLblD,selectionLblT,nameSelected,daySelected,timeSelected;
	ToggleGroup movieName,movieDay,movieTime;
	RadioButton optBarbie,optExpen,optNun,optSaw,optWed,optTh,optFri,optSat,optTen,optOne,optFive,optEight,mName,mDay,mTime;
	VBox mNameVB, mDayVB,mTimeVB,selectLblsVB,selectLblVB,inputLblVB,selectLayout;
	HBox radioGroupsHB,inputHB,buttonHB;
	public String movieNameSelect,movieDaySelect,movieTimeSelect,mNSet,mDSet,mTSet;
			
	
	public MovieSelection() {
    }
    
    public MovieSelection(String movieNameSelect, String movieDaySelect, String movieTimeSelect) {
		this.mNSet = movieNameSelect;
		this.mDSet = movieDaySelect;
		this.mTSet = movieTimeSelect;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
				
		//movie clapperboard icon found @ https://icons8.com/icon/LyrkX9tAKqNr/clapperboard
		//icon by Icons8 @ https://icons8.com
		clapperboard = new Image("icons8-movie-48.png");
		primaryStage.getIcons().add(clapperboard);
		
		//set size of the window upon initialization and make it so it can't be resized
		primaryStage.setWidth(550);
		primaryStage.setHeight(675);
		primaryStage.setResizable(false);
	    
	    //create emptyLbl2 and radio button objects for movie names
		nameLbl = new Label("MOVIES:");
		nameLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		
		//nameLbl.setUnderline(true);
	    movieName = new ToggleGroup();
		optBarbie = new RadioButton("Barbie");
		optExpen = new RadioButton("Expend4bles");
		optNun = new RadioButton("The Nun II");
		optSaw = new RadioButton("Saw X");
		optBarbie.setToggleGroup(movieName);
		optExpen.setToggleGroup(movieName);
		optNun.setToggleGroup(movieName);
		optSaw.setToggleGroup(movieName);
		
		//create layout for movie options and add emptyLbl2 and radio buttons
		mNameVB = new VBox();
		mNameVB.setAlignment(Pos.CENTER_LEFT);
		mNameVB.setSpacing(10);
		mNameVB.setPadding(new Insets(20, 20, 20, 20));
		mNameVB.getChildren().addAll(nameLbl, optBarbie, optExpen,optNun, optSaw);
				
		//create emptyLbl2 and radio button objects for days
		dayLbl = new Label("DAYS:");
		dayLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		//dayLbl.setUnderline(true);
		movieDay = new ToggleGroup();
		optWed = new RadioButton("Wednesday");
		optTh = new RadioButton("Thursday");
		optFri = new RadioButton("Friday");
		optSat = new RadioButton("Saturday");
		optWed.setToggleGroup(movieDay);
		optTh.setToggleGroup(movieDay);
		optFri.setToggleGroup(movieDay);
		optSat.setToggleGroup(movieDay);		
		
		//create layout for day options and add emptyLbl2 and radio buttons
		mDayVB = new VBox();
		mDayVB.setAlignment(Pos.CENTER_LEFT);
		mDayVB.setSpacing(10);
		mDayVB.setPadding(new Insets(20, 20, 20, 20));
		mDayVB.getChildren().addAll(dayLbl, optWed, optTh, optFri, optSat);
				
		//create emptyLbl2 and radio button objects for times
		timeLbl = new Label("TIMES:");
		timeLbl.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		//timeLbl.setUnderline(true);
		movieTime = new ToggleGroup();
		optTen = new RadioButton("10:00 am");
		optOne = new RadioButton("1:00 pm");
		optFive = new RadioButton("5:00 pm");
		optEight = new RadioButton("8:00 pm");
		optTen.setToggleGroup(movieTime);
		optOne.setToggleGroup(movieTime);
		optFive.setToggleGroup(movieTime);
		optEight.setToggleGroup(movieTime);
		
		//create layout for day options and add emptyLbl2 and radio buttons
		mTimeVB = new VBox();
		mTimeVB.setAlignment(Pos.CENTER_LEFT);
		mTimeVB.setSpacing(10);
		mTimeVB.setPadding(new Insets(20, 20, 20, 20));
		mTimeVB.getChildren().addAll(timeLbl, optTen, optOne, optFive, optEight);
		
		//create layout for radio button groups
		radioGroupsHB = new HBox();
		radioGroupsHB.setAlignment(Pos.CENTER);
		radioGroupsHB.setSpacing(10);
		radioGroupsHB.setPadding(new Insets(20, 20, 20, 20));
		radioGroupsHB.getChildren().addAll(mNameVB, mDayVB, mTimeVB);
		
		//create a emptyLbl2 to tell user what to do, set color, font and size
		confirmLbl = new Label("Please make your selections and Confirm:");
		confirmLbl.setTextFill(Color.DARKSLATEGREY);
		confirmLbl.setFont(new Font("Helvetica", 26));
		
		//movie selection layout in a VBox
	    selectLblsVB = new VBox(20);
	    selectLblsVB.setAlignment(Pos.CENTER);
	    selectLblsVB.setSpacing(10);
	    selectLblsVB.setPadding(new Insets(20, 20, 20, 20));
	    selectionChoiceLbl = new Label();
	    selectionChoiceLbl.setTextFill(Color.DARKSLATEGREY);
	    selectionChoiceLbl.setFont(new Font("Helvetica", 16));
	    selectionLblN = new Label();
	    selectionLblD = new Label();
	    selectionLblT = new Label();
	    selectLblsVB.getChildren().addAll(selectionChoiceLbl, selectionLblN, selectionLblD, selectionLblT);
		
		//create the confirm button,style it and event handler
	    confirmBtn = new Button("Confirm Movie");
	    confirmBtn.setStyle("-fx-background-color: #5f5b6c");
	    confirmBtn.setTextFill(Color.WHITE);
	    confirmBtn.setFont(new Font("Helvetica",16));
	    confirmBtn.setPadding(new Insets(10,10,10,10));
	    
	    nameSelected = new Label(" ");
	    nameSelected.setFont(new Font("Helvetica",14));
	    nameSelected.setTextFill(Color.web("#5f5b6c"));
	    nameSelected.setPrefSize(70,35);
	    
	    daySelected = new Label(" ");
	    daySelected.setFont(new Font("Helvetica",14));
	    daySelected.setTextFill(Color.web("#5f5b6c"));
	    daySelected.setPrefSize(70,35);
	    
	    timeSelected = new Label(" ");
	    timeSelected.setFont(new Font("Helvetica",14));
	    timeSelected.setTextFill(Color.web("#5f5b6c"));
	    timeSelected.setPrefSize(70,35);
	    	    	    	
	    confirmBtn.setOnAction(e -> {
	    	//find the selected button in each toggle group and change the text color
	    	mName = (RadioButton) movieName.getSelectedToggle();
	    	mName.setTextFill(Color.web("#4e53e5"));
	    	mDay = (RadioButton) movieDay.getSelectedToggle();
			mDay.setTextFill(Color.web("#4e53e5"));
			mTime = (RadioButton) movieTime.getSelectedToggle();
			mTime.setTextFill(Color.web("#4e53e5"));
	    			
			//display the user's selections
			selectionChoiceLbl.setText("You have made the following selections:");
			
			//add selections to the labels
			nameSelected.setText("MOVIE ");
			selectionLblN.setText(": " + mName.getText());
			selectionLblN.setPrefSize(90,35);
			daySelected.setText("DAY ");
			selectionLblD.setText(": " + mDay.getText());
			selectionLblD.setPrefSize(90,35);
			timeSelected.setText("TIME ");
			selectionLblT.setText(": " + mTime.getText());
			selectionLblT.setPrefSize(90,35);
			
			//disable the confirm button
			confirmBtn.setDisable(true);
	    });
		
	    //put all the selection header labels in a VBox on the left side 
        selectLblVB = new VBox();
        selectLblVB.getChildren().addAll(nameSelected, daySelected, timeSelected);
        selectLblVB.setMinSize(70,25);
        
        //put all the user input labels in a VBox on the right side 
        inputLblVB = new VBox();
        inputLblVB.getChildren().addAll(selectionLblN, selectionLblD, selectionLblT);
        inputLblVB.setMinSize(70,25);
        
        //create layout for user input labels
	    inputHB = new HBox();
	    inputHB.setAlignment(Pos.CENTER);
	    inputHB.setSpacing(50);
	    inputHB.setPadding(new Insets(20, 20, 20, 20));
	    inputHB.getChildren().addAll(selectLblVB, inputLblVB);
	    
	    //separate left and right side using separator
	    Separator hSeparator = new Separator();
	    hSeparator.setOrientation(Orientation.HORIZONTAL);
	    hSeparator.setStyle("-fx-background-color: #907bd6");
	    hSeparator.setMaxWidth(500);
	    
	    //create the seat selection button,style it and event handler
	    seatSelectBtn = new Button("Choose Your Seats");
	    seatSelectBtn.setStyle("-fx-background-color: #5f5b6c");
	    seatSelectBtn.setTextFill(Color.WHITE);
	    seatSelectBtn.setFont(new Font("Helvetica",16));
	    seatSelectBtn.setPadding(new Insets(10,10,10,10));
	    //create a button that will eventually open the seat selection window
	    seatSelectBtn.setOnAction(e -> {	
	    });
	    
	    //create layout for buttons
	    buttonHB = new HBox();
	    buttonHB.setAlignment(Pos.CENTER);
	    buttonHB.setSpacing(70);
	    buttonHB.setPadding(new Insets(20, 20, 20, 20));
	    buttonHB.getChildren().addAll(confirmBtn, seatSelectBtn);
	    
	    //sets up overall movie selection layout scene
	    selectLayout = new VBox(20);
	    selectLayout.setAlignment(Pos.CENTER);
	    selectLayout.getChildren().addAll(confirmLbl, radioGroupsHB, buttonHB, hSeparator, selectionChoiceLbl, inputHB);
	    selectLayout.setStyle("-fx-background-color: #bbc0c8");
	    		   	   
		//create a scene and put it in the stage
	    Scene scene = new Scene(selectLayout, 300, 300);
		//set stage title, put scene in stage, display stage
	    primaryStage.setTitle("Cinema Seat Saver");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    primaryStage.setResizable(false);
	}
	
	//create getters and setters
	public String getMovieName() {
		mNSet = mName.getText();
		return mNSet;
	}
	
	public void setMovieName(String mNSet) {
		if(mNSet.isEmpty()) {
			this.mNSet = mNSet;
		}
	}
	
	public String getMovieDay() {
		mDSet = mDay.getText();
		return mDSet;
	}
	
	public void setMovieDay(String mDSet) {
		if(mDSet.isEmpty()) {
			this.mDSet = mDSet;
		}
	}
	
	public String getMovieTime(String mTSet) {
		mTSet = mTime.getText();
		return mTSet;
	}
		
	public void setMovieTime(String mTSet) {
		if(mTSet.isEmpty()) {
			this.mTSet = mTSet;
		}
	}
	
	//main method	
	public static void main(String[] args) {
	       launch(args);
	}
}