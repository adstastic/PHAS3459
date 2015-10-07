package module8;


/**
 * Class to count down a number of seconds and print the remaining time in seconds to console
 * @author Aditya Mukherjee
 *
 */
public class CountdownTask implements Runnable {
	// instance variable to store timer length
	private long seconds;
	
	public CountdownTask(long seconds) {
		this.seconds = seconds;
	}

	@Override
	public void run() {
		// Get system time at start of timer
		long start = System.currentTimeMillis();
		// The speed of the following while loop is fast enough that several iterations can pass before the system time changes
		// This resulted in the time dependent print statements inside the loop executing several times when only one was needed
		// this boolean is set to true after each print so subsequent iterations of the loop for the same millisecond do not print
		boolean isPrinted = false;
		// loop runs until time since start is equal to time of countdown
		while (System.currentTimeMillis()-start <= seconds) {
			long runtime = System.currentTimeMillis() - start;
			// if remaining time (in ms) divided by 1000 has no remainder, it is an integer number of seconds
			// if it has not already been printed, isPrinted is false
			if ((seconds-runtime)%1000 == 0 & isPrinted == false) {
				isPrinted = true;
				// if timer has reached end
				if ((seconds-runtime) == 0) {
					System.out.println("Finished!");	
				} else { // print remaining time in seconds
					System.out.println((seconds-runtime)/1000+" seconds remaining...");
				}
			} // if current time is not an integer number of seconds
			else if ((seconds-runtime)%1000 != 0) {
				isPrinted = false;
			}
		}
		return;
	}
	
	

}
