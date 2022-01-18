

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee 
{
	double yearlySalary;
	double totalPay;
	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	
	public SalariedEmployee(String first, String middle, String last, String title, double yearlyPay)
	{
		super(name);
		yearlySalary = yearlyPay;
			
	}
	
	public double earnings ()
	{
		totalPay = (yearlySalary/52);
		return totalPay;
	}
	
	public String toString ()
	{
		return name + " "  + " $" + totalPay;
	}

}
