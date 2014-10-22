package module3;
// Writtn by Aditya Mukherjee for PHAS 3459 Module 3
public class TestExceptions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Complex c = new Complex();
		Complex d = new Complex();
		ThreeVector v = new ThreeVector();
		
		try {
			Complex cd = Complex.divide(c, d);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to divide by 0!");
		}
		
		try {
			Complex cn = c.normalised();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to normalise a complex number with a modulus of 0!");
		}
		
		try {
			ThreeVector vu = v.unitVector();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("You tried to find the unit vector of the 0 vector. This requires dividing by 0!");
		}
		
		try {
			FallingParticle p = new FallingParticle(-1, -1);
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
			FallingParticle p = new FallingParticle(0,0);
			p.setZ(-1);
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
