package module6;
// Written by Aditya Mukherjee for PHAS 3549 Module 5

// Holds a point of data with 3 values
public class DataPoint {
	
	// Instance variables
	protected double x;
	protected double y;
	protected double ey;
	
	// Constructor
	public DataPoint(double x, double y, double ey) {this.x = x; this.y = y; this.ey = ey;}
	
	// Getters
	public double getX() {return x;}
	public double getY() {return y;}
	public double getEY() {return ey;}
	
	// To allow printing
	public String toString() {
		return "x = "+x+", y = "+y+" +- "+ey;
	}
}
