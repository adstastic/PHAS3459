package module6;
//Written by Aditya Mukherjee for PHAS 3549 Module 6

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Perform analysis on data points from URL, calculate best theory to fit data
public class DataAnalysis {

	public static void main(String[] args) {
		try {
			// Import data from URL
			Collection data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			// Theories to be tested against data
			Theory f1 = new PowerLawTheory(2);
			Theory f2 = new PowerLawTheory(2.05);
			Theory f3 = new QuadraticTheory(1, 10, 0);
			//Theory f4 = new PowerLawTheory(2.055); // testing bestTheory function
			// Collection of theories
			Collection<Theory> theories = new ArrayList<Theory>(Arrays.asList(f1,f2,f3/*,f4*/));
			// Goodness of fit calculation using chi-squared statistic
			GoodnessOfFitCalculator gof = new ChiSquared();
			// Calculate best theory
			Theory bestTheory = bestTheory(data, theories, gof);
			System.out.println("The best theory is: "+bestTheory);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// calculates best theory to fit data using chi-squared statistic to measure goodness of fit 
	private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		// arbitrary boolean declared to be used later when a condition is required to be true
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            // arbitrary boolean used to invoke if-statement
            if (first) {
            	// set variables to current theory and current goodness of fit
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
                // if best chi-squared statistic smaller than current chi-squared, replace best theory and gof with current ones
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }

}
