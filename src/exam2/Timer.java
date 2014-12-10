package exam2;

/**
 * Class to measure runtime of a program or block of code
 * @author Aditya Mukherjee
 *
 */
public class Timer {
	private long start;
	private long end;
	
	public Timer() {} 
	
	public void startTimer() { 
		this.start = System.currentTimeMillis(); 
		System.out.println("Started...\n");
	}
	
	public void endTimer() {
		this.end = System.currentTimeMillis();
		System.out.println("\nFinished in "+runtime()+" ms.");
	}
	
	public long runtime() {
		long runtime = end - start;
		return runtime;
	}	
}
