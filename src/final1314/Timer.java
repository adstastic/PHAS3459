package final1314;

public class Timer {
	protected long start;
	protected long end;
	
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
