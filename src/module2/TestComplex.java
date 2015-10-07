package module2;
// Written by Aditya Mukherjee for PHAS 3459 Module 2

public class TestComplex {
// Class to test methods and fields of Complex class
	
	public static void main(String[] args) {
		// Instantiate 2 complex numbers
		Complex c1 = new Complex(-1,2);
		Complex c2 = new Complex(2,1);
		
		// Perform operations
		System.out.println("Product of c1 and c2: "+ Complex.multiply(c1, c2));
		System.out.println("\nRatio of c1 and c2: "+ Complex.divide(c1, c2));
		System.out.println("\nProduct of c1 and i: "+ Complex.multiply(c1, Complex.I));
		System.out.println("\nRatio of c1 and 0: "+ Complex.divide(c1, Complex.ZERO));
		System.out.println("\nProduct of c1 and c2*: "+ Complex.multiply(c1, c2.conjugate()));
		System.out.println("\nProduct of c2 and c2*: "+ Complex.multiply(c2, c2.conjugate()));
	}

}
