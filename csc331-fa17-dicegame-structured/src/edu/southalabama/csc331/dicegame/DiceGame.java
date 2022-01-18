package edu.southalabama.csc331.dicegame;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	
	private final static Scanner f_commandLine = new Scanner(System.in);
	
	private String f_player;
	private final int f_numsides = 7;
	private final int f_numsides2 = 6;
	private int f_dice1fv;
	private int f_dice2fv;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DiceGame dg = new DiceGame();
		dg.play();
	}
	
	private void play() throws IOException {
		f_player = getPlayerName();
		
		boolean keepPlaying = true;
		
		while (keepPlaying) {
			System.out.println ();
			System.out.println (f_player + ": Rolling the dice...");
			
			f_dice1fv = getRandomNumber();
			f_dice2fv = getRandomNumberAlt();
			
			reportResults();
			
			System.out.println ("Continue (Y/N)?");
			final String response = readLineFromConsole().toLowerCase().trim();
			if (!response.equalsIgnoreCase("Y")) {
				keepPlaying = false;
			}			
		}
	}

	private void reportResults() {
		System.out.println ();
		System.out.println ("Die 1: " + this.f_dice1fv);
		System.out.println ("Die 2: " + this.f_dice2fv);
		
		int result = this.f_dice1fv + this.f_dice2fv;
		System.out.println ("Result: " + result);
		
		if ((result > 5) && (result < 10)) {
			System.out.println ("You win!");
		}
		else {
			System.out.println ("You lose!");
		}
		System.out.println ();
	}

	private int getRandomNumber() {
		int num = getRandomNumberGenerator().nextInt(f_numsides);
		return num + 1;
	}

	private int getRandomNumberAlt() {
		int num = getRandomNumberGenerator().nextInt(f_numsides2);
		return num + 1;
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
	
	private static volatile long seedQualifier = 432282912137141232L;
	public static Random getRandomNumberGenerator() {
		return new Random(++seedQualifier + System.nanoTime());
	}

}
