package final1213;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface BInterface {
	
	public HashMap<Double, HashMap<Double, Bin>> binEvents(HashMap<Double, Bin> bins, Gaussian dist, double e_low, double e_high, double step);

	double nEvents(Bin b, Gaussian dist, double mH);
	
	Map<Double, Bin> createBins(double low, double high, double step);
	
}
