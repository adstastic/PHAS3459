package module2;

public class StaticTest {
	private int varA;
	private static int varB;
	
	public static void main(String[] args)	{
		StaticTest objectX = new StaticTest();
		StaticTest objectY = new StaticTest();
		objectX.varA = 1; StaticTest.varB = 2;
		objectY.varA = 10; StaticTest.varB = 20;
		System.out.println("objectX: varA="+objectX.varA+
				" varB="+StaticTest.varB);
		System.out.println("objectY: varA="+objectY.varA+
				" varB="+StaticTest.varB);
	}

}
