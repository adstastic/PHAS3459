package module2;

public class ThreeVector {
	// Components of vector
	private double xc; private double yc; private double zc;
	// Default constructor
	public ThreeVector() {}
	// Constructor with arguments
	public ThreeVector(double x, double y, double z)	{
		xc=x;
		yc=y;
		zc=z;
	}
	
	// Setter 
	void setVector(double x, double y, double z)	{
		x = xc;
		y = yc;
		z = zc;
	}
	
	// Getters for individual components of the vector
	
	double getx()	{
		return xc;
	}
	
	double gety()	{
		return yc;
	}
	
	double getz()	{
		return zc;
	}
	
	// toString method to print vector
	public String toString()	{
		return xc+"i, "+yc+"j, "+zc+"k";
	}
	
	// Magnitude
	public double magnitude()	{
		double magnitude = Math.sqrt(Math.pow(xc,2)+Math.pow(yc,2)+Math.pow(zc,2));
		return magnitude;
	}
	
	// Unit vector (vector of magnitude 1 pointing in same direction as original)
	public ThreeVector unitVector()	{
		double magnitude = this.magnitude();
		ThreeVector unitVector = new ThreeVector(xc/magnitude, yc/magnitude, zc/magnitude);
		return unitVector;
	}
	
	// The following static methods perform vector operations on two vectors

	// Scalar product
	public static double scalarProduct(ThreeVector a, ThreeVector b)	{
		double scalarProduct = a.xc*b.xc + a.yc*b.yc + a.zc*b.zc;
		return scalarProduct;
	}
	
	// Vector product 
	public static ThreeVector vectorProduct(ThreeVector a, ThreeVector b)	{
		double term1 = a.yc*b.zc - a.zc*b.yc;
		double term2 = a.zc*b.xc - a.xc*b.zc;
		double term3 = a.xc*b.yc - a.yc*b.xc;
		ThreeVector vectorProduct = new ThreeVector(term1, term2, term3);
		return vectorProduct;
	}
	
	// Vector addition
	public static ThreeVector add(ThreeVector a, ThreeVector b)	{
		ThreeVector add = new ThreeVector(a.xc+b.xc, a.yc+b.yc, a.zc+b.zc);
		return add;
	}
	
	// Angle between vectors
	public static double angle(ThreeVector a, ThreeVector b)	{
		double maga = a.magnitude();
		double magb = b.magnitude();
		double dotProduct = scalarProduct(a, b);
		double angle = Math.acos(dotProduct/(maga*magb));
		return angle;
	}
	
	// Non-static versions of the static methods above
	
	public double scalarProduct(ThreeVector a)	{
		return scalarProduct(this, a);
	}
	
	public ThreeVector vectorProduct(ThreeVector a)	{
		return vectorProduct(this, a);
	}
	
	public ThreeVector add(ThreeVector a)	{
		return add(this, a);
	}
	
	public double angle(ThreeVector a)	{
		return angle(this, a);
	}
}
