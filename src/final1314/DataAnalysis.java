package final1314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataAnalysis {

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.startTimer();
		String plantSurveyURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
		String plantSpeciesURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";
		String whitespaceRegex = "\\s+";
		Collection<Plant> plantSpecimen = Input.getSurvey(plantSurveyURL, whitespaceRegex, 4);
		HashMap<String, PlantSpecies> plantSpecies = Input.getSpecies(plantSpeciesURL, whitespaceRegex, 3, "Plant");
	
		// Compute number of specimens for each species, and calculate mean height
		printMeanHeight(plantSpecimen, plantSpecies);
		printSpeciesMeanHeight(plantSpecies);
		extremeMeanHeightSpecies(plantSpecies);
		
		
		double northMean = latitudeSort("urtica dioica", plantSpecies, plantSpecimen, -30, 90);
		double southMean = latitudeSort("urtica dioica", plantSpecies, plantSpecimen, -90, -30);
		System.out.printf("%-30s %5.2f\n", "Mean height of Urtica Dioica found north of -30 degrees Latitude: ", northMean);
		System.out.printf("%-30s %5.2f\n", "Mean height of Urtica Dioica found south of -30 degrees Latitude: ", southMean);
		
		double summitMean = regionSort("solanum carolinense", plantSpecies, plantSpecimen, -30.967, 75.430, 50000);
		System.out.printf("%-30s %5.2f\n", "Mean height of Solanum Carolinense found within 50 km of -30.967, 75.430: ", summitMean);
		
		timer.endTimer();
	}
	
	public static double regionSort(String species, Map<String, PlantSpecies> plantSpecies, Collection<Plant> plantSpecimen, double lat, double lon, double distance) {
		Collection<Plant> specimenList = specimenBySpecies(plantSpecies, plantSpecimen, species);
		GeoSorter gs = new GeoSorter();
		Collection<Plant> regionSorted = gs.regionSort(specimenList, lat, lon, distance);
		double meanHeight = collectionMeanHeight(regionSorted);
		return meanHeight;
	}
	
	public static Collection<Plant> specimenBySpecies (Map<String, PlantSpecies> plantSpecies, Collection<Plant> plantSpecimen, String species) {
		Collection<Plant> species_name = new ArrayList();
		String species_id = "";
		for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
			if(e.getValue().name.equalsIgnoreCase(species)) {
				species_id = e.getKey();
			}
		}
		for (Plant p : plantSpecimen) {
			if (p.species_id.equalsIgnoreCase(species_id)) {
				species_name.add(p);
			}
		}
		return species_name;
	}
	public static double latitudeSort(String species, Map<String, PlantSpecies> plantSpecies, Collection<Plant> plantSpecimen, double minLat, double maxLat) {
		Collection<Plant> species_name = specimenBySpecies(plantSpecies, plantSpecimen, species);
		GeoSorter gs = new GeoSorter();
		Collection<Plant> gc = gs.latSort(species_name, minLat, maxLat);
		double meanHeight = collectionMeanHeight(gc);
		return meanHeight;
	}
	
	public static double collectionMeanHeight(Collection<Plant> c) {
		double Tot = 0;
		for (Plant p : c) {
			Tot += p.height;
		}
		double meanHeight = Tot/c.size();
		return meanHeight;
	}
	
	
	public static void printMeanHeight(Collection<Plant> plantSpecimen, Map<String, PlantSpecies> plantSpecies) {
		for (Plant p : plantSpecimen) {
			for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
				//System.out.println(p.species_id+" "+e.getKey());
				if (p.species_id.equals(e.getKey())) {
					e.getValue().addSpecimen(p);
					//System.out.println(e.getValue().number);
				}
			}
		}
	}
	
	// For each of the species, print the scientific name along with the number of specimens found and their mean height
	public static void printSpeciesMeanHeight(Map<String, PlantSpecies> plantSpecies) {
		System.out.printf("%-23s %-15s %-12s\n", "Scientific Name", "No. Specimens", "Mean height");
		for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
			PlantSpecies pSp = e.getValue();
			System.out.printf("%-23s %13s %13.2f\n", pSp.name, pSp.number, pSp.meanHeight());
			
		}
	}
	
	public static void extremeMeanHeightSpecies(Map<String, PlantSpecies> plantSpecies) {
		// Lowest and highest mean height species
				double minH = Double.MAX_VALUE;
				String min_id = "";
				double maxH = Double.MIN_VALUE;
				String max_id = "";
				for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
					double eH = e.getValue().meanHeight(); 
					if (eH < minH) { 
						minH = eH; 
						min_id = e.getKey();
					} else if (eH > maxH) {
						maxH = eH;
						max_id = e.getKey();
					}
				}
				System.out.println("Lowest Mean Height: "+plantSpecies.get(min_id).name);
				System.out.println("Hightst Mean Height: "+plantSpecies.get(max_id).name);
	}
	
	public static void printEverything(Collection<Plant> plantSpecimen, Map<String, PlantSpecies> plantSpecies) {
		//Printing Plant Survey 
				System.out.printf("%-10s %-10s %-8s %6s\n", "Latitude", "Longitude", "Species", "Height");
				for (Plant plant : plantSpecimen) {
					System.out.println(plant);
				}
				 
				// Printing Plant Species
				System.out.printf("%-6s %-20s\n", "Code", "Scientific Name");
				for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
					System.out.println(e.getValue());
				}
	}
}

