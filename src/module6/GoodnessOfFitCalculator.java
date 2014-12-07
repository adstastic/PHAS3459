package module6;
//Written by Aditya Mukherjee for PHAS 3549 Module 6
import java.util.Collection;

// calculates goodness of fit for data against a theory
public interface GoodnessOfFitCalculator {
	
	double goodnessOfFit(Collection<DataPoint> data, Theory theory); 
	
}
