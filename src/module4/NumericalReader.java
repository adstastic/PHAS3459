package module4;
import java.net.*;
import java.io.*;

public class NumericalReader {
	
	private int minValue;
	private int maxValue; 
	private int nValues; 
	private int sumOfValues;
	private PrintWriter pw;
	private FileWriter fw;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NumericalReader nr = new NumericalReader();
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt";
		try {
			BufferedReader reader = brFromURL(url);
			// or BufferedReader reader = brFromFile("filename.dat");
			String line = "";
			nr.analysisStart(); // initialise minValue etc.
			while ((line = reader.readLine()) != null) { 
				nr.analyseData(line); // analyse lines, check for comments etc.
			}
		}
		catch (MalformedURLException m) {
			System.out.println("Invalid URL error: "+m.getMessage());
		}
		catch (IOException ioe) {
			System.out.println("I/O error: "+ioe.getMessage());
		}
		
		nr.analysisEnd(); // print min, max, etc.
	}

	public static BufferedReader brFromURL(String url) throws IOException {
		URL u = new URL(url);
		BufferedReader URLReader = new BufferedReader(new InputStreamReader(u.openStream()));
		return URLReader;
	}
	
	public static BufferedReader brFromFile(String file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		return fileReader;
	}
	
	public void analysisStart() throws IOException {
		String path = "N:"+File.separator+"numbers.txt";
		fw = new FileWriter(new File(path));
		//BufferedWriter br = new BufferedWriter(outputFile);
		//pw = new PrintWriter(br);
		minValue = maxValue = nValues = sumOfValues = 0;
	}
	
	public void analyseData(String line) throws IOException {
		if (Character.isLetter(line.charAt(0)) || line.isEmpty()) {} 
		else {
			for (int i=0; i <= line.length(); i++) {
				try {
					char output = line.charAt(i);
					System.out.println(output);
					// NEITHER OF THESE ARE WORKING
					//pw.println(output);
					//fw.append(output);
					minValue = (output < minValue ? output : minValue); 
					maxValue = (output > maxValue ? output : maxValue); 
					nValues += 1;
					sumOfValues += output;
				} catch (IndexOutOfBoundsException iobe) {
					continue;
				}
			}
		}
	}
	
	public void analysisEnd() {
		System.out.println("Minimum value: "+minValue);
		System.out.println("Maximum value: "+maxValue);
		System.out.println("Number of values: "+nValues);
		System.out.println("Sum of values: "+sumOfValues);
	}
}
