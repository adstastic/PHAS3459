package final1314;

import java.util.Collection;

public interface GeoSort {
	
	public Collection<Plant> latSort(Collection<Plant> c, double minLat, double maxLat);
	
	public Collection<Plant> longSort(Collection<Plant> c, double minLong, double maxLong);
	
	public Collection<Plant> regionSort(Collection<Plant> c, double lat, double lon, double distance);

}
