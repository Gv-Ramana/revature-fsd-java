import java.util.Scanner;

public class MenuTillExit {

	public static void main(String[] args) {
		System.out.println("Menu");
		System.out.println("===");
		System.out.println("1.Balance Enquiry");
		System.out.println("2.Recharge");
		System.out.println("3.Change Caller Tune");
		System.out.println("4.Exit");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an option: ");
		int option = sc.nextInt();
		
		switch(option) {
		  case 1:
			System.out.println("Balance Enquiry");
			System.out.println();
			System.out.println("Menu");
			System.out.println("===");
			System.out.println("1.Balance Enquiry");
			System.out.println("2.Recharge");
			System.out.println("3.Change Caller Tune");
			System.out.println("4.Exit");
			System.out.println();
			//option = 0;
			System.out.println("Choose an option: ");
			option = sc.nextInt();
		
		  case 2:
			System.out.println("Recharge");
			System.out.println();
			System.out.println("Menu");
			System.out.println("===");
			System.out.println("1.Balance Enquiry");
			System.out.println("2.Recharge");
			System.out.println("3.Change Caller Tune");
			System.out.println("4.Exit");
			System.out.println();
			//option = 0;
			System.out.println("Choose an option: ");
			option = sc.nextInt();
		  
		  case 3:
			System.out.println("Change Caller Tune");
			System.out.println();
			System.out.println("Menu");
			System.out.println("===");
			System.out.println("1.Balance Enquiry");
			System.out.println("2.Recharge");
			System.out.println("3.Change Caller Tune");
			System.out.println("4.Exit");
			System.out.println();
			//option = 0;
			System.out.println("Choose an option: ");
			option = sc.nextInt();
		  
		  case 4:
			System.out.println("Exit");
			break;
		}

	}

}
