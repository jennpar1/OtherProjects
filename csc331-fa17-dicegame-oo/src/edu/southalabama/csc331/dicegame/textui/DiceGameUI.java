package edu.southalabama.csc331.dicegame.textui;

import java.io.IOException;
import java.util.Scanner;

import edu.southalabama.csc331.dicegame.model.DiceGame;

public class DiceGameUI {
	
	private final static Scanner f_commandLine = new Scanner(System.in);
	
	private String f_player;
	private final DiceGame f_game = new DiceGame();


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DiceGameUI dg = new DiceGameUI();
		dg.play();
	}
	
	private void play() throws IOException {
		f_player = getPlayerName();
		
		boolean keepPlaying = true;
		
		while (keepPlaying) {
			System.out.println ();
			System.out.println (f_player + ": Rolling the dice...");
			
			f_game.play();
			
			reportResults();
			
			System.out.println ("Continue (Y/N)?");
			final String response = readLineFromConsole().toLowerCase().trim();
			if (!response.equalsIgnoreCase("Y")) {
				keepPlaying = false;
			}			
		}
	}

	private void reportResults() {
		
		int[] dievalues = f_game.getDieValues();

		  
		System.out.println ();
		
		int diecount = 1;
		for (Integer fv: dievalues) {
			System.out.println ("Die " + diecount + ": " + fv);
			diecount++;
		}
		
		System.out.println ("Result: " + f_game.getResult());
		
		if (f_game.getOutcome()) {
			System.out.println ("You win!");
		}
		else {
			System.out.println ("You lose!");
		}
		System.out.println ();
	}

	private static String getPlayerName() throws IOException {
		String name = new String();
		while (name.length() < 1 || name.length() > 50)  {
			System.out.print("Enter player name: ");
			String commandline = readLineFromConsole();
			name = commandline.trim();
		}
		return name;
	}
	
	private static String readLineFromConsole() throws IOException {
		String s = f_commandLine.nextLine();
		return s;
	}

}
