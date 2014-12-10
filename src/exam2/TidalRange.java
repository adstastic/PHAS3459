package exam2;

import java.util.Collection;
import java.util.Iterator;

/**
 * Calculates tidal range (max sea leve - min sea level) for a set of sea level data
 * @author Aditya Mukherjee
 *
 */
public class TidalRange implements Statistic {
	
	/* (non-Javadoc)
	 * @see exam2.Statistic#calculateStatistic(java.util.Collection)
	 */
	@Override
	public double calculateStatistic(Collection<SeaLevel> seaLevelData) {
		Iterator<SeaLevel> slItr = seaLevelData.iterator();
		double maxLevel = Double.MIN_VALUE; //Smallest possible double value, to ensure any value compared is likely to be greater than this starting value
		double minLevel = Double.MAX_VALUE; // Largest possible double value, to ensure any value compared is likely to be smaller than this starting value
		while (slItr.hasNext()) {
			SeaLevel sl = slItr.next();
			double level = sl.measuredSeaLevel; 
			maxLevel = (level > maxLevel ? level : maxLevel); // If current level greater than current max, it becomes current max
			minLevel = (level < minLevel ? level : minLevel); // If current level less than current min, it becomes current min
		}
		double tidalRange = maxLevel - minLevel;
		return tidalRange;
	}

}
