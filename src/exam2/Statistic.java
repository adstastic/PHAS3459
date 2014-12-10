package exam2;

import java.util.Collection;

/**
 * Calculates a statistic for a set of seaLevel data
 * @author Aditya Mukherjee
 */
public interface Statistic {
	
	/**
	 * Calculates statistic for seaLevel data and returns real number
	 * @param data
	 * @return double
	 */
	double calculateStatistic(Collection<SeaLevel> data);
}
