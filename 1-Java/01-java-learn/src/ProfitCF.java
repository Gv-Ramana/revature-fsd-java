
public class ProfitCF {

	public static void main(String[] args) {
		System.out.println("profit = " + profitCalculator(40,70));

	}
	public static int profitCalculator(int buyingPrice, int sellingPrice) {
		int profit = sellingPrice - buyingPrice;
		return profit;
	}

}
