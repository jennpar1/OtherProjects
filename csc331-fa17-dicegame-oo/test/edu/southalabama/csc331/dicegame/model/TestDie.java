package edu.southalabama.csc331.dicegame.model;

import java.text.DecimalFormat;

import org.junit.Test;

import junit.framework.TestCase;

public class TestDie extends TestCase {
	
	@Override
	protected void setUp() throws Exception {

	}
	
	
	@Test
	public void testGetFaceValue() {	
		Die d = new Die(6);
		int val = d.getFaceValue();
		assert (val == d.getFaceValue());
		
		int val2 = d.getFaceValue();
		assert (val == val2);
		
		int val3 = d.getFaceValue();
		assert (val3 == d.getFaceValue());
	}
	
	@Test
	public void testRoll() {	
		final int numtests = 10000;
		
		int numsides = 6;
		
		// Test 6-side die
		Die d = new Die(numsides);
		
		// Unrolled/new die should return 0!
		int val = d.getFaceValue();
		assert (val == 0);
			
		for (int i = 0; i < numtests; i++) {
			d.roll();
			val = d.getFaceValue();
			assert (val > 0);
			assert (val <= numsides);
		}
		
		// Test 16-sided die
		numsides = 16;
		d = new Die(numsides);
		
		// Unrolled/new die should return 0!
		val = d.getFaceValue();
		assert (val == 0);
			
		for (int i = 0; i < numtests; i++) {
			d.roll();
			val = d.getFaceValue();
			assert (val > 0);
			assert (val <= numsides);
		}
		
		// Test 10-sided die
		numsides = 10;
		d = new Die(numsides);
		
		// Unrolled/new die should return 0!
		val = d.getFaceValue();
		assert (val == 0);
			
		for (int i = 0; i < numtests; i++) {
			d.roll();
			val = d.getFaceValue();
			assert (val > 0);
			assert (val <= numsides);
		}
		

	}
	
	
	@Test
	public void testRandomness() {	
		
		final int numtests = 5;
		final int numrolls = 10000;
		Die d = new Die(6);
		d.roll();	
		
		for (int testnum = 1; testnum <= numtests; testnum++) {

			System.out.println ();
			System.out.println ();
			System.out.println ("Randomness Test " + testnum);
			System.out.println ("=======================================");
			
			int[] counts = new int[6];

			for (int i = 0; i < numrolls; i++) {
				d.roll();
				int val = d.getFaceValue();
				counts[val-1] = counts[val-1] + 1;
	
			}
			
			DecimalFormat df = new DecimalFormat("00.000");
			
			System.out.println ("After " + numrolls + " rolls:");
			System.out.println ("Ones:\t"   + counts[0] + " (" + df.format((counts[0]/(double) numrolls) * 100) + "%)"); 
			System.out.println ("Twos:\t"   + counts[1] + " (" + df.format((counts[1]/(double) numrolls) * 100) + "%)"); 
			System.out.println ("Threes:\t" + counts[2] + " (" + df.format((counts[2]/(double) numrolls) * 100) + "%)"); 
			System.out.println ("Fours:\t"  + counts[3] + " (" + df.format((counts[3]/(double) numrolls) * 100) + "%)"); 
			System.out.println ("Fives:\t"  + counts[4] + " (" + df.format((counts[4]/(double) numrolls) * 100) + "%)"); 
			System.out.println ("Sixes:\t"  + counts[5] + " (" + df.format((counts[5]/(double) numrolls) * 100) + "%)"); 
			
			// Distribution of each value should be about 1/6 
			// IF it is truly random, should not be 1/5 or 1/7
			int lower = (int) ((1 / (double) 7) * numrolls);
			int upper = (int) ((1 / (double) 5) * numrolls);
			
			System.out.println ();
			System.out.println ("Lower bound (1/7) = " + lower);
			System.out.println ("Upper bound (1/5) = " + upper);
			
			assert (counts[0] < upper);
			assert (counts[0] > lower);
			assert (counts[1] < upper);
			assert (counts[1] > lower);
			assert (counts[2] < upper);
			assert (counts[2] > lower);
			assert (counts[3] < upper);
			assert (counts[3] > lower);
			assert (counts[4] < upper);
			assert (counts[4] > lower);
			assert (counts[5] < upper);
			assert (counts[5] > lower);
		
		}
			

	}
}
