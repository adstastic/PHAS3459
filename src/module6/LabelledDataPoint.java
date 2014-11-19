package module6;
// Written by Aditya Mukherjee for PHAS 3549 Module 6

// Holds datapoint with 3 values and label
public class LabelledDataPoint extends DataPoint {
	// Additional instance variable specific to this class
	private String label;
	
	// Constructor
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x,y,ey);
		this.label = label;
	}
	
	// Getter for label 
	public String getLabel() {
		return label;
	}

	// Override superclass method
	@Override
	public String toString() {
		return label+": x = "+x+", y = "+y+" +- "+ey;
	}
	
}
