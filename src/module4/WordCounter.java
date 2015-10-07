package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;
// Written by Aditya Mukherjee for Module 4 of PHAS3549

public class WordCounter {
// Class to count words on web resource from URL
	
	public static void main(String[] args) throws Exception {
		try {
			// Prompt user to enter URL
			String url = WordCounter.getStringFromKeyboard("Please enter a URL below:");
			// Count words on URL Page
			int wordCount = countWordsInResource(url);
			System.out.println("Number of Words: "+wordCount); // Print number of words
		// Catch exception for invalid URL
		} catch (MalformedURLException m) {
			System.out.println("Invalid URL!: "+m.getMessage());
		// Catch exception for invalid input
		} catch (IOException i) {
			System.out.println("Error reading input!: "+i.getMessage());
		// Catch any other exception
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	// Get string typed by user
	public static String getStringFromKeyboard(String input) throws IOException {
		// Create new buffered reader from input steam
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(input); // Print input
		String keyboardInput = b.readLine(); // Read line from buffer
		return keyboardInput; 
	}
	
	// Count words a web page
	public static int countWordsInResource(String urlName) throws MalformedURLException, IOException {
		URL u = new URL(urlName); // New URL object
		// Buffered reader from URL input stream
		BufferedReader b = new BufferedReader(new InputStreamReader(u.openStream()));
		// Scanner
		Scanner sc = new Scanner(b);
		int wordCount = 0;
		// Increment counter if there is a word after the current one
		while (sc.hasNext()) {
			String word = sc.next();
			wordCount++;
		}
		// Close socket and flush buffer to prevent memory leak
		sc.close();
		return wordCount;
	}
}
