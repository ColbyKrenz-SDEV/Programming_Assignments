package application;

/*
Programmer:	Colby Krenz
Date: 10/12/2023
Program Name: M08 Final Project Submission: Cinema Seat Saver: SeatSelections Class
Purpose: Allow a user to select a single seat or multiple seats for their movie.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SeatSelections extends Application {

    //initialize different components and variables used in application
    Label title,resultLbl;
    Label screen,rowOne,rowTwo,rowThree,rowFour,rowFive,rowSix;
    Label emptyLbl1,emptyLbl2,emptyLbl3,emptyLbl4,emptyLbl5,emptyLbl6;
    Label movie,day,time,tickets,total,movieSelection,daySelection,timeSelection,ticketQuantity,totalCost,available,sold,selected;
    
    Button reservationBtn,availableSeat,unavailableSeat,selectedSeat;
    Button row1Seat1,row1Seat2,row1Seat3,row1Seat4,row1Seat5;
    Button row2Seat1,row2Seat2,row2Seat3,row2Seat4,row2Seat5;
    Button row3Seat1,row3Seat2,row3Seat3,row3Seat4,row3Seat5;
    Button row4Seat1,row4Seat2,row4Seat3,row4Seat4,row4Seat5;
    Button row5Seat1,row5Seat2,row5Seat3,row5Seat4,row5Seat5;
    Button row6Seat1,row6Seat2,row6Seat3,row6Seat4,row6Seat5;

    String btnColor,mmName,mDay,mTime,movName,movDay,movTime;
    String purple = "-fx-background-color:#907bd6";
    String green = "-fx-background-color:#76bca9";
    String[] btn = {"row1Seat1","row1Seat2","row1Seat3","row1Seat4","row1Seat5","row2Seat1","row2Seat2","row2Seat3","row2Seat4","row2Seat5","row3Seat1","row3Seat2","row3Seat3","row3Seat4","row3Seat5","row4Seat1","row4Seat2","row4Seat3","row4Seat4","row4Seat5","row5Seat1","row5Seat2","row5Seat3","row5Seat4","row5Seat5","row6Seat1","row6Seat2","row6Seat3","row6Seat4","row6Seat5"};
    String[] buttonColor = {purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple,purple};
    Button[] allButtons = {row1Seat1,row1Seat2,row1Seat3,row1Seat4,row1Seat5,row2Seat1,row2Seat2,row2Seat3,row2Seat4,row2Seat5,row3Seat1,row3Seat2,row3Seat3,row3Seat4,row3Seat5,row4Seat1,row4Seat2,row4Seat3,row4Seat4,row4Seat5,row5Seat1,row5Seat2,row5Seat3,row5Seat4,row5Seat5,row6Seat1,row6Seat2,row6Seat3,row6Seat4,row6Seat5};
    Button[] selectedBtn = new Button[30];
    
    Integer mTicket, mAmount;
    int ticket = 0;
    int amount = 0;
    int count = 0;
    
    public SeatSelections() {
    }
        
    public SeatSelections(Integer quanTicket, Integer totalAmount) {
		this.mTicket = quanTicket;
		this.mAmount = totalAmount;
	}    
        
    //button is selected button and index is index of button
    public void setDisplay(Button button, int index){
    	    	
    	//movie selections
    	movieSelection.setText("Barbie");
        daySelection.setText("Friday");
        timeSelection.setText("8:00pm");
        
    	//get current color of button
        btnColor = buttonColor[index];
        //if button is purple and then selected it changes to green
        //also calculates the cost, and how many tickets
        if(btnColor == purple){
            button.setStyle(green);
            buttonColor[index] = green;
            ticket++;
            if(index<30){
                amount += 9;
                totalCost.setText(": $ " + amount);
            }
           
            ticketQuantity.setText(": " + ticket);
            selectedBtn[index] = button;            
        }
        //if button is green, variables are cleared
        else if(btnColor==green){
            button.setStyle(purple);
            buttonColor[index] = purple;
            ticket--;
            if(index<30){
                amount -= 9;
                totalCost.setText(": $ " + amount);
            }
            
            ticketQuantity.setText(": " + ticket);
            selectedBtn[index] = null;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	//movie clapperboard icon found @ https://icons8.com/icon/LyrkX9tAKqNr/clapperboard
    	//icon by Icons8 @ https://icons8.com
    	Image clapperboard = new Image("icons8-movie-48.png");
    	primaryStage.getIcons().add(clapperboard);
    			
        //create header with user instructions
        title = new Label("Select Your Seats:");
        title.setPrefSize(500,80);
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Helvetica",26));

        //create a emptyLbl2 that denotes the screen
        screen = new Label("Screen");
        screen.setStyle("-fx-background-color: #5f5b6c");
        screen.setPrefSize(325,45);
        screen.setAlignment(Pos.CENTER);
        screen.setFont(new Font("Helvetica",15));
        screen.setTextFill(Color.WHITE);
        emptyLbl1 = new Label("");
        emptyLbl1.setPrefSize(15,35);

        //number the buttons to stand for seats
        int[] buttonText = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};

        //style the buttons
        for(int i = 0; i<30; i++){
            allButtons[i] = new Button(buttonText[i]+ "");
            allButtons[i].setPrefSize(60,65);
            allButtons[i].setStyle(purple);
            allButtons[i].setTextFill(Color.WHITE);
        }

        //create rows/labels for the screen and seats to be in
        emptyLbl2 = new Label(" ");
        emptyLbl2.setPrefSize(65,35);
        rowOne = new Label("1");
        rowOne.setPrefSize(15,35);
        rowTwo = new Label("2");
        rowTwo.setPrefSize(15,35);
        rowThree = new Label("3");
        rowThree.setPrefSize(15,35);
        rowFour = new Label("4");
        rowFour.setPrefSize(15,35);
        rowFive = new Label("5");
        rowFive.setPrefSize(15,35);
        rowSix = new Label("6");
        rowSix.setPrefSize(15,35);
        
        //create HBox to hold the buttons/seats
        HBox rowOneHB = new HBox();
        HBox rowTwoHB = new HBox();
        HBox rowThreeHB = new HBox();
        HBox rowFourHB = new HBox();
        HBox rowFiveHB = new HBox();
        HBox rowSixHB = new HBox();

        //put the buttons/seats into their row and set spacing
        rowOneHB.getChildren().addAll(rowOne,allButtons[0],allButtons[1],allButtons[2],allButtons[3],allButtons[4]);
        rowOneHB.setSpacing(5);
        rowOneHB.setPadding(new Insets(5,5,5,20));

        rowTwoHB.getChildren().addAll(rowTwo,allButtons[5],allButtons[6],allButtons[7],allButtons[8],allButtons[9]);
        rowTwoHB.setSpacing(5);
        rowTwoHB.setPadding(new Insets(5,5,5,20));

        rowThreeHB.getChildren().addAll(rowThree,allButtons[10],allButtons[11],allButtons[12],allButtons[13],allButtons[14]);
        rowThreeHB.setSpacing(5);
        rowThreeHB.setPadding(new Insets(5,45,5,20));

        rowFourHB.getChildren().addAll(rowFour,allButtons[15],allButtons[16],allButtons[17],allButtons[18],allButtons[19]);
        rowFourHB.setSpacing(5);
        rowFourHB.setPadding(new Insets(5,45,5,20));

        rowFiveHB.getChildren().addAll(rowFive,allButtons[20],allButtons[21],allButtons[22],allButtons[23],allButtons[24]);
        rowFiveHB.setSpacing(5);
        rowFiveHB.setPadding(new Insets(5,45,5,20));

        rowSixHB.getChildren().addAll(rowSix,allButtons[25],allButtons[26],allButtons[27],allButtons[28],allButtons[29]);
        rowSixHB.setSpacing(5);
        rowSixHB.setPadding(new Insets(5,45,5,20));

        //create an HBox to hold the screen and set spacing
        HBox screenHB = new HBox();
        screenHB.getChildren().addAll(emptyLbl1,screen);
        screenHB.setSpacing(5);
        screenHB.setPadding(new Insets(5,10,20,20));

        //put all the rows in a VBox on the left side
        VBox seatsVBox = new VBox();
        seatsVBox.setAlignment(Pos.TOP_CENTER);
        seatsVBox.setMinSize(430,0);
        seatsVBox.getChildren().addAll(screenHB,rowOneHB,rowTwoHB,rowThreeHB,rowFourHB,rowFiveHB,rowSixHB);

        //event handling for the buttons/seats
        allButtons[0].setOnAction(e->setDisplay(allButtons[0],0));
        allButtons[1].setOnAction(e->setDisplay(allButtons[1],1));
        allButtons[2].setOnAction(e->setDisplay(allButtons[2],2));
        allButtons[3].setOnAction(e->setDisplay(allButtons[3],3));
        allButtons[4].setOnAction(e->setDisplay(allButtons[4],4));
        allButtons[5].setOnAction(e->setDisplay(allButtons[5],5));
        allButtons[6].setOnAction(e->setDisplay(allButtons[6],6));
        allButtons[7].setOnAction(e->setDisplay(allButtons[7],7));
        allButtons[8].setOnAction(e->setDisplay(allButtons[8],8));
        allButtons[9].setOnAction(e->setDisplay(allButtons[9],9));
        allButtons[10].setOnAction(e->setDisplay(allButtons[10],10));
        allButtons[11].setOnAction(e->setDisplay(allButtons[11],11));
        allButtons[12].setOnAction(e->setDisplay(allButtons[12],12));
        allButtons[13].setOnAction(e->setDisplay(allButtons[13],13));
        allButtons[14].setOnAction(e->setDisplay(allButtons[14],14));
        allButtons[15].setOnAction(e->setDisplay(allButtons[15],15));
        allButtons[16].setOnAction(e->setDisplay(allButtons[16],16));
        allButtons[17].setOnAction(e->setDisplay(allButtons[17],17));
        allButtons[18].setOnAction(e->setDisplay(allButtons[18],18));
        allButtons[19].setOnAction(e->setDisplay(allButtons[19],19));
        allButtons[20].setOnAction(e->setDisplay(allButtons[20],20));
        allButtons[21].setOnAction(e->setDisplay(allButtons[21],21));
        allButtons[22].setOnAction(e->setDisplay(allButtons[22],22));
        allButtons[23].setOnAction(e->setDisplay(allButtons[23],23));
        allButtons[24].setOnAction(e->setDisplay(allButtons[24],24));
        allButtons[25].setOnAction(e->setDisplay(allButtons[25],25));
        allButtons[26].setOnAction(e->setDisplay(allButtons[26],26));
        allButtons[27].setOnAction(e->setDisplay(allButtons[27],27));
        allButtons[28].setOnAction(e->setDisplay(allButtons[28],28));
        allButtons[29].setOnAction(e->setDisplay(allButtons[29],29));
     
        //display labels for user selections headers
        movie = new Label("Movie");
        movie.setFont(new Font("Helvetica",14));
        movie.setTextFill(Color.web("#5f5b6c"));
        movie.setPrefSize(70,25);
        
        day = new Label("Day");
        day.setFont(new Font("Helvetica",14));
        day.setTextFill(Color.web("#5f5b6c"));
        day.setPrefSize(70,25);

        time = new Label("Time");
        time.setFont(new Font("Helvetica",14));
        time.setTextFill(Color.web("#5f5b6c"));
        time.setPrefSize(70,25);

        tickets = new Label("Tickets");
        tickets.setFont(new Font("Helvetica",14));
        tickets.setTextFill(Color.web("#5f5b6c"));
        tickets.setPrefSize(70,25);

        total = new Label("Total");
        total.setFont(new Font("Helvetica",14));
        total.setTextFill(Color.web("#5f5b6c"));
        total.setPrefSize(70,25);

        //display labels that show user input
        movieSelection = new Label("Barbie");
        movieSelection.setFont(new Font("Helvetica",14));
        movieSelection.setPrefSize(200,25);
        
        daySelection = new Label("Friday");
        daySelection.setFont(new Font("Helvetica",14));
        daySelection.setPrefSize(2200,25);

        timeSelection = new Label("8:00pm");
        timeSelection.setFont(new Font("Helvetica",14));
        timeSelection.setPrefSize(200,25);

        ticketQuantity = new Label(": 0");
        ticketQuantity.setFont(new Font("Helvetica",14));
        ticketQuantity.setPrefSize(200,25);

        totalCost = new Label(": $ 0");
        totalCost.setFont(new Font("Helvetica",14));
        totalCost.setPrefSize(200,25);

        //create and style the reservationBtn button
        reservationBtn = new Button("Reserve now");
        reservationBtn.setStyle("-fx-background-color: #5f5b6c");
        reservationBtn.setTextFill(Color.WHITE);
        reservationBtn.setFont(new Font("Helvetica",14));
        reservationBtn.setPadding(new Insets(8,8,8,8));
        
        //handle event in reservationBtn after it's pressed
        reservationBtn.setOnAction(e->{
            for(int i=0;i<30;i++){
                if(selectedBtn[i]!=null){
                    selectedBtn[i].setStyle("-fx-background-color:#d97791");
                    //remove the event handler for the selected buttons/seats so they are displayed as sold
                    selectedBtn[i].setOnAction(f->{});
                }
            }
            
            //reset the user input variables
            ticketQuantity.setText(": 0");
            totalCost.setText(": $ 0");
            count += ticket;
            if(ticket==1) {
            	resultLbl.setText(ticket + " Ticket = $" + amount);
            }
            else if(ticket==0) {
            	resultLbl.setText("Please Select A Seat!");
            }
            else {
            	resultLbl.setText(ticket + " Tickets = $" + amount);
            }
            
            //when all buttons/seats are reserved, disable reservationBtn
            if(count==allButtons.length){
                reservationBtn.setDisable(true);
                resultLbl.setText("Sold Out!");
            }
            
            ticket = 0;
            amount = 0;
            Button[] allSold = new Button[30];
            selectedBtn = allSold;
        });

        //display how many tickets and total
        resultLbl = new Label("");
        resultLbl.setFont(new Font("Helvetica",20));
        resultLbl.setTextFill(Color.web("#4e53e5"));
        resultLbl.setPrefSize(230,25); 
        
        //displays color of available seats
        availableSeat = new Button();
        availableSeat.setStyle("-fx-background-color:#907bd6");
        availableSeat.setPrefSize(30,35);
        available = new Label("Available");
        available.setFont(new Font("Helvetica",14));
        available.setAlignment(Pos.CENTER_LEFT);
        available.setPadding(new Insets(7,50,5,3));

        //displays color of sold seats
        unavailableSeat = new Button();
        unavailableSeat.setStyle("-fx-background-color:#d97791");
        unavailableSeat.setPrefSize(30,35);
        sold = new Label("Sold");
        sold.setFont(new Font("Helvetica",14));
        sold.setAlignment(Pos.CENTER_LEFT);
        sold.setPadding(new Insets(7,50,5,3));

        //displays color of selected seats
        selectedSeat = new Button();
        selectedSeat.setStyle("-fx-background-color:#76bca9");
        selectedSeat.setPrefSize(30,35);
        selected = new Label("Selected");
        selected.setFont(new Font("Helvetica",14));
        selected.setAlignment(Pos.CENTER_LEFT);
        selected.setPadding(new Insets(7,50,5,3));

        //put all the user selections in a VBox on the right side 
        VBox selectionLblsVB = new VBox();
        selectionLblsVB.getChildren().addAll(movie,day,time,tickets,total);
        selectionLblsVB.setMinSize(70,0);
        VBox selectionsVB = new VBox();
        selectionsVB.getChildren().addAll(movieSelection,daySelection,timeSelection,ticketQuantity,totalCost);
        selectionsVB.setMinSize(70,0);

        //put the seats on the left and the selections on the right
        HBox selectionsHB = new HBox();
        selectionsHB.getChildren().addAll(selectionLblsVB,selectionsVB);
        selectionsHB.setPadding(new Insets(5,5,5,5));
        selectionsHB.setSpacing(10);
        HBox buttonHB = new HBox();
        buttonHB.getChildren().add(reservationBtn);
        buttonHB.setPadding(new Insets(20,5,20,5));
        buttonHB.setSpacing(10);
        HBox availableHB = new HBox();
        availableHB.getChildren().addAll(availableSeat,available);
        availableHB.setPadding(new Insets(5,5,5,5));
        availableHB.setSpacing(10);
        HBox soldHB = new HBox();
        soldHB.getChildren().addAll(unavailableSeat,sold);
        soldHB.setPadding(new Insets(5,5,5,5));
        soldHB.setSpacing(10);
        HBox selectedHB = new HBox();
        selectedHB.getChildren().addAll(selectedSeat,selected);
        selectedHB.setPadding(new Insets(5,5,5,5));
        selectedHB.setSpacing(10);

        //separate left and right side using separator
        Separator vSeparator = new Separator();
        vSeparator.setOrientation(Orientation.VERTICAL);
        vSeparator.setMinSize(2,0);
        vSeparator.setStyle("-fx-background-color: #907bd6");
        emptyLbl3 = new Label(" ");
        emptyLbl3.setPrefSize(65,35);
        emptyLbl4 = new Label(" ");
        emptyLbl4.setPrefSize(65,35);
        emptyLbl5 = new Label(" ");
        emptyLbl5.setPrefSize(65,35);
        emptyLbl6 = new Label(" ");
        emptyLbl6.setPrefSize(35,105);
        VBox rightSideVB = new VBox();
        rightSideVB.getChildren().addAll(availableHB,soldHB,selectedHB,emptyLbl3,selectionsHB,emptyLbl4,buttonHB,emptyLbl5,resultLbl);
        rightSideVB.setMaxSize(2500,2500);
        HBox mainHB = new HBox();
        mainHB.getChildren().addAll(seatsVBox,vSeparator, emptyLbl6,rightSideVB);
        VBox mainVB = new VBox();
        mainVB.setAlignment(Pos.TOP_CENTER);
        mainVB.getChildren().addAll(title,mainHB);
        mainVB.setStyle("-fx-background-color: #bbc0c8"); 
	    
        //create a scene and put it in the stage
        Scene scene = new Scene(mainVB,715,650);
        //set stage title, put scene in stage, display stage
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Cinema Seat Saver");
        primaryStage.setResizable(false);
    }
    
  //create getters and setters
    public int getQuanTicket() {
    	mTicket = ticket;
		return mTicket;
	}
	
	public void setQuanTicket(Integer mTicket) {
		if(mTicket != null) {
			this.mTicket = mTicket;
		}
	}
	public int getTotalAmount() {
		mAmount = amount;
		return mAmount;
	}
		
	public void setTotalAmount(Integer mAmount) {
		if(mAmount != null) {
			this.mAmount = mAmount;
		}
	}
		
	//instantiate main method
	public static void main(String[] args) {
	    launch(args);
	}
}
