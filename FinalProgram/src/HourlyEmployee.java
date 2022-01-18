

import java.text.DecimalFormat;

public class HourlyEmployee extends Employee
{
	double hourlyWage;
	double hoursWorked;
	double totalPay;
	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	
	
	public HourlyEmployee(String first, String middle, String last, String title, double hourlyWages, double totalHours)
	{
		super(name);
		hourlyWage = hourlyWages;
		hoursWorked = totalHours;
		
	}
	
	public double earnings ()
	{
		totalPay = (hourlyWage * hoursWorked);		
		return totalPay;
	}
	
	public String toString ()
	{
		return name + " " + " $" + totalPay;
	}

}
