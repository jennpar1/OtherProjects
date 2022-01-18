package edu.southalabama.csc331.dicegame.model;

import java.io.IOException;

public class DiceGame {
	
	Die die1 = new Die(6);
	Die die2 = new Die(6);
	int intDie1;
	int intDie2;
	private int result;
	
	

	public void play() throws IOException{
		die1.roll();
		die2.roll();
		getDieValues();
		getResult();
		
	}
	
	public int [] getDieValues(){
		intDie1 = die1.getFaceValue();
		intDie2 = die2.getFaceValue();
		int array [] = {intDie1, intDie2};
		return array;
		
	}
	
	public boolean getOutcome(){
		getResult();
		if (result == 7)
			return true;
		else 
			return false;
	}
	
	public int getResult(){
		result = (intDie1 + intDie2);
		return result;
				
	}
	
}
