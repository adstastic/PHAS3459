package module1;
//Written by Aditya Mukherjee for the PHAS3459 course

public class VectorMethods {
// This class investigates Java methods by creating functions for dot product, magnitude, angle between two vectors
	
	public static void main(String[] args) {
		//Create instance of class VectorMethods
		VectorMethods vm = new VectorMethods();
		
		// Calculate angle between two vectors
		double angle1 = vm.angle(6,5,1, 2,4,3);
		double angle2 = vm.angle(1,4,1, 0,0,0);
		
		System.out.println("Angle between (6,5,1) and (2,4,3): "+angle1+" radians");
		System.out.println("Angle between (1,4,1) and (0,0,0): "+angle2);
		System.out.println("Angle between two vectors A and B: arccos((A.B)/(|A|*|B|))");
		System.out.println("The magnitude of vector (0,0,0) is 0 thus in calculating the angle here we attempt to divide by 0.");
		System.out.println("The result of dividing by 0 is undefined hence the output is 'NaN' (not a number).");
	}
	
	// Method to calculate dot product of two 3D vectors, accepts  arguments: x,y,z coordinates of each vector
	public double dotProduct(double x1, double y1, double z1, double x2, double y2, double z2)	{
		// Dot product of vectors (a,b,c),(x,y,z) = ax + by + cz
		double x = x1*x2;
		double y = y1*y2;
		double z = z1*z2;
		
		return x + y + z;
	}
	
	// Method calculate magnitude of a 3D vector, accepts arguments: x,y,z coordinates of vector
	public double magnitude(double x, double y, double z)	{
		/* 
		 * Magnitude of vector (x,y,z) = (x^2+y^2+z^2)^(1/2)
		 * sqrt, pow are functions in java.lang.Math library
		 * sqrt = square root, pow = power; power(x, 2) raises variable x to power of 2 
		 */ 
		double magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z,2));
		
		return magnitude;
	}
	
	// Method to calculate angle between two 3D vectors, accepts arguments x,y,z coordinates of vector
	public double angle(double x1, double y1, double z1, double x2, double y2, double z2)	{
		// Calculate dot product
		double dotProduct = dotProduct(x1, y1, z1, x2, y2, z2);
		
		// Calculate magnitude
		double magnitudeA = magnitude(x1, y1, z1);
		double magnitudeB = magnitude(x2, y2, z2);
		
		// Angle between two vectors a, b = (a.b)/(|a|*|b|)
		// Math.acos is arccos (inverse cosine) function
		double angle = Math.acos(dotProduct/(magnitudeA*magnitudeB));
		return angle;
	}
}
