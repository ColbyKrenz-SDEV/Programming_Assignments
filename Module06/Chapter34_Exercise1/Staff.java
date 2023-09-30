/*
Programmer:	Colby Krenz
Date: 09/29/2023
Program Name: M06 Programming Assignment 1: Chapter 34: Exercise 34.1
Purpose: Write a program that views, inserts and updates staff information stored in a database.
View button displays a record. Insert button inserts a new record. Update button updates the record.
*/

package accessUpdating;

import javafx.beans.property.SimpleStringProperty;

public class Staff {

	//create some variables
	private final SimpleStringProperty staffID;
	private final SimpleStringProperty lastName;
	private final SimpleStringProperty firstName;
	private final SimpleStringProperty middleInitial;
	private final SimpleStringProperty address;
	private final SimpleStringProperty city;
	private final SimpleStringProperty state;
	private final SimpleStringProperty phoneNumber;
	
	//create a staff object
	public Staff(String staffID, String lastName, String firstName, String middleInitial, String address, String city, String state, String phoneNumber) {
		this.staffID = new SimpleStringProperty(staffID);
		this.lastName = new SimpleStringProperty(lastName);
		this.firstName = new SimpleStringProperty(firstName);
		this.middleInitial = new SimpleStringProperty(middleInitial);
		this.address = new SimpleStringProperty(address);
		this.city = new SimpleStringProperty(city);
		this.state = new SimpleStringProperty(state);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
	}

	//return and set the staff ID
	public String getStaffID() {
		return staffID.get();
	}
	public void setStaffID(String sID) {
		staffID.set(sID);
	}
	
	//return and set the last name
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lName) {
		lastName.set(lName);
	}
	
	//return and set the first name
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String fName) {
		firstName.set(fName);
	}
	
	//return and set the middle initial
	public String getMiddleInitial() {
		return middleInitial.get();
	}
	public void setMiddleInitial(String midInit) {
		middleInitial.set(midInit);
	}
		
	//return and set the address
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String addy) {
		address.set(addy);
	}
		
	//return and set the city
	public String getCity() {
		return city.get();
	}
	public void setCity(String cit) {
		city.set(cit);
	}
	
	//return and set the state
	public String getState() {
		return state.get();
	}
	public void setState(String ste) {
		state.set(ste);
	}
	
	//return and set the phone number
	public String getPhoneNumber() {
		return phoneNumber.get();
	}
	public void setPhoneNumber(String phNum) {
		phoneNumber.set(phNum);
	}
}