package module8a;

public class ThreadTesting {
	
	public static void main(String[] args) {
		SimpleThreadA t1 = new SimpleThreadA("first thread");
		t1.run();
		
		SimpleThreadB stb = new SimpleThreadB("second thread");
		Thread t2 = new Thread(stb);
		t2.start();


	}
}
