package module8a;

public class SimpleThreadA extends Thread {
	
	public SimpleThreadA(String name) { super(name); }
	
	
	public void run() {
		System.out.println("Thread is now alive: "+getName());
	}
}
