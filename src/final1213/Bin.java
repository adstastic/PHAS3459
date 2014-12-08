package final1213;

import java.util.ArrayList;
import java.util.List;

public class Bin {
	final int e_low;
	final int e_high;
	final double n_background;
	private double n_candidate;
	private List<Double> candidateList;
	
	
	public Bin(int low, int high, double N) {
		e_low = low;
		e_high = high;
		n_background = N;
		candidateList = new ArrayList<Double>();
	}
	
	public void addCandidate(CandidateEvent ce) {
		n_candidate += 1;
		candidateList.add(ce.event_energy);
	}

	public double getN_candidate() {
		return n_candidate;
	}

	@Override
	public String toString() {
		return "Bin [e_low=" + e_low + ", e_high=" + e_high + ", n_background="
				+ n_background + ", n_candidate=" + n_candidate + "]";
	}
	
}
