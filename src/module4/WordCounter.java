package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {
	
	public static void main(String[] args) throws Exception {
		try {
			String url = WordCounter.getStringFromKeyboard("Please enter a URL below:");
			int wordCount = countWordsInResource(url);
			System.out.println(wordCount);
		} catch (MalformedURLException m) {
			System.out.println("Invalid URL!: "+m.getMessage());
		} catch (IOException i) {
			System.out.println("Error reading input!: "+i.getMessage());
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public static String getStringFromKeyboard(String input) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(input);
		String s = b.readLine();
		return s;
	}
	
	public static int countWordsInResource(String urlName) throws MalformedURLException, IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		BufferedReader b = new BufferedReader(new InputStreamReader(is));
		Scanner sc = new Scanner(b);
		String word;
		int wordCount = 0;
		while (sc.hasNext()) {
			word = sc.next();
			wordCount++;
		}
		sc.close();
		return wordCount;
	}
}
