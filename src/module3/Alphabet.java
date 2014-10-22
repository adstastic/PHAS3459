package module3;
import java.util.Random;
// Written by Aditya Mukherjee for PHAS 3459 Module 3

public class Alphabet {
// Class to generate random characters and parse them into integers
	
	public static void main(String[] args) {
		// New empty StringBuilder object of length 1000
		StringBuilder randString = new StringBuilder(1000);
		// Counter for loop
		int i;
		// Maximum number of iterations
		int iMax = 1000;
		// Sum of parsed characters
		int total = 0;
		// Number of exceptions caught
		int exceptions = 0;
		
		// Iterate 1000 times
		for (i=0; i<=iMax; i++) {
			// Generate random character
			char randChar = randomCharacter();
			// Check if character is letter or digit
			if (Character.isLetterOrDigit(randChar)) {
				// Append to StringBuilder object
				randString.append(randChar);
				try {
					// Try parsing character to int
					int parsedChar = Integer.parseInt(Character.toString(randChar));
					// Add int to total
					total += parsedChar;
					// Catch exception
				} catch (Exception e) {
					// Increment value of exception by 1 
					exceptions += 1;
				}
			}
		}
		
		// Print contents of variables to console
		System.out.println("Random String: "+randString);
		System.out.println("Length: "+randString.length());
		System.out.println("Sum of parsed characters: "+total);
		System.out.println("Number of exceptions: "+exceptions);
	}
	
	// Method to generate random characters
	public static char randomCharacter() {
		// Instantiate random object 
		Random randInt = new Random();
		// Generate random int in range 0-127 inclusive
		int generatedInt = randInt.nextInt(128);
		// Cast random int as char
		return (char) generatedInt;
	}

}
