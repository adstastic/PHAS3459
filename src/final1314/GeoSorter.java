package final1314;

import java.util.ArrayList;
import java.util.Collection;

public class GeoSorter implements GeoSort {
		
	@Override
	public Collection<Plant> latSort(Collection<Plant> c, double minLat, double maxLat) {
		Collection<Plant> latSorted =  new ArrayList<Plant>();
		for (Plant p : c) {
			double lat = p.loc.latitude;
			if (lat < maxLat & lat > minLat) {
				latSorted.add(p);
			} 
		}
	return latSorted;
	}

	@Override
	public Collection<Plant> longSort(Collection<Plant> c, double minLong, double maxLong) {
		Collection<Plant> longSorted =  new ArrayList<Plant>();
		for (Plant p : c) {
			double lon = p.loc.longitude;
			if (lon < maxLong & lon > minLong) {
				longSorted.add(p);
			} 
		}
	return longSorted;
	}

	@Override
	public Collection<Plant> regionSort(Collection<Plant> c, double lat, double lon, double distance) {
		Collection <Plant> regionSorted = new ArrayList<Plant>();
		Coordinates point = new Coordinates(lat, lon);
		for (Plant p : c) {
			double d = GeoMath.distance(point, p.loc);
			if (d < distance) {
				regionSorted.add(p);
			}
		}
		return regionSorted;
	}
	
	
}
