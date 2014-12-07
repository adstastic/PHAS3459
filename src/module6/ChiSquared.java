package module6;
//Written by Aditya Mukherjee for PHAS 3549 Module 6

import java.util.Collection;

// Calculates goodness of fit using chi-squared statistic
public class ChiSquared implements GoodnessOfFitCalculator {
	
	public double goodnessOfFit(Collection<DataPoint> data, Theory f) {
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
