package final1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	private static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	/**
	 * Imports data of expected background events in energy bins and stores in Collection of Bins
	 * @param url Location of text file containing data
	 * @param splitter Regular Expression or other specifier used to split line from URL
	 * @return Collection<Bin>
	 * @throws IOException
	 */
	public static Collection<Bin> importBackground(String url, String splitter) throws IOException {
		Collection<Bin> binList = new ArrayList<Bin>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			// Instantiate bin object and input data processing Strings
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			System.out.println(line);// trim leading and trailing whitespace
			if (inputLineCheck(line)) { // Check line for specified characteristics
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
				System.out.println(lineArray.toString());
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
				System.out.println(lineArray.toString());
			}
			int n_inputElements = 3; // expected no. elements 
			if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
				throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! Background data must only contain: Channel ID, Event Energy(GeV).");} 
			else {
			// System.out.println(name); // code to check data working
			int e_low = Integer.parseInt(lineArray[0]);
			int e_high = Integer.parseInt(lineArray[1]);
			double n_background = Double.parseDouble(lineArray[2]);
			// Instantiate bin with inputs
			Bin bin = new Bin(e_low, e_high, n_background);
			binList.add(bin);
			}
		}
		sc.close(); // Close scanner to prevent memory leak
		return binList;
	}
	
	
	/**
	 * Imports Higgs candidate events with detector channel and energy, stores in Collection of CandidateEvents
	 * @param url
	 * @param splitter
	 * @return Collection<CandidateEvent>
	 * @throws IOException
	 */
	public static Collection<CandidateEvent> importCandidateEvents(String url, String splitter) throws IOException {
		Collection<CandidateEvent> candidateEventList = new ArrayList<CandidateEvent>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			// Instantiate candidateEvent object and input data processing Strings
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); // trim leading and trailing whitespace
			if (inputLineCheck(line)) { // Check if first character of line is letter or digit
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			int n_inputElements = 1; // expected no. elements
			if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
				throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! CandidateEvent data must only contain: Channel ID, Event Energy(GeV).");
			} else {
				String channel_id = lineArray[0];
				int energy = Integer.parseInt(lineArray[1]);
				// Instantiate CandidateEvent with inputs
				CandidateEvent ce = new CandidateEvent(channel_id, energy);
				candidateEventList.add(ce);
			}
		}
		sc.close(); // Close scanner to prevent memory leak
		return candidateEventList;
	}
	
	// check input line 
	private static boolean inputLineCheck(String line) {
		// check if first character of line is letter
		if (Character.isLetterOrDigit(line.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}
}
