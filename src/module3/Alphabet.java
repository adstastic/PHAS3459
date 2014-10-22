package module3;
import java.util.Random;

public class Alphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder randString = new StringBuilder(1000);
		int i = 0;
		int iMax = 1000;
		int total = 0;
		int exceptions = 0;
		int valid = 0;
		while (i <= iMax) {
			char randChar = randomCharacter();
			if (Character.isLetterOrDigit(randChar)) {
				randString.append(randChar);
				try {
					int parsedChar = Integer.parseInt(Character.toString(randChar));
					total += parsedChar;
					valid += 1;
				} catch (Exception e) {
					exceptions += 1;
				}
			}
			i++;
		}
		System.out.println("Random String: "+randString);
		System.out.println("Length: "+randString.length());
		System.out.println("Sum of parsed characters: "+total);
		System.out.println("Number of exceptions: "+exceptions);
		System.out.println("Valid: "+valid);
	}
	
	public static char randomCharacter() {
		Random randInt = new Random();
		int generatedInt = randInt.nextInt(128);
		char intChar = (char) generatedInt;
		return intChar;
	}

}
