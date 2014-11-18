package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DataAnalysis {

	public static void main(String[] args) {
		try {
			Collection data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			Theory f1 = new PowerLawTheory(2);
			Theory f2 = new PowerLawTheory(2.05);
			Theory f3 = new QuadraticTheory(1, 10, 0);
			Collection<Theory> theories = new ArrayList<Theory>(Arrays.asList(f1,f2,f3));
			GoodnessOfFitCalculator gof = new ChiSquared();
			Theory bestTheory = bestTheory(data, theories, gof);
			System.out.println(bestTheory);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }

}
