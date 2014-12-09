package final1213;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Analyses simluated data from 2 channels in the Higgs search of the ATLAS experiment at the LHC
 * @author Aditya Mukherkee
 *
 */
public class DataAnalysis {

	public static void main(String[] args) throws IOException {
		Timer t = new Timer();
		t.startTimer();
		try {
			// Data URL's
			String backgroundGG_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
			String backgroundZZ_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
			String higgsCandidate_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";
			
			String splitter = "\\s+"; // regular expression for any number of whitespace
			
			// Import data from URL's into Collections
			Map<Integer, Bin> GGbinData = Input.importBackground(backgroundGG_URL, splitter);
			Map<Integer, Bin> ZZbinData = Input.importBackground(backgroundZZ_URL, splitter);
			Collection<CandidateEvent> ceData = Input.importCandidateEvents(higgsCandidate_URL, splitter);
			/*
			System.out.println("Background GG");
			Object[] bin_headers = {"Min E.(Gev)", "Max E.(GeV)", "Expected Events", "Candidate Events"};
			printBinList(bin_headers, GGbinData);
			System.out.println("Background ZZ");
			printBinList(bin_headers, ZZbinData);
			System.out.println("Higgs Candidates");
			Object[] ce_headers = {"Channel ID", "Event Energy(GeV)"};
			printCEList(ce_headers, ceData);*/
			
			higgsBinning(ceData, GGbinData, ZZbinData);
			double GGexp = expectedEventsInRange(120, 140, GGbinData);
			System.out.printf("%s %.2f\n", "No. expected events in 120-140 GeV on channel GG:", GGexp);
			double ZZexp = expectedEventsInRange(120, 140, ZZbinData);
			System.out.printf("%s %.2f\n", "No. expected events in 120-140 GeV on channel ZZ:", ZZexp);
			double GGcan = candidateEventsInRange(120, 240, GGbinData);
			System.out.printf("%s %.2f\n", "No. candidate events in 120-240 GeV on channel GG:", GGcan);
			double ZZcan = candidateEventsInRange(120, 240, ZZbinData);
			System.out.printf("%s %.2f\n", "No. candidate events in 120-240 GeV on channel ZZ:", ZZcan);
			// Print all data as tables
			
			
		} catch (Exception e){
			// Print error and stack trace
			System.out.println(e.getMessage());
			e.printStackTrace(); 
		}
		t.endTimer();
	}
	
	
	static void printBinList(Object[] headers, Map<Integer, Bin> data) {
		Iterator<Bin> itr = data.values().iterator();
		Bin b = itr.next(); 
		Object[] data_line = {b.e_low, b.e_high, b.n_background, b.getN_candidate()}; // Arbitrary line of data used to create String format using FormatPrinter
		int dp = 0; // No. decimal places to be printed to console (for doubles only)
		char sep = '|'; // Table columns seperator
		FormattedPrinter fp = new FormattedPrinter(headers, data_line, dp, sep); 
		fp.printHeaders(); // Print table headers 
		// To print Map in ascending order, need to sort KeySet 
		// KeySet is Set, Collections.sort only accepts List arguments
		List<Integer> bins = new ArrayList<Integer>(); // Initialise new ArrayList
		bins.addAll(data.keySet()); // Add all elements in Key Set to List
		Collections.sort(bins); // Sort
		Iterator<Integer> sortedItr = bins.iterator(); // Initialise iterator for sorted key list
		while (sortedItr.hasNext()) { // Iterate through sorted key list 
			Integer bin_id = sortedItr.next(); // Get current key
			Bin b_ = data.get(bin_id); // Get value of key (Bin object)
			Object[] data_ = {b_.e_low, b_.e_high, b_.n_background, b_.getN_candidate()}; // Object array of bin's fields
			fp.printData(data_); // Print bin in table format
		}
		fp.endTable();
	}
	
	static void printCEList(Object[] headers, Collection<CandidateEvent> data) {
		Iterator<CandidateEvent> itr = data.iterator();
		CandidateEvent ce = itr.next();
		Object[] data_line = {ce.event_channel_id, ce.event_energy};
		int dp = 0;
		char sep = '|';
		FormattedPrinter fp = new FormattedPrinter(headers, data_line, dp, sep);
		fp.printHeaders();
		while (itr.hasNext()) {
			CandidateEvent ce_ = itr.next();
			Object[] data_ = {ce_.event_channel_id, ce_.event_energy};
			fp.printData(data_);
		}
		fp.endTable();
	}
	
	static void higgsBinning(Collection<CandidateEvent> ceData, Map<Integer, Bin> GGbinData, Map<Integer, Bin> ZZbinData) throws Exception {
		Iterator<CandidateEvent> ceItr = ceData.iterator();
		int imeCounter = 0; // Error counters
		boolean imeBool = false;
		int iaeCounter = 0;
		boolean iaeBool = false;
		while (ceItr.hasNext()) {
			CandidateEvent ce = ceItr.next();
			try { // add Candidate Event energy to appropriate bin in appropriate channel and increment count of candidate events for that bin
				int eventEnergy = (int) ce.event_energy;
				if (ce.event_channel_id.equals("GG") & GGbinData.containsKey(eventEnergy)) {
					Bin b = GGbinData.get(eventEnergy);
					b.addCandidate(ce);
				} else if (ce.event_channel_id.equals("ZZ") & ZZbinData.containsKey(eventEnergy)) {
					Bin b = ZZbinData.get(eventEnergy);
					b.addCandidate(ce);
				} else { // throw different errors depending on whether channel_id or event energy were invalid
					//System.out.println("Invalid: "+ce); // Print invalid CandidateEvent
					if (ce.event_channel_id.equals("GG") == false | ce.event_channel_id.equals("ZZ") == false) {
						throw new InputMismatchException("ERROR: Candidate Event Channel ID must be either ZZ or GG!");
					} else if (GGbinData.containsKey(eventEnergy) == false | ZZbinData.containsKey(eventEnergy) == false) {
						/*if (ce.event_channel_id.equals("GG")) {
							GGbinData.put(eventEnergy, new Bin(eventEnergy, eventEnergy+1, 0));
						} else if (ce.event_channel_id.equals("ZZ")) {
							ZZbinData.put(eventEnergy, new Bin(eventEnergy, eventEnergy+1, 0));
						}*/
						throw new IllegalArgumentException("ERROR: Existing bins only have energy range >= 100 GeV and < 200 GeV!");
					}
				}
			} catch (InputMismatchException ime) {
				//System.out.println(ime.getMessage());
				imeBool = true;
				imeCounter++;
			} catch (IllegalArgumentException iae) {
				//System.out.println(ime.getMessage());
				iaeBool = true;
				iaeCounter++;
			}
			continue; // continue loop, effectively ignoring invalid CandidateEvents
		}
		// Check if any of the specified exceptions have been caught
		if (imeBool == true) {System.out.println("Caught "+imeCounter+" exceptions due to invalid CandidateEvent Channel ID.");}
		if (iaeBool == true) {System.out.println("Caught "+iaeCounter+" exceptions due to outlying Event energy.");}
	}
	
	static Double expectedEventsInRange(Integer lowerBound, Integer upperBound, Map<Integer, Bin> binData) {
		Double n = 0.0;
		for (Integer i = lowerBound; i<upperBound; i++) {
			Bin b = binData.get(i);
			n += b.n_background;
		}
		return n;
	}
	
	static Double candidateEventsInRange(Integer lowerBound, Integer upperBound, Map<Integer, Bin> binData) {
		Double n = 0.0;
		for (Integer i = lowerBound; i<upperBound; i++) {
			if (binData.containsKey(i)) {
				Bin b = binData.get(i);
				n += b.getN_candidate();
			} else {
				//System.out.println("There is no bin for "+i+"-"+(i+1)+" GeV");
			}
		}
		return n;
	}
	
	static Double logLikelihood(Map<Integer, Bin> channelData) {
		Double LL = 0.0;
		for (Bin b : channelData.values()) {
			Double y_i = b.n_background;
			Double n_i = b.getN_candidate();
			Double LL_i = (y_i - n_i) + n_i * Math.log(n_i / y_i); 
			LL += LL_i;
		}
		return LL;
	}

}
