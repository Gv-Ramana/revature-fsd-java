
public class Transaction {

	private char type;
	private double amount;
	
	//Constructor
	public Transaction(char type, double amount) {
		this.type = type;
		this.amount = amount;
		//this keyword is used for current obj instance variable.
	}
	
	public void displayTransaction(double balance) {
		System.out.printf("   %c %12.2f %8.2f\n", type, amount, balance);
	}
	
	public static void main(String[] args) {
		Transaction transaction = new Transaction('W', 500);
		transaction.displayTransaction(2000);
	}
}
