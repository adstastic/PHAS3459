package final1213;

import java.io.IOException;
import java.util.Collection;

/**
 * Analyses simluated data from 2 channels in the Higgs search of the ATLAS experiment at the LHC
 * @author Aditya Mukherkee
 *
 */
public class DataAnalysis {

	public static void main(String[] args) throws IOException {
		try {
			// Data URL's
			String backgroundGG_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
			String backgroundZZ_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
			String higgsCandidate_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";
			
			String splitter = "\\s+"; // regular expression for any number of whitespace
			
			// Import data from URL's into Collections
			Collection<Bin> backgroundGG = Input.importBackground(backgroundGG_URL, splitter);
			Collection<Bin> backgroundZZ = Input.importBackground(backgroundZZ_URL, splitter);
			Collection<CandidateEvent> higgsCandidate = Input.importCandidateEvents(higgsCandidate_URL, splitter);
			
			
		} catch (Exception e){
			// Print error and stack trace
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
