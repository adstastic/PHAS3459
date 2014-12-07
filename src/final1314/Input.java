package final1314;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Input {

	// Scanner to process read lines
	static Scanner scFromURL(String url) throws IOException {
		URL u = new URL(url);
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(u.openStream())));
		return sc;
	}
	
	public static Collection getSurvey(String url, String splitter, int length) throws Exception {
		Collection survey = new ArrayList();
		Scanner sc = scFromURL(url);
		//int i = 0;
		while (sc.hasNextLine() /*& i < 1*/) {
			String line =  sc.nextLine();
			//System.out.println(line);
			try {
				Lifeform specimen = Lifeform.constructFromLine(line, splitter, length);
				survey.add(specimen);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//i++;
		}
		sc.close();
		return survey;
	}
	
	//  create new hashmap of methods
	public static HashMap getSpecies(String url, String splitter, int length, String kingdom) throws Exception {
		HashMap<String, Species> speciesList = new HashMap<String,Species>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line =  sc.nextLine();
			try {
				Species species= Species.constructFromLine(line, splitter, length, kingdom);
				speciesList.put(species.id, species);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
		return speciesList;
	}
	
	// check input line 
	private static boolean inputLineCheck(String line) {
		if (Character.isLetter(line.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}
}
