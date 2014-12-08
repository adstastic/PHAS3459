package final1213;

public class Bin {
	final int e_low;
	final int e_high;
	final double n_background;
	private double n_candidate;
	
	
	public Bin(int low, int high, double N) {
		e_low = low;
		e_high = high;
		n_background = N;
	}
	
	public void addCandidate() {
		n_candidate += 1;
	}

	public double getN_candidate() {
		return n_candidate;
	}
	
}
