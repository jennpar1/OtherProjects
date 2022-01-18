// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.text.DecimalFormat;

public class HourlyEmployee extends Employee {

	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	private double hourlyWage;
	private double hoursWorked;
	private double earnings;
	
	public HourlyEmployee(Name name, String ID, double hourlyWage, double hoursWorked) {
		super(name, ID);
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
		
		if (hoursWorked > 40) {
			earnings = (hourlyWage * 40) + (hoursWorked - 40) * (hourlyWage) * (1.5);
		}
		else {
			earnings = hourlyWage * hoursWorked;
		}
		
	}
	
	public String getEarnings() {
		String output = "Name: " + name.getName()
							+ "\nWorker ID: " + ID
							+ "\nEmployee Type: Paid Hourly"
							+ "\nHourly Pay: $" + twoDecimals.format(hourlyWage)
							+ "\nHours worked this week: $" + twoDecimals.format(hoursWorked)
							+ "\nTotal pay this week: $" + twoDecimals.format(earnings);			
		return output;
	}
	
}