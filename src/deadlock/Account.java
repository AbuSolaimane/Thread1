package deadlock;

public class Account {

	private int balance = 10000;
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withDraw(int amount) {
		this.balance -= amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withDraw(amount);
		acc2.deposit(amount);
	}
}
