package module3;
// Written by Aditya Mukherjee for PHAS 3459 Module 3

public class TestExceptions {
// Class to test exceptions
	
	public static void main(String[] args) throws Exception {
		// Instantiate new complex number objects: c = 1 + i; d = 0
		Complex c = new Complex(1,1);
		Complex d = Complex.ZERO;
		// Instantiate new three dimensional vector object
		ThreeVector v = new ThreeVector();
		
		try {
			// Try dividing by 0
			Complex cd = Complex.divide(c, d);
		} catch (Exception e) {
			// Print exception to console
			System.out.println(e);
			// Print explanation of error
			System.out.println("You tried to divide by 0!");
		}
		
		try {
			// Try normalising 0 vector
			Complex cn = d.normalised();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to normalise a complex number with a modulus of 0!");
		}
		
		try {
			// Try computing unit vector of 0 vector
			ThreeVector vu = v.unitVector();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to find the unit vector of the 0 vector. This requires dividing by 0!");
		}
		
		try {
			// Initialise new FallingParticle with mass and drag coefficient of -1
			FallingParticle p = new FallingParticle(-1, -1);
			// Catch exception and print relevant explanation to console depending on error message
		} catch (Exception e) {
			System.out.println(e);
			if (e.getMessage().equals("NEG MASS")) {
				System.out.println("Mass cannot be negative!");
			} else if (e.getMessage().equals("NEG DRAG")) {
				System.out.println("Drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG MASS DRAG")) {
				System.out.println("Mass and drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG HEIGHT")){
				System.out.println("Height cannot be negative!");
			}
		}
		
		try {
			// Initialise falling particle with valid values for mass and drag coefficient 
			FallingParticle p = new FallingParticle(1,7);
			// Set height to -1
			p.setZ(-1);
			// Catch exceptions and print relevant explanation to console depending on error message
		} catch (Exception e) {
			System.out.println(e);
			if (e.getMessage().equals("NEG MASS")) {
				System.out.println("Mass cannot be negative!");
			} else if (e.getMessage().equals("NEG DRAG")) {
				System.out.println("Drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG MASS DRAG")) {
				System.out.println("Mass and drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG HEIGHT")){
				System.out.println("Height cannot be negative!");
			}
		}
	}

}
