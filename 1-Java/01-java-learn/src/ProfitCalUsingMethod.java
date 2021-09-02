import java.util.Scanner;

public class ProfitCalUsingMethod {
	public int profitCal(int buyingPrice, int sellingPrice) {
		
		int profit = sellingPrice - buyingPrice;
		return profit;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter buying price: ");
		int bPrice = sc.nextInt();
		System.out.println("Enter selling price: ");
		int sPrice = sc.nextInt();
		
		ProfitCalUsingMethod pc = new ProfitCalUsingMethod();
		
		int result = pc.profitCal(bPrice, sPrice);
		System.out.println("profit: " + result);
		
	}
	
}
