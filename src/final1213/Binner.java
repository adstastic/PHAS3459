package final1213;

import java.util.*;

public class Binner implements BInterface {

	@Override
	public HashMap<Double, HashMap<Double, Bin>> binEvents(HashMap<Double, Bin> bins, Gaussian dist, double m_low, double m_high, double step) {
		HashMap<Double, HashMap<Double, Bin>> higgsListBinList = new HashMap<Double, HashMap<Double, Bin>>();
		HashMap<Double, Bin> hBins = bins; 
		double m = m_low;
		while (m <= m_high) {
			for (Bin b : hBins.values()) {
				b.addNCandidates(nEvents(b, dist, m));
			}
		m += step;
		higgsListBinList.put(m, hBins);
		}
		return higgsListBinList;
	}

	@Override
	public double nEvents(Bin b, Gaussian dist, double mH) {
		dist.setmH(mH);
		double n = 0.5 * (dist.y(b.e_high) + dist.y(b.e_low)) * (b.e_high - b.e_low);
		return n;
	}

	@Override
	public HashMap<Double, Bin> createBins(double e_low, double e_high, double e_step) {
		HashMap<Double, Bin> bins = new HashMap<Double, Bin>();
		double d = e_low;
		while (d<e_high) {
			Bin b = new Bin(d, d+e_step,0);
			bins.put(d, b);
			d += e_step;
		}
		return bins;
	}
	
	
	
}
