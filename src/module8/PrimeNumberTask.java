package module8;

import java.util.ArrayList;

/**
 * Class to find prime numbers
 * @author Aditya Mukherjee
 *
 */
public class PrimeNumberTask implements Runnable {
	// List to store found primes
	private ArrayList<Integer> primes = new ArrayList<Integer>();

	// Getter for list of primes
	public ArrayList<Integer> getPrimes() {
		return primes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Start finding primes from 2
		int n = 2;
		// while loop to run until stopped
		while (true) {
			// call private method to check if current number is prime
			if (isPrime(n)) {
				primes.add(n);
			}
			n++;
			// Check if this thread has been interrupted
			if (Thread.currentThread().isInterrupted()) {
				// print statistics about primes found and return thread
				System.out.println("Largest number checked: "+n);
				System.out.println("Largest prime found: "+primes.get(primes.size()-1));
				System.out.println("Number of primes found: "+primes.size());
				return;
			}
		}
	}
	
	
	/**
	 * Method to check if integers are prime
	 * @param n integer to be checked if prime
	 * @return boolean indicating whether input is prime or not
	 */
	public boolean isPrime(int n) {
		// iterate up from 2 to n-1
		for (int i=2; i<n; i++) {
			// if n is prime, no number between 2 and n-1 should divide n evenly
			// if any number in this range divides n evenly, n is not prime
			if (n%i == 0) {
				return false;
			} 
		} 
		return true;
	}

}
