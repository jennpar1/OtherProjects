

import java.io.Serializable;

public class Name implements Serializable
{
	
	String first;		//Person's first name
	String last;		//Person's last name
	String middle;		//Person's middle name
	String title;
	
	//Constructors
	public Name()		//Assigns empty strings to field
	{
		first = "";
		last = "";
		middle = "";
		title = "";
	}
	
	public Name(String firstName, String middleName, String lastName, String nameTitle)
	{
		first = firstName;		//Assigns parameters to fields
		last = lastName;
		middle = middleName;
		title = nameTitle;
	}
	
	//Observer method
	public String getFirstName()
	{
		return first;
	}
	
	public String getMiddleName()
	{
		return middle;
	}
	
	public String getLastName()
	{
		return last;
	}
	
	public String toString()
	{
		return  title + " " + last + ", " +  first + " " + middle ;
	}

}
