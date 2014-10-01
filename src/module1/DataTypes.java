package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		double doubVar = 10.0;
		System.out.println("Double: " + doubVar);
		System.out.println('\n');
		
		//Convert double to float
		float floatVar = 10.0f;
		System.out.println("Double 10.0 to float: " + floatVar);
		System.out.println('\n');
		
		//Multiply double with float
		System.out.println("Double 10.0 x float 10.0: " + doubVar*floatVar);
		System.out.println('\n');
		
		//Convert double to byte
		byte byteVar = (byte) 10.0;
		System.out.println("Byte 10.0: " + byteVar);
		System.out.println("Byte 10.0 muliplied by itself: " + byteVar*byteVar);
		System.out.println('\n');
		
		//Convert double to int
		int intVar = (int) 10.0;
		System.out.println("int 10.0: "+intVar);
		System.out.println("int 10.0 multiplied by itself: "+intVar*intVar);
		System.out.println('\n');
		
		//Convert double to long
		long longVar = (long) 10.0;
		System.out.println("long 10.0: "+longVar);
		System.out.println("long 10.0 multiplied by itself: "+longVar*longVar);
		System.out.println('\n');
		
		//Mix data types int and char assigned to int
		int intChar = 7*'a';
		int intA = (int) 'a';
		System.out.println("int value of 'a': "+intA);
		System.out.println("7 x 97 = " + 7*97);
		System.out.println("int value of 7 x 'a': " + intChar);
		System.out.println("Mixing types char and int in an int converts the char to an int and then performs the operation specified, multiplication in this case.");
		System.out.println('\n');
		
		//Mix int and char assigned to char
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
		
		//Mix double and char assigned to double
		double pi = 3.1415;
		double doubChar = pi +'a';
		double doubA = (double) 'a';
		System.out.println("'a' as double: " +doubA);
		System.out.println("3.1415 + 'a' as double: " +doubChar);
		double doubCharCheck = 3.1415 + 97.0;
		System.out.println("3.1415 + 97.0 = " + doubCharCheck);
		System.out.println("Mixing types double and char in a double converts the char to a double (which is its int value as a double) and then performs the operation specified, addition in this case.");
		System.out.println('\n');
		
		//Test result of using uninitialised variables
		int j=1;
		//The following lines will result  in a compile-time error as java cannot compile the code with ininitialised variables;
		//int i;
		//int j=i+1;
		
		//Converting double to int
		double doubVar2 = 4.99;
		int intDoub = (int) doubVar2;
		System.out.println("Double 4.99 converted to int = " + intDoub);
		
		
	}

}
