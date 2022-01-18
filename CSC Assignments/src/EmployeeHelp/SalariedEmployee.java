// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee {

	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	private double yearlySalary;
	private double earnings;
	
	public SalariedEmployee(Name name, String ID, double yearlySalary) {
		super(name, ID);
		this.yearlySalary = yearlySalary;
		earnings = (yearlySalary / 52);
	}
	
	public String getEarnings() {
		String output = "Name: " + name.getName()
							+ "\nWorker ID: " + ID
							+ "\nEmployee Type: Salaried Employee"
							+ "\nYearly Salary: $" + twoDecimals.format(yearlySalary)
							+ "\nTotal pay this week: $" + twoDecimals.format(earnings);
		return output;
	}
	
}