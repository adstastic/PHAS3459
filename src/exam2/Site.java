package exam2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Stores port name and ID
 * @author Aditya Mukherjee
 * 
 */
public class Site {
	final String ID;
	final String name;
	private Collection<SeaLevel> records =  new ArrayList<SeaLevel>();
	
	public Site(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	public Collection<SeaLevel> getRecords() {
		return records;
	}
	
	public void addSeaLevel(SeaLevel s) {
		records.add(s);
	}

	@Override
	public String toString() {
		return "Site [ID=" + ID + ", name=" + name + ", records=" + records
				+ "]";
	}

}
