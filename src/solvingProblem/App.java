package solvingProblem;

public class App {
	
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increment();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
	
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increment();
				}
			}
		});
	
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count: "+count);

		
	}
}
