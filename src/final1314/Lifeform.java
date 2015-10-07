package final1314;

import java.util.Arrays;
import java.util.InputMismatchException;


abstract class Lifeform {
	protected Coordinates loc;
	protected String species_id;
	
	public Lifeform(Coordinates coord, String sp_id) {
		loc = coord;
		species_id = sp_id;
	}
	
	public static Lifeform constructFromLine(String line, String splitter, int length) throws Exception {
		String[] lineArray = line.trim().split(splitter);
		//System.out.println(Arrays.toString(lineArray));
		if (lineArray.length != length) {
			throw new InputMismatchException("Input does not contain exactly "+length+" fields!");
		} else {
			double latitude = Double.parseDouble(lineArray[0]);
			double longitude = Double.parseDouble(lineArray[1]);
			Coordinates coord = new Coordinates(latitude, longitude);
			String sp_id = lineArray[2];
			if (lineArray.length == 4) {
				int height = Integer.parseInt(lineArray[3]);				
				return new Plant(coord, sp_id, height);
			} else if (lineArray.length == 3) {
				return new Animal(coord, sp_id);
			}
		}
		return null;
	}

	public Coordinates getLoc() {
		return loc;
	}

	public String getSpecies_id() {
		return species_id;
	}

	@Override
	public String toString() {
		return String.format("%-20s %4s", loc, species_id);
	}


}
