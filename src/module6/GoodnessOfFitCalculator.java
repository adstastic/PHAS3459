package module6;

import java.util.ArrayList;
import java.util.Collection;

public interface GoodnessOfFitCalculator {
	
	double goodnessOfFit(Collection<DataPoint> data, Theory theory); 
	
}
