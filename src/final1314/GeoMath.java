package final1314;

public class GeoMath {
	static final double R = 6371;
	
	public static double distance(Coordinates a, Coordinates b) {
		double h = h(a, b);
		double d = 2*R*Math.asin(Math.sqrt(h));
		return d;
	}
	
	public static double h(Coordinates a, Coordinates b) {
		double p1 = Math.toRadians(a.latitude);
		double p2 = Math.toRadians(b.latitude);
		double l1 = Math.toRadians(a.longitude);
		double l2 = Math.toRadians(b.longitude);
		double h = haversin(p2-p1) + Math.cos(p1)*Math.cos(p2)*haversin(l2-l1);
		return h;
	}
	
	public static double haversin(double theta) {
		double haversine = (1-Math.cos(theta))/2;
		return haversine;
	}
}
