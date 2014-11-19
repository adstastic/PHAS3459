package module6;
// Written by Aditya Mukherjee for PHAS 3549 Module 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Tests datapoint and labelleddatapoint classes
public class TestDataPoints {

	public static void main(String[] args) {
		try {
			// New collection holding data
			Collection datapoints = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			// Using iterator to iterate through datapoints collection
			Iterator dpItr = datapoints.iterator();
			while (dpItr.hasNext()) {
				Object dataPoint = dpItr.next();
				// print datapoint
				System.out.println(dataPoint);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static Collection<DataPoint> dataFromURL(String url) throws IOException, IllegalArgumentException {
		// Initialise ArrayList
		Collection<DataPoint> dataSet = new ArrayList<DataPoint>(); 
		// Open URL
		URL u = new URL(url);
		// Open input stream
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		// Read line by line
		String line;
		// Iterate over each line
		while ((line = br.readLine()) != null) {
			// Split line by whitespace to create String array 
			String[] values = line.split("\\s+"); // Regex for whitespace
			// If number of objects in split line are not 3 or 4, they cannot be accepted as DataPoint takes 3 inputs and LabelledDataPoint takes 4				
			// if only 3 elements, no label present
			if (values.length == 3) {
				// Initialise new double array to hold String array 
				double[] numbers = new double[3]; 
				// Iterate over all elements in each line
				for (int i=0; i<values.length; i++) {
					// System.out.println(8);
					numbers[i] = Double.parseDouble(values[i]);
				}
				// Add each line to dataSet as new DataPoint
				dataSet.add(new DataPoint(numbers[0],numbers[1], numbers[2]));
				// if 4 elements, label is present
			} else if (values.length == 4) {
				double[] numbers = new double[3]; 
				// Iterate over first 3 elements in each line
				for (int i=0; i<values.length-1; i++) {
					numbers[i] = Double.parseDouble(values[i]);
				}
				// 4th element in input string is label
				String label = values[3];
				// Add each line to dataSet as new LabelledDataPoint
				dataSet.add(new LabelledDataPoint(numbers[0],numbers[1], numbers[2], label));
			} else {
				// if input is not of valid size, throw exception
				throw new IllegalArgumentException("Input contains more than 3 or 4 values per data point."); 
			}
		}
		return dataSet;
	}

}
