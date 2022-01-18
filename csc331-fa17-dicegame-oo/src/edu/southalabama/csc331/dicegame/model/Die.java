package edu.southalabama.csc331.dicegame.model;


public class Die {
	
	int numSides;
	int faceValue;
	
	public Die (){
		this.numSides = numSides;
	}
	
	public Die(int numSides){
		this.numSides = numSides;
	}
	
	public int roll(){
		faceValue = ((int) (Math.random() * numSides)) + 1;
		return faceValue;
	}

	public int getFaceValue() {
		return this.faceValue;
	}
	
}


