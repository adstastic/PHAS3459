package exam2;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/** 
 * Class to input tidal data
 * @author Aditya Mukherjee
 */
public class Input {
	
	/**
	 * Scanner from URL
	 * @param url Location of text file containing data
	 * @return Scanner 
	 * @throws IOException
	 */
	private static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}

	/**
	 * Imports Sea Level records from URL
	 * @param url Location of text file containing data
	 * @param splitter Regular Expression or other specifier used to split line from URL
	 * @return Collection<SeaLevel>
	 * @throws IOException
	 */
	public static Collection<SeaLevel> importSeaLevels(String url, String splitter) throws IOException {
		// Instantiate bin object and input data processing Strings
		Collection<SeaLevel> seaLevelData = new ArrayList<SeaLevel>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			//System.out.println(line);
			if (inputLineCheck(line, 'P') == false & sc.hasNextLine()) { // Check if current line starts with P
				lineArray = sc.nextLine().trim().split(splitter); // If current line does not start with P, go to next line and split by splitter 
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			SeaLevel s = createSeaLevel(lineArray);
			seaLevelData.add(s);
		}
		sc.close(); // Close scanner to prevent memory leak
		return seaLevelData;
	}
	
	/**
	 * Imports Sea Level records from URL
	 * @param url Location of text file containing data
	 * @param splitter Regular Expression or other specifier used to split line from URL
	 * @return Collection<SeaLevel>
	 * @throws IOException
	 */
	public static Collection<SeaLevel> importSeaLevels2(String url, String splitter) throws IOException {
		// Instantiate bin object and input data processing Strings
		Collection<SeaLevel> seaLevelData = new ArrayList<SeaLevel>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			//System.out.println(line);
			lineArray = line.trim().split(splitter); // Split current line by splitter
			SeaLevel s = createSeaLevel2(lineArray);
			seaLevelData.add(s);
		}
		sc.close(); // Close scanner to prevent memory leak
		return seaLevelData;
	}
	
	/**
	 * Creates SeaLevel object from String[] input
	 * @param lineArray
	 * @return SeaLevel
	 */
	public static SeaLevel createSeaLevel2(String[] lineArray) {
		int n_inputElements = 8; // expected no. elements 
		if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
			throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! Sea level data must only contain: site ID, year, month, date, hour, minute, measured sea level, predicted sea level.");
		} else {
			String ID = lineArray[5];
			int year = Integer.parseInt(lineArray[0]);
			int month = Integer.parseInt(lineArray[1]);
			int day = Integer.parseInt(lineArray[2]);
			int hour = Integer.parseInt(lineArray[3]);
			int min = Integer.parseInt(lineArray[4]);
			double measuredSeaLevel = Double.parseDouble(lineArray[6]);
			double predictedSeaLevel = Double.parseDouble(lineArray[7]);
			SeaLevel s = new SeaLevel(ID, year, month, day, hour, min, measuredSeaLevel, predictedSeaLevel); // Instantiate SeaLevel with inputs
			return s;
		}
	}
	
	public static SeaLevel createSeaLevel(String[] lineArray) {
		int n_inputElements = 8; // expected no. elements 
		if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
			throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! Sea level data must only contain: site ID, year, month, date, hour, minute, measured sea level, predicted sea level.");
		} else {
			String ID = lineArray[0];
			int year = Integer.parseInt(lineArray[1]);
			int month = Integer.parseInt(lineArray[2]);
			int day = Integer.parseInt(lineArray[3]);
			int hour = Integer.parseInt(lineArray[4]);
			int min = Integer.parseInt(lineArray[5]);
			double measuredSeaLevel = Double.parseDouble(lineArray[6]);
			double predictedSeaLevel = Double.parseDouble(lineArray[7]);
			SeaLevel s = new SeaLevel(ID, year, month, day, hour, min, measuredSeaLevel, predictedSeaLevel); // Instantiate SeaLevel with inputs
			return s;
		}
	}
	
	/**
	 * Imports Sites list and stores in Collection
	 * @param url
	 * @param splitter
	 * @return Collection<CandidateEvent>
	 * @throws IOException
	 */
	public static Collection<Site> importSites (String url, String splitter) throws IOException {
		Collection<Site> siteList = new ArrayList<Site>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			if (inputLineCheck(line, 'S') & sc.hasNextLine()) { // Check line starts with S (to ignore first line)
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			Site s = createSite(lineArray);
			siteList.add(s);
		}
		sc.close(); // Close scanner to prevent memory leak
		return siteList;
	}
	
	
	
	/**
	 * Creates Site object
	 * @param lineArray
	 * @return Site
	 */
	public static Site createSite(String[] lineArray) {
		int n_inputElements = 2; // expected no. elements
		if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
			throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! Site data must only contain: site name, site ID.");
		} else {
			String name = lineArray[0];
			String ID = lineArray[1];
			Site s = new Site(name, ID); // Instantiate Site with inputs
			return s;
		}
	}
	
	
	/**
	 * Checks first character of input string for specified character
	 * @param line
	 * @param check
	 * @return true if yes, false if no
	 */
	private static boolean inputLineCheck(String line, char check) {
		// check if first character of line is letter
		if (line.charAt(0) == check) {
			return true;
		} else {
			return false;
		}
	}
}
