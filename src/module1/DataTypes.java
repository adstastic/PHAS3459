package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double doubVar = 10.0;
		System.out.println(doubVar);
		
		float floatVar = 10.0f;
		System.out.println(floatVar);
		
		System.out.println(doubVar*floatVar);

		char charVar = 'a' + 10;
		System.out.println(charVar);
		System.out.println('\n');
		
		int intChar = 7*'a';
		int intA = (int) 'a';
		System.out.println("int value of 'a': "+intA);
		System.out.println("7 x 97 = " + 7*97);
		System.out.println("int value of 7 x 'a': " + intChar);
		System.out.println("Mixing types char and int in an int converts the char to an int and then performs the operation specified, multiplication in this case.");
		System.out.println('\n');
		
		char charInt = 117+'a';
		char char7 = (char) 117;
		System.out.println("char value of 117: "+char7);
		System.out.println("int value of a as shown above is 97.");
		int a = 117+97;
		System.out.println("117 + 97 = " + a);
		System.out.println("char value of 117 + 'a': " + charInt);
		char charIntCheck = (char) a;
		System.out.println("char value of 117 + 97: " + charIntCheck);
		System.out.println("Mixing types char and int in a char converts the char to an int and then performs the operation specified, addition in this case, then converts the result back into a char.");
		System.out.println('\n');
		
		double pi = 3.1415;
		double doubChar = pi +'a';
		double doubA = (double) 'a';
		System.out.println("'a' as double: " +doubA);
		System.out.println("3.1415 + 'a' as double: " +doubChar);
		double doubCharCheck = 3.1415 + 97.0;
		System.out.println("3.1415 + 97.0 = " + doubCharCheck);
		System.out.println("Mixing types double and char in a double converts the char to a double (which is its int value as a double) and then performs the operation specified, addition in this case.");
		System.out.println('\n');
		
		int j = 1;
		
	}

}
