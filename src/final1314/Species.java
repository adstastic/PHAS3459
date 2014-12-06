package final1314;

import java.util.InputMismatchException;

public class Species {
	protected String id;
	protected String name;
	
	public Species(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Species constructFromLine(String line, String splitter, int length) throws Exception {
		String[] lineArray = line.trim().split(splitter);
		if (lineArray.length != length) {
			throw new InputMismatchException("Input does not contain exactly "+length+" fields!");
		} else {
			String sp_id = lineArray[0];
			String name = lineArray[1];
			return new Species(sp_id, name);
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
		return "id=" + id + ", name=" + name;
	}
	
}
