package final1314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataAnalysis {

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.startTimer();
		System.out.println("Plant Survey:\n");
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
		
		String speciesToFilter = "Solanum carolinense";
		double summitMean = regionSort(speciesToFilter, plantSpecies, plantSpecimen, -30.967, 75.430, 50);
		System.out.printf("%-10s %-10s %-10s %5.2f\n", "Mean height of", speciesToFilter, "found within 50 km of (-30.967, 75.430):", summitMean);
		
		System.out.println("\nAnimal Survey:\n");
		String animalSurveyURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt";
		String animalSpeciesURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt";
		Collection animalSpecimen = Input.getSurvey(animalSurveyURL, whitespaceRegex, 3);
		Map<String, Species> animalSpecies = Input.getSpecies(animalSpeciesURL, whitespaceRegex, 3, "Animal");
		//printEverything(animalSpecimen, animalSpecies);
		xRegionSort(animalSpecimen, animalSpecies, -30.967, 75.430, 50);
		//printSpeciesList(animalSpecies);
		timer.endTimer();
	}
	
	public static void xRegionSort(Collection specimen, Map<String, Species> species, double lat, double lon, double distance) {
		GeoSorter gs = new GeoSorter();
		Collection<String> speciesList  = gs.xRegionSort(specimen, lat, lon, distance);
		System.out.println("Species found exclusively within "+distance+" km of coordinates ("+lat+", "+lon+"):");
		Iterator<String> speciesListItr = speciesList.iterator();
		while (speciesListItr.hasNext()) {
			String species_id = speciesListItr.next();
			String species_name = species.get(species_id).name;
			System.out.println(species_name);
		}
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
		Iterator<Plant> plantSpecimenItr = plantSpecimen.iterator();
		while (plantSpecimenItr.hasNext()) {
			Plant p = plantSpecimenItr.next();
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
		Iterator<Plant> plantSpecimenItr = plantSpecimen.iterator();
		while (plantSpecimenItr.hasNext()) {
			Plant p = plantSpecimenItr.next();
			Iterator<PlantSpecies> plantSpeciesItr = plantSpecies.values().iterator();
			while (plantSpeciesItr.hasNext()) {
				PlantSpecies pSp = plantSpeciesItr.next();
				if (p.species_id.equals(pSp.getId())) {
					pSp.addSpecimen(p);
				}
			}
		}
	}
	
	// For each of the species, print the scientific name along with the number of specimens found and their mean height
	public static void printSpeciesMeanHeight(Map<String, PlantSpecies> plantSpecies) {
		//System.out.printf("  \n", "", "", "");
		String leftAlignFormat = "| %-23s | %-14s | %-11.2f |%n";
		System.out.format("+-------------------------+----------------+-------------+%n");
		System.out.printf("| Scientific Name         | No. Specimens  | Mean height | %n");
		System.out.format("+-------------------------+----------------+-------------+%n");
		Iterator<PlantSpecies> plantSpeciesItr = plantSpecies.values().iterator();
		while (plantSpeciesItr.hasNext()) {
			PlantSpecies pSp = plantSpeciesItr.next();
			System.out.format(leftAlignFormat, pSp.name, pSp.number, pSp.meanHeight());
			//System.out.printf("%-23s %13s %13.2f\n", pSp.name, pSp.number, pSp.meanHeight());
		}
		System.out.format("+-------------------------+----------------+-------------+%n");
	}
	
	public static void extremeMeanHeightSpecies(Map<String, PlantSpecies> plantSpecies) {
		// Lowest and highest mean height species
				double minH = Double.MAX_VALUE;
				String min_id = "";
				double maxH = Double.MIN_VALUE;
				String max_id = "";
				Iterator<PlantSpecies> plantSpeciesItr = plantSpecies.values().iterator();
				while (plantSpeciesItr.hasNext()) {
					PlantSpecies pSp = plantSpeciesItr.next();
					double eH = pSp.meanHeight(); 
					if (eH < minH) { 
						minH = eH; 
						min_id = pSp.getId();
					} else if (eH > maxH) {
						maxH = eH;
						max_id = pSp.getId();
					}
				}
				System.out.println("Lowest Mean Height: "+plantSpecies.get(min_id).name);
				System.out.println("Hightst Mean Height: "+plantSpecies.get(max_id).name);
	}
	
	public static void printSpecimenList(Collection specimen) {
		System.out.printf("%-10s %-10s %-8s %6s\n", "Latitude", "Longitude", "Species", "Height");
		Iterator<Plant> specimenItr = specimen.iterator();
		while (specimenItr.hasNext()) {
			System.out.println(specimenItr.next());
		}
	}
	
	public static void printSpeciesList(Map species) {
		System.out.printf("%-6s %-20s\n", "Code", "Scientific Name");
		Iterator speciesItr = species.values().iterator();
		while (speciesItr.hasNext()) {
			System.out.println(speciesItr.next());
		}
	}
	
	public static void printEverything(Collection specimen, Map species) {
				printSpecimenList(specimen);
				printSpeciesList(species);
	}
	
}

