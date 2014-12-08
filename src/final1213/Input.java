package final1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

/** 
 * Class to input simulated particle event data from URL
 * @author Aditya Mukherjee
 */
public class Input {

	/**
	 * Scanner from URL
	 * @param url Location of text file containing data
	 * @return Scanner 
	 * @throws IOException
	 */
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	/**
	 * @param url Location of text file containing data
	 * @param splitter Regular Expression or other specifier used to split line from URL
	 * @return Collection<Bin>
	 * @throws IOException
	 */
	public static Collection<Bin> binImport(String url, String splitter) throws IOException {
		Collection<Bin> binList = new ArrayList<Bin>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			// Instantiate bin object and input data processing Strings
			Bin bin;
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); // trim leading and trailing whitespace
			if (inputLineCheck(line)) { // Check if first character of line is letter or digit
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			if (lineArray.length != 2) { // Check if input is 5 or 6 pieces of data
				throw new InputMismatchException("ERROR: Bin data contains more than 3 elements! Bin data must only contain: Minimum energy, Maximum energy, Expected events.");
				String name = lineArray[0]; // Set planet instance variables from input String
			} else	
				// System.out.println(name); // code to check data working
				int e_low = Integer.parseInt(lineArray[0]);
				int e_high = Integer.parseInt(lineArray[1]);
				double n_background = Double.parseDouble(lineArray[2]);
				// Instantiate planet object with the appropriate constructor depending on the number of inputs provided
				if (lineArray.length == 6) {
					double distance = Double.parseDouble(lineArray[4]);
					bin = new Bin(name, year, method, mass, separation, distance);
				} else {
					bin = new Bin(name, year, method, mass, separation);
				}
				if (exoplanets.containsKey(name) == true) { // if HashMap of planets already contains planet name, throw error
					throw new InputMismatchException("Duplicate planet!");
				} else {
					exoplanets.put(name, bin); // add planet to hashmap
				}
			} else {
				throw new InputMismatchException("Input must contain 5 or 6 variables in the format: NAME,DATE,[PLANET DISCOVERY METHOD],[MASS,SEPARATION FROM STAR],[DISTANCE FROM EARTH]");
			}
			//i++; //Increment counter
		}
		sc.close(); // Close scanner to prevent memory leak
		//System.out.println(i); // Print planet counter
		//System.out.println(exoplanets.keySet().size()); // Print size of exoplanet map to compare with counter
		return exoplanets;
	}
	
	//  create new hashmap of methods
	public static Map<String, Method> planetsByMethod(Map<String, Bin> exoplanets) {
		Map<String, Method> methods = new HashMap<String, Method>();
		// loop through each entry in exoplanets map
		for (Entry<String, Bin> e : exoplanets.entrySet()) {
			Bin p = e.getValue();
			String key = p.getMethod();
			if (methods.containsKey(key)) {
				methods.get(key).add(p);
			} else {
				// add new method to methods hashmap
				methods.put(key, new Method(key));
			}
		}
		return methods;
	}
	
	// check input line 
	private static boolean inputLineCheck(String line) {
		// check if second element in line array starts with a letter 
		if (Character.isLetterOrDigit(line.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}
}
