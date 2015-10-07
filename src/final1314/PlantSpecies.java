package final1314;

public class PlantSpecies extends Species {
	protected double totalHeight;
	protected int number;
	
	public PlantSpecies(String id, String name) {
		super(id, name);
		this.number = 0;
	}
	
	public void addSpecimen(Plant plant) {
		this.number += 1;
		this.totalHeight += plant.height;
	}
	
	public double meanHeight() {
		double mean = totalHeight/number;
		return mean;
	}
	
	public String toString() {
		return String.format("%-26s %5s", super.toString(), meanHeight());
	}
	
}
