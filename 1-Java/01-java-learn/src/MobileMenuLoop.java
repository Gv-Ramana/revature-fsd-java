 import java.util.Scanner;

public class MobileMenuLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int option = 0;
		while (option <= 4) {
			System.out.println("menu");
			System.out.println("===");
			System.out.println("1. Balance enquiry");
			System.out.println("2. Recharge");
			System.out.println("3. Change Caller Tune");
			System.out.println("4. exit");
			System.out.println("choose an option");
			int option1 = sc.nextInt();

			switch (option1) {

			case 1:
				System.out.println("1. Balance enquiry");
				break;
			case 2:
				System.out.println("2. Recharge");
				break;
			case 3:
				System.out.println("3. Change Caller Tune");
				break;
			case 4:
				System.out.println("4. Exit");
				System.exit(0);
				break;

			}

		}

	}

}
