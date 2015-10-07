package module6;
// Written by Aditya Mukherjee for PHAS 3549 Module 6

// Holds theory object of quadratic function
public class QuadraticTheory implements Theory {
	// instance variables
	protected double a;
	protected double b;
	protected double c;
	
	// constructor: a,b,c used as ax^2 +bx + c
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// Implement methods from Theory interface
	public double y(double x) {
		return a*Math.pow(x,2)+ b*x + c;
	}
	
	public String toString() {
		return a+"x^2 "+b+"x "+c;
	}

}
