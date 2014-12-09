package final1213;

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
	 * Imports data from URL
	 * @param url Location of text file containing data
	 * @param splitter Regular Expression or other specifier used to split line from URL
	 * @return Collection<Bin>
	 * @throws IOException
	 */
	public static HashMap<Double, Bin> importBackground(String url, String splitter) throws IOException {
		// Instantiate bin object and input data processing Strings
		HashMap<Double, Bin> binList = new HashMap<Double, Bin>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			if (inputLineCheck(line, 'M') & sc.hasNextLine()) { // Check line for specified characteristics
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			Bin b = createBin(lineArray);
			binList.put(b.e_low, b);
		}
		sc.close(); // Close scanner to prevent memory leak
		return binList;
	}
	
	public static Bin createBin(String[] lineArray) {
		int n_inputElements = 3; // expected no. elements 
		if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
			throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! Background data must only contain: Channel ID, Event Energy(GeV).");
		} else {
			double e_low = Double.parseDouble(lineArray[0]);
			double e_high = Double.parseDouble(lineArray[1]);
			double n_background = Double.parseDouble(lineArray[2]);
			Bin bin = new Bin(e_low, e_high, n_background); // Instantiate bin with inputs
			return bin;
		}
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
			String line;
			String[] lineArray;
			line = sc.nextLine().trim(); 
			if (inputLineCheck(line, 'C') & sc.hasNextLine()) { // Check line for specified characteristics
				lineArray = sc.nextLine().trim().split(splitter); // Go to next line and split by splitter
			} else {
				lineArray = line.trim().split(splitter); // Split current line by splitter
			}
			CandidateEvent ce = createCandidateEvent(lineArray);
			candidateEventList.add(ce);
		}
		sc.close(); // Close scanner to prevent memory leak
		return candidateEventList;
	}
	
	public static CandidateEvent createCandidateEvent(String[] lineArray) {
		int n_inputElements = 2; // expected no. elements
		if (lineArray.length != n_inputElements) { // Check if input contains expected number of elements
			throw new InputMismatchException("ERROR: Input does not contain "+n_inputElements+" elements! CandidateEvent data must only contain: Channel ID, Event Energy(GeV).");
		} else {
			String channel_id = lineArray[0];
			double energy = Double.parseDouble(lineArray[1]);
			CandidateEvent ce = new CandidateEvent(channel_id, energy); // Instantiate CandidateEvent with inputs
			return ce;
		}
	}
	
	// check input line 
	private static boolean inputLineCheck(String line, char check) {
		// check if first character of line is letter
		if (line.charAt(0) == check) {
			return true;
		} else {
			return false;
		}
	}
}
