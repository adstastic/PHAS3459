package final1213;

import java.util.ArrayList;
import java.util.List;

public class Bin {
	final double e_low;
	final double e_high;
	private double n_background;
	private double n_candidate;
	private List<Double> candidateList;
	
	
	public Bin(double low, double high, double N) {
		e_low = low;
		e_high = high;
		n_background = N;
		n_candidate = 0;
		candidateList = new ArrayList<Double>();
	}
	
	public void addCandidate(CandidateEvent ce) {
		n_candidate += 1;
		candidateList.add(ce.event_energy);
	}
	
	public void addNCandidates(double n) {
		n_candidate += n;
	}

	public double getN_candidate() {
		return n_candidate;
	}
	
	public void addBackground(double n) {
		n_background += n;
	}
	
	public double getNBackground() {
		return n_background;
	}
	
	public boolean containsEnergy(double e) {
		if (e >= e_low & e < e_high) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Bin [e_low=" + e_low + ", e_high=" + e_high + ", n_background="
				+ n_background + ", n_candidate=" + n_candidate + "]";
	}
	
}
