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
	
	public static Collection<Lifeform> getSurvey(String url, String splitter, int length) throws Exception {
		Collection<Lifeform> survey = new ArrayList<Lifeform>();
		Scanner sc = scFromURL(url);
		while (sc.hasNextLine()) {
			String line =  sc.nextLine();
			try {
				Lifeform lifeform = Lifeform.constructFromLine(line, splitter, length);
				survey.add(lifeform);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
		return survey;
	}
	
	//  create new hashmap of methods
	public static Map<String, Species> planetsByMethod(Map<String, Planet> exoplanets) {
		Map<String, Method> methods = new HashMap<String, Method>();
		// loop through each entry in exoplanets map
		for (Entry<String, Planet> e : exoplanets.entrySet()) {
			Planet p = e.getValue();
			String key = p.getMethod();
			if (methods.containsKey(key)) {
				methods.get(key).add(p);
			} else {
				// add new method to methods hashmap
				methods.put(key, new Method(key));
			}
		}
		return methods;
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
