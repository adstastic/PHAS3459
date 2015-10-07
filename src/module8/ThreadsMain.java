package module8;

/**
 * Class to test multi threading that will spawn two threads to run simultaneously 
 * @author Aditya Mukherjee
 */
public class ThreadsMain {

	public static void main(String[] args) {
		
		// Starts a countdown timer and a prime number finding task on separate threads
		Thread countdown = new Thread(new CountdownTask(10000));
		Thread primes = new Thread(new PrimeNumberTask());
		countdown.start();
		primes.start();
		
		// waits for join() method of countdown to return before proceeding
		try {
			countdown.join();	
		} 
		// Catch any exceptions due to interruption
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		// primes is interrupted once countdown has finished
		primes.interrupt();
	}

}
