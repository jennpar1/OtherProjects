

import java.text.DecimalFormat;

public class CommissionEmployee extends Employee
{
	
	double percentage;
	double salesAmount;
	double totalPay;
	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	
	
	public CommissionEmployee(String first, String middle, String last, String title, double payPercentage, double totalSales)
	{
		super(name);
		percentage = payPercentage;
		salesAmount = totalSales;
		
	}
	
	public double earnings ()
	{
		totalPay = (percentage * salesAmount);		
		return totalPay;
	}
	
	public String toString ()
	{
		return name + " " + " $" + totalPay;
	}

}
