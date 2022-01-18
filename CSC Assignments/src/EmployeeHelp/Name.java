// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.io.Serializable;

public class Name implements Serializable {

	private String firstName;
	private String middleName;
	private String lastName;
	private String title;
	
	public Name(String firstName, String middleName, String lastName, String title) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.title = title;
	}
	
	public String getLast() {
		return lastName.toUpperCase();
	}
	
	public String getName() {
		return title + " " + firstName + " " + middleName + " " + lastName;
	}
	
	public String toString() {
		return lastName + ", " + title + " " + firstName + " " + middleName;
	}
	
}