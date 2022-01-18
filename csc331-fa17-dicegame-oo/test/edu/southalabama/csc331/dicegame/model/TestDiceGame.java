package edu.southalabama.csc331.dicegame.model;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestDiceGame extends TestCase {
	
	@Override
	protected void setUp() throws Exception {

	}
	
	@Test
	public void testInitial(){	
		
		DiceGame dg = new DiceGame();
		
		// By default, dice are six sided and we should be using two
		// There should be no face values returned from getDieValues(), since we haven't played yet
		int [] values = dg.getDieValues();
		assert (values[0] == 0);
			
		// The initial outcome (before we play a game) should be false
		assert (dg.getOutcome() == false);
		
		
		// The initial result (before we play a game) should be 0
		assert (dg.getResult() == 0);
		
		//Test getResults: does it sum to individual die values
		
		//Test getOutcome: does the outcome (win/loss) match the game logic based on results
		
	}
		
	public void testPlay() throws IOException{
		//Test play method: verify that all die values change correctly
		DiceGame dg = new DiceGame();
		dg.play();
		int [] dice = dg.getDieValues();
		assert (dice[0] > 0 && dice[1] > 0);
	}
	
	public void testGetResult(){
		//Test getResults: does it sum to individual die values
			
	}
		
		//Test getOutcome: does the outcome (win/loss) match the game logic based on results
				

}
