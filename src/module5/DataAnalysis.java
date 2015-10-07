package module5;
import java.io.*;
import java.net.*;
import java.util.*;
// Written by Aditya Mukherjee for PHAS 3459 Module 5

// Read experimental data from URL, compare with theoretical data
public class DataAnalysis {
	
	public static void main(String[] args) {
		// Initialise new ArrayList to hold data
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();
		
		try {
			// Read data from URL
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			
			// Calculate two chi squared values for the two theoretical functions
			double f1 = goodnessOfFit(new Theory(2), data);
			double f2 = goodnessOfFit(new Theory(4), data);
			
			// Using printf instead of println in order to format output
			System.out.printf("Chi-squared value for y=x^2: "+"%f\n",f1);
			// f2 was printing in scientific notation (2.7455501702E10) and could easily be misread to be smaller than f1 
			System.out.printf("Chi-squared value for y=x^4: "+"%f\n",f2);
			// Inline if statement to check which chi-squared value is bigger
			System.out.println((f1>f2 ? "y=x^2" : "y=x^4")+" is a better fit for the measured data.");
			//System.out.println((long) f2); // Debugging
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Build ArrayList of DataPoints from URL
	static ArrayList<DataPoint> dataFromURL(String url) throws IOException, IllegalArgumentException {
		// Initialise ArrayList
		ArrayList<DataPoint> dataSet = new ArrayList<DataPoint>(); 
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
			// If number of objects in split line are not 3, they cannot be accepted as DataPoint takes 3 inputs
			if (values.length != 3) { 
				throw new IllegalArgumentException("Input contains more than 3 values per data point."); 
			} 
			// Initialise new double array to hold String array 
			double[] numbers = new double[3]; 
			// Iterate over all elements in each line
			for (int i=0; i<values.length; i++) {
				// System.out.println(8);
				numbers[i] = Double.parseDouble(values[i]);
			}
			// Add each line to dataSet as new DataPoint
			dataSet.add(new DataPoint(numbers[0],numbers[1], numbers[2]));
		}
		return dataSet;
	}
	
	// Calculates chi-squared goodness of fit statistic 
	static double goodnessOfFit(Theory f, ArrayList<DataPoint> data) {
		// Initialise variable
		double chiSq = 0;
		// Iterate over all data points in ArrayList
		for (DataPoint p : data) {
			// Theoretical y
			double fY = f.y(p.getX());
			// Measured y
			double mY = p.getY();
			// top and bottom terms of chi-squared fraction
			double dY = Math.pow((mY-fY),2);
			double eySq = 1/(Math.pow(p.getEY(),2));
			// Sum over all data points
			chiSq += dY/eySq;
		}
		return chiSq;
	}
}
