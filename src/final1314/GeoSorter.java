package final1314;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GeoSorter implements GeoSort {
		
	@Override
	public Collection latSort(Collection c, double minLat, double maxLat) {
		Collection<Lifeform> latSorted =  new ArrayList<Lifeform>();
		Iterator specimenItr = c.iterator();
		while (specimenItr.hasNext()) {
			Lifeform l = (Lifeform) specimenItr.next();
			double lat = l.loc.latitude;
			if (lat < maxLat & lat > minLat) {
				latSorted.add(l);
			} 
		}
	return latSorted;
	}

	@Override
	public Collection lonSort(Collection c, double minLon, double maxLon) {
		Collection<Lifeform> lonSorted =  new ArrayList<Lifeform>();
		Iterator specimenItr = c.iterator();
		while (specimenItr.hasNext()) {
			Lifeform l = (Lifeform) specimenItr.next();
			double lat = l.loc.longitude;
			if (lat < maxLon & lat > minLon) {
				lonSorted.add(l);
			} 
		}
	return lonSorted;
	}

	@Override
	public Collection regionSort(Collection c, double lat, double lon, double distance) {
		Collection <Lifeform> regionSorted = new ArrayList<Lifeform>();
		Coordinates point = new Coordinates(lat, lon);
		Iterator specimenItr = c.iterator();
		while (specimenItr.hasNext()) {
			Lifeform l = (Lifeform) specimenItr.next();
			double d = GeoMath.distance(point, l.loc);
			//System.out.println(point+" "+l.loc+" "+d);
			if (d < distance) {
				regionSorted.add(l);
			}
		}
		return regionSorted;
	}
	
	public Collection xRegionSort(Collection c, double lat, double lon, double distance) {
		Collection <String> inRegion = new  HashSet<String>();
		Collection <String> outRegion = new HashSet<String>();
		Coordinates point = new Coordinates(lat, lon);
		Iterator specimenItr = c.iterator();
		while (specimenItr.hasNext()) {
			Lifeform l = (Lifeform) specimenItr.next();
			String species_id = l.getSpecies_id();
			double d = GeoMath.distance(point, l.loc);
			if (d < distance) {
				inRegion.add(species_id);
			} else if (d > distance) {
				outRegion.add(species_id);
			}
		}
		Collection <String> xInRegion = new  HashSet<String>();
		Iterator<String> speciesItr = inRegion.iterator();
		while (speciesItr.hasNext()) {
			String in_species_id = speciesItr.next();
			if (outRegion.contains(in_species_id) != true) {
				xInRegion.add(in_species_id);
			}
		}
		return xInRegion;
	}
	
	
	
	
}
