package module1;
// Written by Aditya Mukherjee for the PHAS3459 course

public class DataTypes {
// This class investigates Java data types by casting, converting, and mixing between them

	public static void main(String[] args) {
		
		double doubVar = 10.0; 
		System.out.println("doubVar: " + doubVar);
		System.out.println('\n');
		
		// Cast 10.0 as float
		float floatVar = 10.0f;
		System.out.println("floatVar: " + floatVar);
		System.out.println('\n');
		
		//Multiply double with float
		System.out.println("double 10.0 x float 10.0: " + doubVar*floatVar);
		System.out.println('\n');
		
		// Cast 10.0 as byte
		byte byteVar = (byte) 10.0;
		System.out.println("byte 10.0: " + byteVar);
		System.out.println("byte 10.0 muliplied by itself: " + byteVar*byteVar);
		System.out.println('\n');
		
		// Cast 10.0 as int
		int intVar = (int) 10.0;
		System.out.println("int 10.0: "+intVar);
		// Multiply intVar by itself and print
		System.out.println("int 10.0 multiplied by itself: "+intVar*intVar);
		System.out.println('\n');
		
		// Cast 10.0 as long
		long longVar = (long) 10.0;
		System.out.println("long 10.0: "+longVar);
		// Multiply longVar by itself and print
		System.out.println("long 10.0 multiplied by itself: "+longVar*longVar);
		System.out.println('\n');
		
		//Mix data types int and char assigned to int
		int intOfChar = 7*'a';
		// Cast 'a' as int
		int intOfA = (int) 'a';
		System.out.println("int value of 'a': "+intOfA);
		// int value of 'a' is 97
		System.out.println("7 x 97 = " + 7*97);
		System.out.println("int value of 7 x 'a': " + intOfChar);
		System.out.println("Mixing types char and int in an int converts the char to an int and then performs the operation specified, multiplication in this case.");
		System.out.println('\n');
		
		//Mix int and char assigned to char
		char charOfInt = 117+'a';
		// Cast 117 as char
		char charOf117 = (char) 117;
		System.out.println("char value of 117: "+charOf117);
		System.out.println("int value of a (as shown in block above) is 97.");
		int x = 117+97;
		System.out.println("117 + 97 = " + x);
		// Cast 117+97 as char 
		char charOfA = (char) x;
		System.out.println("char value of 214: " + charOfA);
		System.out.println("char value of 117 + 'a': " + charOfInt);
		System.out.println("Mixing types char and int in a char converts the char to an int and then performs the operation specified, addition in this case, then converts the result back into a char.");
		System.out.println('\n');
		
		//Mix double and char assigned to double
		double pi = 3.1415;
		double doubleOfChar = pi +'a';
		// Cast 'a' as double
		double doubOfA = (double) 'a';
		System.out.println("'a' as double: " +doubOfA);
		System.out.println("3.1415 + 'a' as double: " +doubleOfChar);
		// Check result by adding 3.1415 to 97.0 (double value of 'a')
		double doubOfCharCheck = 3.1415 + 97.0;
		System.out.println("3.1415 + 97.0 = " + doubOfCharCheck);
		System.out.println("Mixing types double and char in a double converts the char to a double (which is its int value as a double) and then performs the operation specified, addition in this case.");
		System.out.println('\n');
		
		// Test result of using uninitialised variables
		int j=1;
		/*
		 *The following lines will result  in a compile-time error as java cannot compile the code with uninitialised variables
		 * int i;
		 * int j=i+1;
		 */
		
		//Converting double to int
		double doubVar2 = 4.99;
		// Cast 4.99 as int
		int intOfDoub = (int) doubVar2;
		System.out.println("Double 4.99 converted to int = " + intOfDoub);
		
	}

}
