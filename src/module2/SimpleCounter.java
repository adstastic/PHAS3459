package module2;

public class SimpleCounter {
	private static final int max = 1000;
	private int counter;
	public SimpleCounter() {}
	public SimpleCounter(int value) { counter = value; }
	
	public void setCounter(int val) { 
		if (val<=max) counter = val;
	}
	
	public int getCounter() {return counter;}
	
	public static void printMaximum()	{
		System.out.println("maximum = "+max);
	}
	
	public static SimpleCounter add(SimpleCounter x, SimpleCounter y) {
		int sum = x.counter + y.counter;
		return new SimpleCounter(sum);
	}

	public SimpleCounter add(SimpleCounter z){
		return add(this,z);
	}
	
	public String toString()	{
		return "counter = "+counter+", max = "+max;
	}
	
}
