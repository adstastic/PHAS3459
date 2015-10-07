package module4;
import java.net.*;
import java.io.*;
//Written by Aditya Mukherjee for Module 4 of PHAS3549

public class NumericalReader {
// Class to read numbers from web resource and write to file
	
	/* Instance Variables */
	private double minValue;
	private double maxValue; 
	private int nValues; 
	private double sumOfValues;
	private PrintWriter pw;

	public static void main(String[] args) throws Exception {
		// New NumericalReader
		NumericalReader nr = new NumericalReader();
		// URL to read from
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt";
		try {
			// Read from URL
			BufferedReader br = brFromURL(url);
			// or BufferedReader reader = brFromFile("filename.dat");
			// Empty String
			String line = "";
			// Start analysis of file, create output file, initialise instance variables
			nr.analysisStart(); 
			// Loop until buffer empty
			// int i = 0; // For testing try-catch block inside loop
			while ((line = br.readLine()) != null) { 
				try {
					// Print loop number to check output of each loop
					//System.out.println(i);
					//i++;
					
					// Analyse line, check for comments, read numbers, write to file, update instance variables
					nr.analyseData(line); 
				}
				// Catch exception, print stack trace, continue loop
				catch (IndexOutOfBoundsException iobe) {iobe.printStackTrace(); continue;} 
			}
			// End analysis, flush buffer, close socket, print final values of instance variables
			nr.analysisEnd(); 
		} 
		// Catch exceptions, print message and stack trace
		catch (MalformedURLException m) {
			System.out.println("Invalid URL!");
			m.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("I/O error!");
			ioe.printStackTrace();
		}
		catch (NullPointerException npe) {
			System.out.println("Object does not exist!");
			npe.printStackTrace();
		}
	}
	
	// BufferedReader from URL
	static BufferedReader brFromURL(String url) throws IOException {
		URL u = new URL(url);
		BufferedReader URLReader = new BufferedReader(new InputStreamReader(u.openStream()));
		return URLReader;
	}
	
	// BufferedReader from file
	static BufferedReader brFromFile(String file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		return fileReader;
	}
	
	// Start analysis
	void analysisStart() throws IOException {
		
		// Create file on system
		String path = "N:"+File.separator+"numbers.txt";
		// Initialise FileWriter
		FileWriter fw = new FileWriter(new File(path));
		// Wrap FileWriter in BufferedWriter
		BufferedWriter br = new BufferedWriter(fw);
		// Wrap BufferedWriter in PrintWriter - done because PrintWriter gives access to println method 
		pw = new PrintWriter(br);
		
		/* Initialise instance variables */
		maxValue = Double.MIN_VALUE; // smallest double value
		minValue = Double.MAX_VALUE; // largest double value
		nValues = 0;
		sumOfValues = 0;
	}
	
	// Data analysis
	void analyseData(String s) throws IOException, IndexOutOfBoundsException {
		
		// Skip lines if blank or beginning with letter 
		if (s.isEmpty() || Character.isLetter(s.charAt(0))) {} // do nothing
		else {
			// String Array to hold elements of line split into numbers 
			String[] numberArray = s.split("\\s+"); // regex for any nonzero no. of whitespaces
			
			// Loop ends after last element in array 
			for (int i=0; i < numberArray.length; i++) {
				// Parse array element (single number) into double
				double number = Double.parseDouble(numberArray[i]);
				/* Output */ 
				// System.out.println(/*" "+i+":*/); check output of each array index
				System.out.println(number); // Print number to console
				pw.println(number); // Print number to file
				/* Updating variables */
				minValue = (number < minValue ? number : minValue); // Compare current minValue, maxValue with number
				maxValue = (number > maxValue ? number : maxValue); // If number smaller than minValue or larger than maxValue, respective value = number
				nValues += 1; // Increment number of values by 1
				sumOfValues += number; // Add number to current sum
			} 
		}	
	}
	
	// End analysis
	void analysisEnd() throws NullPointerException {
		/* Print final values of instance variables */
		System.out.println("Minimum value: "+minValue);
		System.out.println("Maximum value: "+maxValue);
		System.out.println("Number of values: "+nValues);
		System.out.println("Sum of values: "+sumOfValues);
		// Close PrintWriter to prevent memory leak
		pw.close();
	}
}
