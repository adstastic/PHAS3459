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
		/*
		//Printing Plant Survey 
		System.out.printf("%-10s %-10s %-8s %6s\n", "Latitude", "Longitude", "Species", "Height");
		for (Plant plant : plantSurvey) {
			System.out.println(plant);
		}
		 
		// Printing Plant Species
		System.out.printf("%-6s %-20s\n", "Code", "Scientific Name");
		for (Species species : plantSpecies) {
			System.out.println(species);
		}
		*/
		// Compute number of specimens for each species, and calculate mean height
		for (Plant p : plantSpecimen) {
			for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
				//System.out.println(p.species_id+" "+e.getKey());
				if (p.species_id.equals(e.getKey())) {
					e.getValue().addSpecimen(p);
					//System.out.println(e.getValue().number);
				}
			}
		}
		
		
		// For each of the species, print the scientific name along with the number of specimens found and their mean height
		System.out.printf("%-23s %-15s %-12s\n", "Scientific Name", "No. Specimens", "Mean height");
		for (Map.Entry<String, PlantSpecies> e : plantSpecies.entrySet()) {
			PlantSpecies pSp = e.getValue();
			System.out.printf("%-23s %13s %13.2f\n", pSp.name, pSp.number, pSp.meanHeight());
			
		}
		
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
}

