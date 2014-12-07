package final1314;

import java.util.Collection;

public interface GeoSort {
	
	public Collection latSort(Collection c, double minLat, double maxLat);
	
	public Collection lonSort(Collection c, double minLon, double maxLon);
	
	public Collection regionSort(Collection c, double lat, double lon, double distance);

}
