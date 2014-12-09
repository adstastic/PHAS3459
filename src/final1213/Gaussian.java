package final1213;
// Written by Aditya Mukherjee for PHAS 3459 Module 5

// Defines a function
public class Gaussian extends Theory {
	
	// Instance variable
	final double N;
	final double sigma_H;
	private double mH;
	
	// Constructor
	public Gaussian(double n, double sigmaH) { 
		N = n;
		sigma_H = sigmaH;
		mH = 0;
	}
	
	// Function
	public double y (double E) {
		double y = N/(sigma_H*Math.sqrt(2*Math.PI))*Math.exp(-(Math.pow((E-mH),2))/(2*Math.pow(sigma_H, 2)));
		return y;
	}

	public void setmH(double mH) {
		this.mH = mH;
	}
	@Override
	public String toString() {
		return "Gaussian [N=" + N + ", sigma_H=" + sigma_H + "]";
	}
}
