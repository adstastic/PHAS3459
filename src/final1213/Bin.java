package final1213;

public class Bin {
	protected int e_low;
	protected int e_high;
	protected double n_background;
	protected double n_candidate;
	
	public Bin(int low, int high, double N) {
		e_low = low;
		e_high = high;
		n_background = N;
	}
	
	public void addCandidate() {
		n_candidate += 1;
	}
	
}
