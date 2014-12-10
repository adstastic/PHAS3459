package exam2;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Holds record of sea level data
 * @author Aditya Mukherjee
 *
 */
public class SeaLevel {
	final String ID;
	final Calendar date;
	final double measuredSeaLevel;
	final double predictedSeaLevel;
	private String name;
	
	public SeaLevel(String ID, int year, int month, int day, int hour, int minute, double measured, double predicted) {
		this.ID = ID;
		this.measuredSeaLevel = measured;
		this.predictedSeaLevel = predicted;
		this.date = new GregorianCalendar(year, month-1, day, hour, minute); // month-1 because calendar stores month from 0 - 11 so a month of 12 will be stored as january of the following year
	}

	public Calendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		// Month+1 because Calendar stores month from 0 - 11
		return String.format("| %-7s | %-4s | %-5s | %-3s | %-4s | %-6s | %-8.3f | %-9.3f | %n", this.ID, 
				this.date.get(Calendar.YEAR), this.date.get(Calendar.MONTH)+1, this.date.get(Calendar.DAY_OF_MONTH), this.date.get(Calendar.HOUR), this.date.get(Calendar.MINUTE), this.measuredSeaLevel, this.predictedSeaLevel);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
