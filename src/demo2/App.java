package demo2;

class Runner implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class App {

	public static void main(String[] args) {
		
		Runner runner1 = new Runner();
		Thread thread1 = new Thread(runner1);
		thread1.start();
		
		Runner runner2 = new Runner();
		Thread thread2 = new Thread(runner2);
		thread2.start();
		
	}
}
