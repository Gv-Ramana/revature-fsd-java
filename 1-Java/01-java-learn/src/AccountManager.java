
public class AccountManager {

	public static void main(String[] args) {
		String accountNumber = "01302343798";
		double balance = 5000;
		System.out.println("Account Statement of  " + accountNumber);
		System.out.println("Initial Balance:  " + balance);
		System.out.println("\n--------------------------");
		System.out.println("Type Transaction Balance");
		System.out.println("--------------------------");
		
	/*	char type = 'W';
		double transaction = 2000.0;
		balance -= transaction;
		System.out.printf("   %c %12.2f %8.2f\n",type, transaction, balance);
		
	    type = 'D';
		transaction = 20000.0;
		balance += transaction;
		System.out.printf("   %c %12.2f %8.2f\n",type, transaction, balance);
		
	    type = 'D';
	    transaction = 5000.0;
		balance += transaction;
		System.out.printf("   %c %12.2f %8.2f\n",type, transaction, balance);
		
	     type = 'W';
		 transaction = 15500.0;
	     balance -= transaction;
		 System.out.printf("   %c %12.2f %8.2f\n",type, transaction, balance);
			
	     type = 'W';
	     transaction =10000.0;
		 balance -= transaction;
		 System.out.printf("   %c %12.2f %8.2f\n",type, transaction, balance);
				
		 System.out.println("--------------------------");	*/
			
		balance = calculateBalanceAndprint('W', 2000.0, balance);
		balance = calculateBalanceAndprint('D', 20000.0, balance);
		balance = calculateBalanceAndprint('D', 500.0, balance);
		balance = calculateBalanceAndprint('W', 15500.0, balance);
		balance = calculateBalanceAndprint('W', 10000.0, balance);
		


	}
	
	public static double calculateBalanceAndprint(char type, double transaction, double balance) {
		if(type == 'D') {
			balance += transaction;
		}
		if(type == 'W') {
			balance -= transaction;
		}
		 System.out.printf("   %c %12.2f %8.2f\n", type, transaction,balance);
		 return balance;
			
	}

}
