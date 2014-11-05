package module5;
import module2.SimpleCounter;;

public class Notes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = a;
		b = 2;
		System.out.println("a = "+a);

		SimpleCounter c = new SimpleCounter(1);
		SimpleCounter d = c;
		d.setCounter(2);
		System.out.println("c = "+c.getCounter());
		
		SimpleCounter e = new SimpleCounter(3);
		SimpleCounter f = new SimpleCounter(4);
		f = e;
		System.out.println("f = "+f.getCounter());
		
		int g = 1;
		changeIt(g);
		System.out.println("a is still "+g);
		
		SimpleCounter h = new SimpleCounter(1);
		changeIt(h);
		System.out.println("h is now "+h.getCounter());
		
		String x = "Hello";
		System.out.println(System.identityHashCode(x));
		x = x + " world"; // creates a new object
		System.out.println(System.identityHashCode(x));
		
		StringBuilder z = new StringBuilder("Hello");
		System.out.println(System.identityHashCode(z));
		z.append(" world"); // adds data to existing object
		System.out.println(System.identityHashCode(z));
		
	}
	
	public static void changeIt(int i) {
		i = 2;
	}
	
	public static void changeIt(SimpleCounter c) {
		c.setCounter(2);
	}
}
