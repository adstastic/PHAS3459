package module8a;

public class SimpleThreadB implements Runnable {
	private String _name;
	
	public SimpleThreadB(String name) {_name = name;}
	
	public void run() {
		System.out.println("Thread is now alive: "+_name);
	}

}
