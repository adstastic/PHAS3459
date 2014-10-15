package module2;

public class TestSimpleCounter {
	public static void main(String[] args)	{
		SimpleCounter count1 = new SimpleCounter();
		SimpleCounter count2 = new SimpleCounter(3);
		SimpleCounter sum = count1.add(count2);
		System.out.println("value of counter is "+count1.getCounter());
		System.out.println("value of counter is "+count2.getCounter());
		System.out.println("value of sum is "+sum );
		SimpleCounter c = new SimpleCounter();
		System.out.println("state of c: "+c);
	}
}
