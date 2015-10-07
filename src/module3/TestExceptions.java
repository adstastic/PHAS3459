package module3;
// Written by Aditya Mukherjee for PHAS 3459 Module 3

public class TestExceptions {
// Class to test exception handling
	
	public static void main(String[] args) throws IllegalArgumentException, ArithmeticException {
		// Instantiate new complex number objects: c = 1 + i; d = 0
		Complex c = new Complex(1,1);
		Complex d = Complex.ZERO;
		// Instantiate new three dimensional vector objects
		ThreeVector v = new ThreeVector();
		ThreeVector x = new ThreeVector(1,2,3);
		
		// Try dividing by 0
		try {
			Complex cd = Complex.divide(c, d);
		} catch (Exception e) {
			// Print exception to console
			System.out.println(e);
			// Print explanation of error
			System.out.println("You tried to divide by 0!");
		}
		
		// Try normalising 0 vector
		try {
			Complex cn = d.normalised();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to normalise a complex number with a modulus of 0!");
		}
		
		// Try computing unit vector of 0 vector
		try {
			ThreeVector vu = v.unitVector();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to find the unit vector of the 0 vector. This requires dividing by 0!");
		}
		
		// Angle with 0 vector
		try {
			double angle = ThreeVector.angle(v, x);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to find the angle between a vector and the 0 vector. This requires dividing by 0!");
		}
	
		// Attempting to set negative mass and drag coefficient
		try {
			// Initialise new FallingParticle with mass and drag coefficient of -1
			FallingParticle p = new FallingParticle(-1, -1);
			// Catch exception and print explanation to console 
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			if (e.getMessage().equals("NEG MASS")) {
					System.out.println("Mass cannot be negative!");
			} else if (e.getMessage().equals("NEG DRAG")) {
					System.out.println("Drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG MASS DRAG")) {
					System.out.println("Mass and drag coefficient cannot be negative!");
			}
		
		// Attempting to set negative height
		try {
			// Initialise new FallingParticle with mass and drag coefficient of 1
			FallingParticle p = new FallingParticle(1, 1);
			// Set height to -10
			p.setZ(-10);
			// Catch exception from FallingParticle constructor and print exception with relevant explanation to console 
		} catch (IllegalArgumentException e1) {
			System.out.println(e);
			if (e.getMessage().equals("NEG MASS")) {
					System.out.println("Mass cannot be negative!");
			} else if (e.getMessage().equals("NEG DRAG")) {
					System.out.println("Drag coefficient cannot be negative!");
			} else if (e.getMessage().equals("NEG MASS DRAG")) {
					System.out.println("Mass and drag coefficient cannot be negative!");
			}
			// Catch exception from setting height and print exception with relevant explanation to console
		} catch (ArithmeticException e2) {
			System.out.println(e2);
			if (e2.getMessage().equals("NEG HEIGHT")){
				System.out.println("Height cannot be negative!");
			} 
		}
	}

}
}
