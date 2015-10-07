package module6;
//Written by Aditya Mukherjee for PHAS 3549 Module 6

//Holds theory object of exponential function
public class PowerLawTheory implements Theory {
	// instance variable 
	protected double n;
	
	// constructor: n used as y = x^n
	public PowerLawTheory(double n) {
		this.n = n;
	}

	// Implement methods from Theory interface
	public double y(double x) {
		return Math.pow(x,n);
	}

	public String toString() {
		return "x^"+n;
	}
	
}
