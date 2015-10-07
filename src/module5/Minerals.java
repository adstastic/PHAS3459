package module5;
import java.net.*;
import java.util.*;
import java.io.*;
//Written by Aditya Mukherjee for PHAS 3459 Module 5

// Reads two datasets from URL's and creates HashMaps of them extract information for specific item from both
public class Minerals {

	public static void main(String[] args) {
		try {
			// Define URL's
			String samples = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";
			String locations = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";
			// String error = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"; // Debugging
			
			// Initialise HashMaps
			HashMap<Integer, Double> sampleMap =  sampleMap(samples);
			HashMap<Integer, String> locationMap =  locationMap(locations);
			
			// HashMap<Integer, Double> sampleMap =  sampleMap(error); // Debugging
			// HashMap<Integer, String> locationMap =  locationMap(error); // Debugging
			
			// Initialise variables to hold initial max, min values (for comparison against)
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			// Initialise variables to store key value of relevant entries
			int minKey = 0;
			int maxKey = 0;
			
			// Iterate through all entries in one Map, find keys of entries of lowest and highest value
			for (Map.Entry<Integer, Double> entry : sampleMap.entrySet()) {
				double mass = entry.getValue();
				// If value lower than current min, it becomes new min
				if (mass < min) {
					min = mass;
					minKey = entry.getKey();
				}
				// If value higher than current max, it becomes new max
				if (mass > max) {
					max = mass;
					maxKey = entry.getKey();
				}
			}
			
			// Check if Map contains key
			if (locationMap.containsKey(minKey)) {
				// Get mass from one Map and location from the other
				String location = locationMap.get(minKey);
				Double mass = sampleMap.get(minKey);
				// Print to console
				System.out.println("Sample of smallest mass:");
				System.out.println("Code: "+minKey+" Mass: "+mass+" g Location: "+location);
			} else {
				throw new NullPointerException("Minimum value key doesn't exist!");
			}
			
			// Check if map contains key
			if (locationMap.containsKey(maxKey)) {
				// Get mass from one map and location from the other
				String location = locationMap.get(maxKey);
				Double mass = sampleMap.get(maxKey);
				// Print to console
				System.out.println("Sample of largest mass:");
				System.out.println("Code: "+maxKey+" Mass: "+mass+" g Location: "+location);
			} else {
				throw new NullPointerException("Maximum value key doesn't exist!");
			}
		}
		// Catch exceptions
		catch (InputMismatchException e) {
			if (e.getMessage() == "MASS NOT K-V" ) {
				System.out.println("Mass data has more than 1 value per key. Each key must have a single value.");
			} else if (e.getMessage() == "LOC NOT K-V") {
				System.out.println("Location data has more than 1 value per key. Each key must have a single value.");
			} else {
				System.out.println("Error: "+e.getMessage());
				e.printStackTrace();
			}
		}
		catch (NullPointerException npe) {
			System.out.println("Error: "+npe.getMessage());
			npe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error: "+ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		
			
		
	}
	
	// BufferedReader from URL
	static BufferedReader brFromURL(String url) throws IOException {
		URL u = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		return br;
	}
	
	// Builds HashMap of samples dataset
	static HashMap<Integer, Double> sampleMap(String samples) throws IOException, InputMismatchException {
		// Initialise HashMap
		HashMap<Integer, Double> sampleMap = new HashMap<Integer, Double>();
		// Read from URL
		BufferedReader br = brFromURL(samples);
		String line;
		// Read each line and extract data
		while ((line = br.readLine()) != null) {
			String[] values = line.split("\\s+");
			// If more than two pieces of info on each line, throw error
			if (values.length != 2) { 
				throw new InputMismatchException("MASS NOT K-V");
			}
			// Parse key to int
			int id = Integer.parseInt(values[0]);
			// Parse value to double
			double mass = Double.parseDouble(values[1]);
			// Add each line of input to map as key-value pair
			sampleMap.put(id, mass);
			// System.out.println("sampleMap O"); // Debugging
			// System.out.println(line); // Debugging
		}
		return sampleMap;
	}
	
	// Same structure and function as sampleMap
	static HashMap<Integer, String> locationMap(String locations) throws IOException, InputMismatchException {
		HashMap<Integer, String> locationMap = new HashMap<Integer, String>();
		
		BufferedReader br = brFromURL(locations);
		String line;

		while ((line = br.readLine()) != null) {
			String[] values = line.split("\\s+");
			if (values.length != 2) { 
				throw new InputMismatchException("LOC NOT K-V");
			}
			// Flip order of key-value from input because key is first field in HashMap but is second field in URL
			String location = values[0];
			int id = Integer.parseInt(values[1]);
			
			locationMap.put(id, location);
			// System.out.println("locationMap O"); // Debugging
		}
		return locationMap;
	}
}

