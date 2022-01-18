// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.io.Serializable;

public abstract class Employee implements Comparable<Employee>, Serializable {

	protected Name name;
	protected String ID;
	
	public Employee(Name name, String ID) {
		this.name = name;
		this.ID = ID;
	}
	
	public abstract String getEarnings();
	
	public String getLastName() {
		return name.getLast();
	}
	
	public int compareTo(Employee x) {
		if (this.toString().compareTo(x.toString()) > 0) {
			return 1;
		}
		else if (this.toString().compareTo(x.toString()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return name.toString();
	}
	
}