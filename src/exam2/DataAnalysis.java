package exam2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/**
 * Analyses sea level data
 * @author Aditya Mukherjee
 *
 */
public class DataAnalysis {

	public static void main(String[] args) {
		Timer t = new Timer();
		t.startTimer();
		String url1999 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
		String url2000 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
		String url2001 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
		String urlSites99_01 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		
		String url2004 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt";
		String url2005 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt";
		String url2006 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt";
		String urlSites04_06 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		
		String spaceSplitter = "\\s+"; // Regex for any number of whitespaces
		try {
			/* PART 1 */
			System.out.println("\n1999 - 2001 Data:");
			// Import data for 1999-2001 
			Collection<SeaLevel> data1999 = Input.importSeaLevels(url1999, spaceSplitter);
			Collection<SeaLevel> data2000 = Input.importSeaLevels(url2000, spaceSplitter);
			Collection<SeaLevel> data2001 = Input.importSeaLevels(url2001, spaceSplitter);
			// merge data for all years into one collection
			Collection<SeaLevel> data99_01 = new ArrayList<SeaLevel>();
			data99_01.addAll(data1999);
			data99_01.addAll(data2000);
			data99_01.addAll(data2001);
			
			// Add sealevels to sites
			Collection<Site> sites = Input.importSites(urlSites99_01, spaceSplitter);
			addSeaLevelsToSites(sites, data99_01);
			
			// print part 1 calculations
			Object[] headers = {"Site ID", "Year", "Month", "Day", "Hour", "Minute", "Measured ", "Predicted "};
			// calculate maximum sea level for all years and each year
			SeaLevel maxAll = highestLevel(data99_01);
			SeaLevel max99 = highestLevel(data1999);
			SeaLevel max00 = highestLevel(data2000);
			SeaLevel max01 = highestLevel(data2001);
			// get table row for each collection
			Object[] rowMaxAll = seaLeveltoTableRow(maxAll, sites);
			Object[] rowMax99 = seaLeveltoTableRow(max99, sites);
			Object[] rowMax00 = seaLeveltoTableRow(max00, sites);
			Object[] rowMax01 = seaLeveltoTableRow(max01, sites);
			int dp = 0;
			char sep = '|';
			System.out.println("Maximum Observed Sea Level by year:");
			FormattedPrinter fp = new FormattedPrinter(headers, rowMaxAll, dp, sep);
			fp.printHeaders();
			fp.printData(rowMax99);
			fp.printData(rowMax00);
			fp.printData(rowMax01);
			fp.endTable();
			
			System.out.println("Maximum Observed Sea Level for 1999 - 2001:");
			fp.printHeaders();
			fp.printData(rowMaxAll);
			fp.endTable();
			
			/* PART 2 */
			System.out.println("Statistics by site:");
			Iterator<Site> siteItr1 = sites.iterator();
			Site sExample = siteItr1.next();
			Object[] headers2 = {"Site ID", "Site Name", "Mean Sea Level", "Tidal Range"};
			Object[] data2 = {sExample.ID, sExample.name, 12.345, 12.345}; // arbitrary numbers given to produce appropriate format
			FormattedPrinter fp2 = new FormattedPrinter(headers2, data2, dp, sep);
			fp2.printHeaders();
			Iterator<Site> siteItr = sites.iterator();
			while (siteItr.hasNext()) {
				Site s = siteItr.next();
				Mean m = new Mean();
				TidalRange tr = new TidalRange();
				double meanLevel = m.calculateStatistic(s.getRecords());
				double tidalRange = tr.calculateStatistic(s.getRecords());
				//Object[] data3 = {s.ID, s.name, meanLevel, tidalRange}; 
				//fp.printData(data3);
				System.out.println("Site name: "+s.name+" Mean Level: "+meanLevel+" Tidal Range: "+tidalRange);
			}
			fp.endTable();
			
			/* PART 3 */
			System.out.println("\n2004 - 2006 Data:");
			MaxTidalSurge mts = new MaxTidalSurge();
			System.out.println("Max tidal surge for 1999 - 2001: "+mts.calculateStatistic(data99_01));
			
			Collection<SeaLevel> data2004 = Input.importSeaLevels2(url2004, spaceSplitter);
			 
			Collection<SeaLevel> data2005 = Input.importSeaLevels2(url2005, spaceSplitter);
			Collection<SeaLevel> data2006 = Input.importSeaLevels2(url2006, spaceSplitter);
			Collection<SeaLevel> data04_06 = new ArrayList<SeaLevel>();
			data04_06.addAll(data2004);
			data04_06.addAll(data2005);
			data04_06.addAll(data2006);
			
			SeaLevel maxAll2 = highestLevel(data04_06);
			SeaLevel max04 = highestLevel(data2004);
			SeaLevel max05 = highestLevel(data2005);
			SeaLevel max06 = highestLevel(data2006);
			Object[] rowMaxAll2 = seaLeveltoTableRow(maxAll2, sites);
			Object[] rowMax04 = seaLeveltoTableRow(max04, sites);
			Object[] rowMax05 = seaLeveltoTableRow(max05, sites);
			Object[] rowMax06 = seaLeveltoTableRow(max06, sites);
			
			Collection<Site> sites04_06 = Input.importSites(urlSites04_06, spaceSplitter);
			addSeaLevelsToSites(sites, data04_06);
			System.out.println("Maximum Observed Sea Level by year:");
			FormattedPrinter fp3 = new FormattedPrinter(headers, rowMaxAll, dp, sep);
			fp3.printHeaders();
			fp3.printData(rowMax04);
			fp3.printData(rowMax05);
			fp3.printData(rowMax06);
			fp3.endTable();
			System.out.println("Maximum Observed Sea Level for 2004 - 2006:");
			fp3.printHeaders();
			fp3.printData(rowMaxAll2);
			fp3.endTable();
			
			
			
			/*
			// Printing all data as formatted table
			Object[] headers1 = {"Site ID", "Year", "Month", "Day", "Hour", "Minute", "Measured", "Predicted"};
			Iterator<SeaLevel> dataItr = data1999.iterator();
			SeaLevel s = dataItr.next();
			Object[] data = seaLeveltoTableRow(s);
			int dp1 = 3;
			char sep1 = '|';
			FormattedPrinter fp1 = new FormattedPrinter(headers1, data, dp1, sep1);
			fp.printHeaders();
			while (dataItr.hasNext()) {
				SeaLevel sl = dataItr.next();
				Object [] dataLine = seaLeveltoTableRow(sl);
				fp1.printData(dataLine);
			}
			fp1.endTable();
			*/
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		t.endTimer();
		
	}
	
	/**
	 * Calculates highest sea level a set of sea level data
	 * @param sData
	 * @return SeaLevel record of sea level
	 */
	static SeaLevel highestLevel(Collection<SeaLevel> sData) {
		double maxLevel = Double.MIN_VALUE;
		Iterator<SeaLevel> sItr = sData.iterator();
		SeaLevel max = sItr.next();
		while (sItr.hasNext()) {
			SeaLevel sl = sItr.next();
			if (sl.measuredSeaLevel > maxLevel) {
				maxLevel = sl.measuredSeaLevel;
				max = sl;
			}
		}
		return max;
	}
	
	
	/**
	 * Creates row to be printed as table
	 * @param s
	 * @return Object[] list of elements of table
	 */
	static Object[] seaLeveltoTableRow(SeaLevel s, Collection<Site> sites) {
		Object[] row = {s.ID, s.date.get(Calendar.YEAR), s.date.get(Calendar.MONTH)+1, s.date.get(Calendar.DAY_OF_MONTH), s.date.get(Calendar.HOUR_OF_DAY), s.date.get(Calendar.MINUTE), s.measuredSeaLevel, s.predictedSeaLevel};
		return row;
	}

	/**
	 * Iterates through all sea level data and all site data, adding sea levels to sites
	 * @param sites
	 * @param seaLevelData
	 */
	static void addSeaLevelsToSites(Collection<Site> sites, Collection<SeaLevel> seaLevelData) {
		Iterator<Site> siteItr = sites.iterator();
		Iterator<SeaLevel> slItr = seaLevelData.iterator();
		while (siteItr.hasNext()) {
			Site s = siteItr.next();
			while (slItr.hasNext()) {
				SeaLevel sl = slItr.next();
				if (sl.ID.equals(s.ID)) {
					s.addSeaLevel(sl);
					sl.setName(s.name);
				}
			}
		}
	}
	

}
