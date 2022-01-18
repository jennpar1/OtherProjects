

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

abstract public class  Employee implements Serializable
{	
	 static Name name;

	
	public Employee(Name name)
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name.toString();
	}
		
	public String toString()
	{
		return name + " ";
	}
	
	public double earnings()
	{
		double totalPay = 0;
		return totalPay;
		
	}
	
	
	static String fileName = "listOfEmployees.txt";


	public int compareTo(Object otherObj) {
		Employee other = (Employee) otherObj;
		int compare = name.last.toLowerCase().compareTo(other.name.getLastName().toLowerCase());
		if (compare !=0)
			return compare;
		else
		{
			compare = name.first.toLowerCase().compareTo(other.name.getFirstName().toLowerCase());
		}
		if (compare !=0)
			return compare;
		else return
				name.middle.toLowerCase().compareTo(other.name.getMiddleName().toLowerCase());
	}

	
	
	
	
	
	

			 
	
}
