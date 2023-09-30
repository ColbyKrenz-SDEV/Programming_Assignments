package movieGoing;

/*
Programmer:	Colby Krenz
Date: 09/30/2023
Program Name: M06 Final Project: Update 4 - GUI(JavaFX)
Purpose: Write the Java code to complete the JavaFX GUI widgets.
Work on finalizing the events, have 2 completed.
*/

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

//might use a confirmation box once user makes a selection
public class ConfirmBox {
	
	//boolean variable that stores user's answer
	static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        //block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        
        //create yes and no buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        
        yesButton.setOnAction(e -> {
        	answer = true;
        	window.close();
        });
        
        noButton.setOnAction(e -> {
        	answer = false;
        	window.close();
        });
        
        //create layout and put in objects
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        //display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }

}