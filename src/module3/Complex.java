package module3;
//Written by Aditya Mukherjee for PHAS 3459 Module 3

public class Complex {
	// Instance variables - real and imaginary parts of complex number
	private double re; private double im;
	
	// Class variables - complex numbers equalling: 1, 0, i
	public static Complex ONE = new Complex(1,0);
	public static Complex ZERO = new Complex();
	public static Complex I = new Complex(0,1);
	
	// Constructors - default and accepting arguments of real and imaginary components
	public Complex() {}
	public Complex(double real, double imag) { re = real; im = imag; }
	
	// Non-static methods operating on a single complex number
	// Real component
	public double real() {
		return re;
	}
	
	// Imaginary component
	public double imag() {
		return im;
	}
	
	// Modulus
	public double modulus() {
		double mod = Math.sqrt(Math.pow(re, 2) + Math.pow(im,2));
		return mod;
	}
	
	// Argument (angle going anticlockwise from Real axis)
	public double angle() {
		double angle = Math.atan(im/re);
		return angle;
	}
	
	// Complex conjugate
	public Complex conjugate() {
		Complex conjugate = new Complex(re, -im);
		return conjugate;
	}
	
	// Normalised complex number (has modulus of 1)
	public Complex normalised() throws Exception {
		double mod = this.modulus();
		Complex normalised = new Complex(re/mod, im/mod);
		// If modulus of vector is 0, throw error
		if (mod == 0) {
			throw new IllegalArgumentException("COMPLEX NORM DIV 0");
		}
		else {
			return normalised;
		}
	}
	
	// Check if current complex number is same as the one passed to this function
	public boolean equals(Complex c) {
		if (this.re == c.re && this.im == c.im) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	// toString() method to enable printing
	public String toString() {
		if (Double.isNaN(re) && Double.isNaN(im)) {
			return "Undefined"; 
		}
		else {
			return "z = "+re+" + "+im+"i";
		}
	}
	
	// Initialise complex number from modulus and argument (magnitude and angle)
	public Complex setFromModulusAngle(double mag, double ang) {
		double re = mag*Math.cos(ang);
		double im = mag*Math.sin(ang);
		Complex complex = new Complex(re, im);
		return complex;
	}
	
	// Static methods operating on two complex numbers
	// Complex addition
	public static Complex add(Complex z1, Complex z2) {
		double a = z1.real(); double b = z1.imag(); 
		double c = z2.real(); double d = z2.imag();
		Complex add = new Complex(a+c, b+d);
		return add;
	}
	
	// Complex subtraction
	public static Complex subtract(Complex z1, Complex z2) {
		double a = z1.real(); double b = z1.imag(); 
		double c = z2.real(); double d = z2.imag();
		Complex subtract = new Complex(a-c, b-d);
		return subtract;
	}
	
	// Complex multiplication
	public static Complex multiply(Complex z1, Complex z2) {
		double a = z1.real(); double b = z1.imag(); 
		double c = z2.real(); double d = z2.imag();
		Complex multiply = new Complex(a*c - b*d, b*c + a*d);
		return multiply;
	}
	
	// Complex division
	public static Complex divide(Complex z1, Complex z2) throws Exception {
		double a = z1.real(); double b = z1.imag(); 
		double c = z2.real(); double d = z2.imag();
		Complex divide = new Complex((a*c + b*d)/(Math.pow(c, 2)+Math.pow(d, 2)) , (b*c + a*d)/(Math.pow(c, 2)+Math.pow(d, 2)));
		// If real or imaginary part of denominator is 0, throw error
		if (c == 0 || d == 0) {
			throw new IllegalArgumentException("COMPLEX DIV 0");
		}
		else {
			return divide;
		}
	}
	
}
