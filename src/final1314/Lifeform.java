package final1314;

public class Lifeform {
	protected double latitude;
	protected double longitude;
	protected Species species;
	
	public Lifeform(double la, double lo, Species sp) {
		latitude = la;
		longitude = lo;
		species = sp;
	}
	
	public Lifeform() {}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Species getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return "latitude=" + latitude + ", longitude=" + longitude
				+ ", species=" + species;
	}

}
