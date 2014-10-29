package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;
// Written by Aditya Mukherjee for Module 4 of PHAS 3549

public class WordCounter {
	
	public static void main(String[] args) throws Exception {
		try {
			// Prompt user to enter URL
			String url = WordCounter.getStringFromKeyboard("Please enter a URL below:");
			// Count words on URL Page
			int wordCount = countWordsInResource(url);
			// Print number of words
			System.out.println(wordCount);
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
		// Print input
		System.out.println(input);
		// Read line from buffer
		String keyboardInput = b.readLine();
		return keyboardInput;
	}
	
	// Count words a web page
	public static int countWordsInResource(String urlName) throws MalformedURLException, IOException {
		// New URL object
		URL u = new URL(urlName);
		// Buffered reader from url input stream
		BufferedReader b = new BufferedReader(new InputStreamReader(u.openStream()));
		// Scanner
		Scanner sc = new Scanner(b);
		int wordCount = 0;
		// Increment counter if there is a word after the current one
		while (sc.hasNext()) {
			String word = sc.next();
			wordCount++;
		}
		// Flush buffer
		sc.close();
		return wordCount;
	}
}
