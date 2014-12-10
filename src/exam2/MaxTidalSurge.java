package exam2;

import java.util.Collection;
import java.util.Iterator;

public class MaxTidalSurge implements Statistic {

	@Override
	public double calculateStatistic(Collection<SeaLevel> seaLevelData) {
		Iterator<SeaLevel> slItr = seaLevelData.iterator();
		double maxSurge = Double.MIN_VALUE; //Smallest possible double value, to ensure any value compared is likely to be greater than this starting value
		while (slItr.hasNext()) {
			SeaLevel sl = slItr.next();
			double surge = sl.measuredSeaLevel - sl.predictedSeaLevel; 
			maxSurge = (surge > maxSurge ? surge : maxSurge); // If current level greater than current max, it becomes current max
		}
		return maxSurge;
	}

}
