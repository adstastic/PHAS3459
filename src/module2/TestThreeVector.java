package module2;

public class TestThreeVector {
// Class to test methods of ThreeVector class
	
	public static void main(String[] args) {
	// Declare three vectors
	ThreeVector v1 = new ThreeVector(3,4,1);
	ThreeVector v2 = new ThreeVector(5,3,2);
	ThreeVector v3 = new ThreeVector();
	
	// Print their values
	System.out.println("Vector v1: "+v1);
	System.out.println("Vector v2: "+v2);
	System.out.println("Vector v3: "+v3);
	System.out.println();
	
	// Print scalar products
	System.out.println("v1.v2 = "+ThreeVector.scalarProduct(v1, v2));
	System.out.println("v1.v3 = "+ThreeVector.scalarProduct(v1, v3));
	System.out.println();
	
	// Print vector products
	System.out.println("v1 x v2 = "+ThreeVector.vectorProduct(v1, v2));
	System.out.println("v1 x v2 = "+ThreeVector.vectorProduct(v1, v2));
	System.out.println();
	
	// Print angles
	System.out.println("Angle between v1 and v2 = "+ThreeVector.angle(v1, v2)+" radians");
	System.out.println("Angle between v1 and v3 = "+ThreeVector.angle(v1, v3)+" radians");
	System.out.println();
	
	// Describing what happens when toString() method is removed from ThreeVector
	System.out.println("When the toString() method is removed from ThreeVector, all the print statements output the memory location of the objects specified.");
	System.out.println("For example, the vector (3,4,1) is printed as 'module2.ThreeVector@26e56328' instead of '3.0,4.0,1.0'.");
	}

}
