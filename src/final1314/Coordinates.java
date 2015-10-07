package final1314;

public class Coordinates {
	protected double latitude;
	protected double longitude;

	public Coordinates(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s", latitude, longitude);
	}
	
	

}
