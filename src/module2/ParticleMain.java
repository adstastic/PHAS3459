package module2;
//Written by Aditya Mukherjee for PHAS 3459 Module 2

public class ParticleMain {
// Class to run simulations of falling particle
	
	public static void main(String[] args) {
		// New instance of FallingParticle
		FallingParticle particle = new FallingParticle(5.3, 2.1);
		
		// Array of time intervals to be used
		double[] timeIntervals = {0.5, 0.1, 0.01, 0.001, 0.0001};
		
		// Iterating through elements in timeIntervals array and calling running particle drop simulation
		for (double element : timeIntervals) {
			// Setting Z inside loop because must reset after each simulation as simulation ends with z = 0 
			particle.setZ(10);
			// element here refers to element in timeIntervals array 
			particle.drop(element);
			System.out.println();
		}
		
		// Explanation of differences 
		System.out.println("As the time interval is reduced, the drop simulation runs at higher temporal resolution.");
		System.out.println("This means that doTimeStep() alters the values of a, v, z by less so drop() runs more loops.");
		System.out.println("This results in more accurate values for final velocity and fall time.");
		System.out.println("For example, with a time interval of 0.5, the position and velocity of the particle are only sampled every 0.5 seconds of simulation time.");
		System.out.println("If the height reaches 0 in the middle of these samplings, the next sample after z = 0 will be the final values of all the variables");
		System.out.println("As can be seen above, although the 'true' time is around 2.36s, when the time interval is 0.5s, the fall time is given as 2.5s.");
		System.out.println("By reducing the sample time and sampling more often, we are able get more accurate final values of all the variables.");
	}

}
