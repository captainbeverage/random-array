/**
 * RandomArray Class
 * @author Jordan Harris
 * @date August 27, 2014
 * 
 * This is the driver program, which creates an array of random integers, and displays
 * the elements in a table of integer ranges.
 */

import java.util.Random;

public class RandomArray {

	public static void main(String[] args) {
		
		final int arraySize = 50;
		final int maxRandomValue = 100;
		final int minRandomValue = 1;
		final int rowRange = 10;
		
		// End of the row must be 1 less than the entire length of the row
		int rowEnd = rowRange - 1;           
		// Holds the range of possible values in each element of the array
		int randomRange = maxRandomValue - minRandomValue + 1;  
		
		// Creates a random object
		Random rand = new Random();
		// Creates an array of arraySize integers
		int[] randomArray = new int[arraySize];
		
		// Assigns random integers to the array based on the randomRange and minRandomValue
		for(int i = 0; i < randomArray.length; i++) {
			randomArray[i] = rand.nextInt(randomRange) + minRandomValue;
		}
		
		// Loops through the range of possible integer values in the array 
		for(int range = minRandomValue; range <= maxRandomValue; range += rowRange) {
			// The if-else statements create a dynamic table display, which can  adjust its 
			// display of the elements based on the maxRandomValue.
			if (range == maxRandomValue) {
				// Displays the range if the end of the range is equal to the maxRandomValue
				System.out.printf("%-13s%-7s", range, "|");
			}
			else if (range + rowEnd > maxRandomValue) {
				// Displays the range if the end of the range is greater than the maxRandomValue
				System.out.printf("%-13s%-7s", range + " - " + maxRandomValue, "|");
			}
			else {
				// Displays the range in all other cases
				System.out.printf("%-13s%-7s", range + " - " + (range + rowEnd), "|");	
			}
			
			// Displays asterisks for each element within a given integer range
			for(int index = 0; index < randomArray.length; index++) {
				if(randomArray[index] >= range && randomArray[index] <= (range + rowEnd)) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}