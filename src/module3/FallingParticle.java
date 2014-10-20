package module3;
//Written by Aditya Mukherjee for PHAS 3459 Module 2

public class FallingParticle {
	// Class variables
	private static final double g = 9.81;
	
	// Instance variables
	private final double m; 
	private final double d;
	private double t;
	private double z;
	private double v;
	
	// Constructor, accepts mass and drag coefficient of particle as arguments, default height of drop = 1 m
	public FallingParticle(double mass, double dragcoeff) throws Exception { 
		z = 1; 
		if (mass < 0 && dragcoeff >= 0) {
			throw new IllegalArgumentException("NEG MASS");
		} else if (dragcoeff < 0 && mass >= 0) {
			throw new IllegalArgumentException("NEG DRAG");
		} else if (mass < 0 || dragcoeff < 0) {
			throw new IllegalArgumentException("NEG MASS DRAG");
		} else {
			m = mass; d = dragcoeff; 
		}
	}
	
	// Setters
	public void setZ(double height) { z = height; } 
	public void setV(double velocity) { v = velocity; } 
	
	// Getters
	public double getZ() { return z; }	
	public double getV() { return v; }
	public double getT() { return t; }
	
	// Time step function
	public void doTimeStep(double deltaT) {
		double a = (d*Math.pow(v, 2)/m) - g;
		// Update velocity, position, fall time (simulation time)
		this.v = v+a*deltaT;
		this.z = z+v*deltaT;
		this.t = t+deltaT;
	}
	
	// Falling particle simulation
	public void drop(double deltaT) {
		// loop to run doTimeStep() until height reaches 0
		while (z > 0.0) {
			doTimeStep(deltaT);
		}
		// Print final values of time elapsed, velocity, time interval
		System.out.println("Time interval: "+deltaT);
		System.out.println("Fall time: "+this.t+" s");
		System.out.println("Final velocity: "+this.v+" ms^-1");
		
		reset();
	}
	
	public void reset() {
		this.v = this.t = 0;
	}
}
