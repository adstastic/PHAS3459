package exam2;

import java.util.Collection;
import java.util.Iterator;

/**
 * Calculates mean sea level for a set of sea level data
 * @author Aditya Mukherjee
 *
 */
public class Mean implements Statistic {

	/* (non-Javadoc)
	 * @see exam2.Statistic#calculateStatistic(java.util.Collection)
	 */
	@Override
	public double calculateStatistic(Collection<SeaLevel> seaLevelData) {
		Iterator<SeaLevel> slItr = seaLevelData.iterator(); // Iterate through sea level data
		double totalLevel = 0.0; //set starting values of total and number to 0
		double nLevels = 0.0;
		while (slItr.hasNext()) {
			SeaLevel sl = slItr.next();
			totalLevel += sl.measuredSeaLevel; // add sea level of current record to total
			nLevels += 1; // increment number of records processed counter by 1
		}
		double meanLevel = totalLevel/nLevels;
		return meanLevel;
	}
}
