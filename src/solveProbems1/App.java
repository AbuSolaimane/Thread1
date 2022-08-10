package solveProbems1;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		while(running) {
			System.out.println("hello");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		this.running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor p1 = new Processor();
		p1.start();
		
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		p1.shutdown();
		scanner.close();
	}
	
}
