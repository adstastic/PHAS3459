package module6;

public class QuadraticTheory implements Theory {
	protected double a;
	protected double b;
	protected double c;
	
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public double y(double x) {
		return a*Math.pow(x,2)+ b*x + c;
	}

	@Override
	public String toString() {
		return a+"x^2 "+b+"x "+c;
	}

}
