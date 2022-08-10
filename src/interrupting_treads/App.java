package interrupting_treads;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Starting..");
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random random = new Random();
				
				for(int i=0;i<1E7;i++) {
					Math.sin(random.nextDouble());
				}
			}
		});
		
		thread.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		thread.interrupt();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			InterruptedException ex = (InterruptedException) e.getCause();
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Finished");
	}

}
