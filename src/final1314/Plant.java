package final1314;

public class Plant extends Lifeform {
	protected double height;

	public Plant(Coordinates coord, String sp_id, int height) {
		super(coord, sp_id);
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	
	public double getHeight() {
		return height;
	}

	public String toString() {
		return String.format("%-26s %9s", super.toString(), height);
	}

}
