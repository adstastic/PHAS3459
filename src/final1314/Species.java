package final1314;

import java.util.InputMismatchException;

abstract class Species {
	protected String id;
	protected String name;
	
	public Species(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Species constructFromLine(String line, String splitter, int length, String kingdom) throws Exception {
		String[] lineArray = line.trim().split(splitter);
		if (lineArray.length != length) {
			throw new InputMismatchException("Input does not contain exactly "+length+" fields!");
		} else {
			String sp_id = lineArray[0];
			String name = lineArray[1]+" "+lineArray[2];
			if (kingdom.equalsIgnoreCase("animal")) { 
				return new AnimalSpecies(sp_id, name); 
			} else if (kingdom.equalsIgnoreCase("plant")) { 
				return new PlantSpecies(sp_id, name); 
			} else { 
				throw new InputMismatchException("Invalid Kingdom Specifier!");
			}
		}
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("%-6s %-20s", id, name);
	}
	
}
