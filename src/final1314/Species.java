package final1314;

public class Species {
	protected String id;
	protected String name;
	
	public Species(String id, String name) {
		this.id = id;
		this.name = name;
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
