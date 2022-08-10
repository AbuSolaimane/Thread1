package seamaphrore;

import java.util.concurrent.Semaphore;

public class Connection {
	
	private Semaphore sem = new Semaphore(10, true);

	private static Connection instance = null;
	
	private int connections = 0;
	
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		if(instance == null) {
			instance = new Connection();
		}
		
		return instance;
	}
	
	public void connect() throws InterruptedException {
		sem.acquire();
		
		try {
			doConnect();
		} finally {
			sem.release();
		}
	}
	
	public void doConnect() throws InterruptedException {
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}
		
		Thread.sleep(1000);
		
		synchronized (this) {
			connections--;
		}
		
	}
}
