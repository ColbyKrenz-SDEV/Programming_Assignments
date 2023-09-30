package movie;

/*
Programmer:	Colby Krenz
Date: 09/30/2023
Program Name: M06 Final Project: Update 4 - GUI(JavaFX)
Purpose: Write the Java code to complete the JavaFX GUI widgets.
Work on finalizing the events, have 2 completed.
*/

//import packages
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Movie extends Application {

    Stage window;
    Scene movieSelect, movieConfirm;

    //main method
    public static void main(String[] args) {
        launch(args);
    }

    //override start method in Application
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //confirm button
        Label confirmLbl = new Label("Please make your selections below and hit Confirm.");
        Button confirmBtn = new Button("Confirm");
        confirmBtn.setOnAction(e -> window.setScene(movieConfirm));

        //movie selection layout
        VBox selectLayout = new VBox(20);
        selectLayout.getChildren().addAll(confirmLbl, confirmBtn);
        movieSelect = new Scene(selectLayout, 300, 300);

        //return button
        Button returnBtn = new Button("Return to Movie Selection");
        returnBtn.setOnAction(e -> window.setScene(movieSelect));

        //confirmation layout
        StackPane returnLayout = new StackPane();
        returnLayout.getChildren().add(returnBtn);
        movieConfirm = new Scene(returnLayout, 200, 200);

        //select movie screen will be initial scene upon opening
        window.setScene(movieSelect);
        window.setTitle("Movie Selection");
        window.show();
    }

}