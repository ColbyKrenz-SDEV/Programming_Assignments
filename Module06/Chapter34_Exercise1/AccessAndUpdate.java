/*
Programmer:	Colby Krenz
Date: 09/29/2023
Program Name: M06 Programming Assignment 1: Chapter 34: Exercise 34.1
Purpose: Write a program that views, inserts and updates staff information stored in a database.
View button displays a record. Insert button inserts a new record. Update button updates the record.
*/

package accessUpdating;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class AccessAndUpdate extends Application {
	
	//create the table
	private TableView<Staff> staffTable = new TableView<Staff>();
	private final ObservableList<Staff> data = FXCollections.observableArrayList(
			new Staff("2564", "Johnson", "Becky", "L", "123 Main St", "Anytown", "IN", "3256548800"),
			new Staff("2789", "Rawlins", "Kenny", "R", "456 Circle Rd", "Townsville", "IN", "4587520001"));
	final HBox hBoxInput = new HBox();
	final HBox hBoxBtn = new HBox();
	final VBox vBox = new VBox();

	//initialize main method
	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//override the start method in Application
	@Override
	public void start(Stage primaryStage) {
		//create a scene with size parameters and set the title	
		Scene scene = new Scene(new Group());
		primaryStage.setTitle("Chapter 34.1: Access And Update a Staff Table");
		primaryStage.setWidth(900);
		primaryStage.setHeight(600);
		
		//label the table
		final Label label = new Label("Staff Information");
		
		staffTable.setEditable(true);
		
		//create the columns for the staff table
		TableColumn iDCol = new TableColumn("Staff ID");
		iDCol.setMinWidth(75);
		iDCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("staffID"));
		
		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastName"));
		
		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(100);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("firstName"));
		
		TableColumn midInitCol = new TableColumn("Middle Initial");
		midInitCol.setMinWidth(50);
		midInitCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("middleInitial"));
		
		TableColumn addressCol = new TableColumn("Address");
		addressCol.setMinWidth(200);
		addressCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("address"));
		
		TableColumn cityCol = new TableColumn("City");
		cityCol.setMinWidth(100);
		cityCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("city"));
		
		TableColumn stateCol = new TableColumn("State");
		stateCol.setMinWidth(50);
		stateCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("state"));
		
		TableColumn phoneCol = new TableColumn("Phone Number");
		phoneCol.setMinWidth(100);
		phoneCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("phoneNumber"));
		
		staffTable.setItems(data);
		staffTable.getColumns().addAll(iDCol, lastNameCol, firstNameCol, midInitCol, addressCol, cityCol, stateCol, phoneCol);
		
		//create the text fields to enter data
		final TextField addStaffID = new TextField();
		addStaffID.setPromptText("Staff ID");
		addStaffID.setMaxWidth(iDCol.getPrefWidth());
		
		final TextField addLastName = new TextField();
		addLastName.setPromptText("Last NameD");
		addLastName.setMaxWidth(lastNameCol.getPrefWidth());
		
		final TextField addFirstName = new TextField();
		addFirstName.setPromptText("First Name");
		addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
		
		final TextField addMidInit = new TextField();
		addMidInit.setPromptText("Middle Initial");
		addMidInit.setMaxWidth(midInitCol.getPrefWidth());
		
		final TextField addAddress = new TextField();
		addAddress.setPromptText("Address");
		addAddress.setMaxWidth(addressCol.getPrefWidth());
		
		final TextField addCity = new TextField();
		addCity.setPromptText("City");
		addCity.setMaxWidth(cityCol.getPrefWidth());
		
		final TextField addState = new TextField();
		addState.setPromptText("State");
		addState.setMaxWidth(lastNameCol.getPrefWidth());
		
		final TextField addPhoneNum = new TextField();
		addPhoneNum.setPromptText("Phone");
		addPhoneNum.setMaxWidth(phoneCol.getPrefWidth());
		
		//create the buttons to submit user input
		final Button viewBtn = new Button("View");
		viewBtn.setOnAction(e -> {
			TableView<Staff> staffTV = new TableView<>();
			ObservableList<Staff> staffSelected = staffTV.getSelectionModel().getSelectedItems();
			System.out.println(staffSelected);
		});
		
		//create a button to insert user input
		final Button insertBtn = new Button("Insert");
		insertBtn.setOnAction(e -> {
			data.add(new Staff(
					addStaffID.getText(),addLastName.getText(), addFirstName.getText(), addMidInit.getText(), 
					addAddress.getText(), addCity.getText(), addState.getText(), addPhoneNum.getText()
			));
			addStaffID.clear();
			addLastName.clear(); 
			addFirstName.clear(); 
			addMidInit.clear(); 
			addAddress.clear(); 
			addCity.clear(); 
			addState.clear(); 
			addPhoneNum.clear();
		});
		
		//create a button to update user input
		final Button updateBtn = new Button("Update");
		updateBtn.setOnAction(e -> {
			System.out.println("hi");
		});
		
		
		//create a button to clear a selected row
		final Button clearBtn = new Button("Clear");
		clearBtn.setOnAction(e -> {
			ObservableList<Staff> staffSelected, allStaff;
			allStaff = staffTable.getItems();
			staffSelected = staffTable.getSelectionModel().getSelectedItems();
			staffSelected.forEach(allStaff::remove);
		});
		
		//add everything to the hbox and then add table and hbox to the vbox
		hBoxInput.setSpacing(10);
		hBoxInput.setPadding(new Insets(10, 10, 10, 10));
		hBoxInput.getChildren().addAll(addStaffID, addLastName, addFirstName, addMidInit, addAddress, 
				addCity, addState, addPhoneNum);
		hBoxBtn.setSpacing(10);
		hBoxBtn.setPadding(new Insets(10, 10, 10, 10));
		hBoxBtn.getChildren().addAll(viewBtn, insertBtn, updateBtn, clearBtn);
		vBox.getChildren().addAll(label, staffTable, hBoxInput, hBoxBtn);
		vBox.setSpacing(5);
		vBox.setPadding(new Insets(10, 0, 0, 10));
		((Group) scene.getRoot()).getChildren().addAll(vBox);
		
			
		//put scene in stage, display stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
	