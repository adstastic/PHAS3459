package module2;
//Written by Aditya Mukherjee for PHAS 3459 Module 2

public class TestThreeVector {
// Class to test methods and fields of ThreeVector class
	
	public static void main(String[] args) {
	// Declare three vectors
	ThreeVector v1 = new ThreeVector(3,4,1);
	ThreeVector v2 = new ThreeVector(5,3,2);
	ThreeVector v3 = new ThreeVector();
	
	// Print the vectors
	System.out.println("Vector v1: "+v1+"\nUnit vector v1: "+v1.unitVector());
	System.out.println("\nVector v2: "+v2+"\nUnit vector v2: "+v2.unitVector());
	System.out.println("\nVector v3: "+v3+"\nUnit vector v3: "+v3.unitVector());
	System.out.println();
	
	// Print scalar products
	System.out.println("v1.v2 = "+ThreeVector.scalarProduct(v1, v2));
	System.out.println("v1.v3 = "+ThreeVector.scalarProduct(v1, v3));
	System.out.println();
	
	// Print vector products
	System.out.println("v1 x v2 = "+ThreeVector.vectorProduct(v1, v2));
	System.out.println("v1 x v2 = "+ThreeVector.vectorProduct(v1, v2));
	System.out.println();
	
	// Calculate angles and assign to variables
	double angle1 = ThreeVector.angle(v1, v2);
	double angle2 = ThreeVector.angle(v1, v3);
	// If statement to print just "NaN" if angle is NaN or print 'angle+"radians"' if angle is not NaN
	System.out.println("Angle between v1 and v3 = "+(Double.isNaN(angle1) ? angle1 : angle1+" radians"));
	System.out.println("Angle between v1 and v3 = "+(Double.isNaN(angle2) ? angle2 : angle2+" radians"));
	System.out.println();
	
	// Describing what happens when toString() method is removed from ThreeVector
	System.out.println("When the toString() method is removed from ThreeVector, all the print statements output the memory location of the objects specified.");
	System.out.println("For example, the vector (3,4,1) is printed as 'module2.ThreeVector@26e56328' instead of '3.0i, 4.0j, 1.0k'.");
	}

}
