package module3;

import java.util.Random;

public class AlphabetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randInt = new Random();
		int generatedInt = randInt.nextInt(128);
		System.out.println(generatedInt);
		char intChar = (char) generatedInt;
		System.out.println(intChar);
		int ctest = (int) intChar;
		char itest = (char) generatedInt;
		System.out.println(ctest+" "+itest);
		
		for (int i=0; i<1000000; i++) {
			int generatedIntTest = randInt.nextInt(128);
			if (generatedIntTest >= 0 && generatedIntTest <= 127) {
				
			} else {
				System.out.println(generatedIntTest);
			}
		}
		System.out.println("End");
	}

}
