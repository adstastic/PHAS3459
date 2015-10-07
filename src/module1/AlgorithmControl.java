package module1;
//Written by Aditya Mukherjee for the PHAS3459 course

public class AlgorithmControl {
// This class explores algorithm control and work flow in Java using loops 

	public static void main(String[] args) {
		//Create new instance of AlgorithmControl class
		AlgorithmControl ac = new AlgorithmControl();
		
		ac.loop();
		System.out.println('\n');
		
		ac.decrement();
		System.out.println('\n');
		
		ac.increment();
		System.out.println('\n');
		
		// Invoke timer method, run for 4000 milliseconds, print every 100 loops
		int totalLoops4000 = ac.timer(4000,100);

		System.out.println('\n');
		
		// Invoke timer method again, print every 50000 loops
		int totalLoops50000 = ac.timer(4000, 50000);
		
		//Comparing number of loops run when printing every 100 vs every 50000 loops
		System.out.println("Total loops printing every 100: "+totalLoops4000);
		System.out.println("Total loops printing every 50000: "+totalLoops50000);
		System.out.println("The total number of loops completed when printing every 50000 loops is much larger than when printing every 100.");
		System.out.println("This is because each 'System.out.println()' statement takes a finite amount of time and when printing every 100 loops, a lot more of the loops execute the println statements as compared to when printing every 50000 loops.");
		System.out.println("More loops are 'slower' loops when printing every 100 loops than when printing every 50000.");
	}
	
	// Method to print integers ascending from 1 to 20
	public void loop()	{
		int startVal = 1;
		int endVal = 20;
		
		for (startVal=1; startVal<=endVal; startVal++)	{
			System.out.println(startVal);
		}
	}
	
	// Method to print integers descending from 5 to -10
	public void decrement()	{
		int startVal = 5;
		int endVal = -10;
		while (startVal>=endVal)	{
			System.out.println(startVal);
			// Decrement startVal by 1
			startVal--;
		}
	}
	
	// Method to print numbers from 2.4 ascending by 0.5 to 15.9
	public void increment()	{
		double startVal = 2.4;
		double increment = 0.5;
		double endVal = 14.9;
		while (startVal<=endVal)	{
			System.out.println(startVal);
			startVal = startVal+increment;
		}
	}
	
	// Method to run while loop for specified time
	// Prints the number of loops every specified number of loops
	public int timer(long loopRunTime, int printInterval)	{
		int numberOfLoops=0;
		// Get system time in milliseconds
		long timeNow = System.currentTimeMillis();	
		while(System.currentTimeMillis() < timeNow + loopRunTime)	{
			// Increment numberOfLoops by 1
			numberOfLoops++;
			if (numberOfLoops % printInterval == 0)	{
				System.out.println(numberOfLoops);
			}
		}
		// Return total number of loops
		return numberOfLoops;
	}

}
