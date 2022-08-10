package wait_notify;

import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running...");
			wait();
			System.out.println("Resumed!");
		}
	}

	public void consumer() throws InterruptedException {
		Thread.sleep(2000);
		
		Scanner scanner = new Scanner(System.in);
		
		synchronized (this) {
			System.out.println("waiting for return key.");
			scanner.nextLine();
			System.out.println("return key pressed");
			notify();
		}
	}

}
