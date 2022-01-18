// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.text.DecimalFormat;

public class CommissionBasedEmployee extends Employee {

	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	final private double BASE_PAY = 20000;
	private double commissionRate;
	private double sales;
	private double earnings;
	
	public CommissionBasedEmployee(Name name, String ID, double commissionRate, double sales) {
		super(name, ID);
		this.commissionRate = commissionRate;
		this.sales = sales;
		earnings = (BASE_PAY / 52) + (commissionRate * sales);
	}
	
	public String getEarnings() {
		String output = "Name: " + name.getName()
							+ "\nWorker ID: " + ID
							+ "\nEmployee Type: Commission Based Employee"
							+ "\nCommission Rate: " + twoDecimals.format(commissionRate) + "%"
							+ "\nSales this week: $" + twoDecimals.format(sales)
							+ "\nTotal pay this week: $" + twoDecimals.format(earnings);			
		return output;
	}
	
}