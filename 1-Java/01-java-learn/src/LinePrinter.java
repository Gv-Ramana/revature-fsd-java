
public class LinePrinter {

	public static void main(String[] args) {
		//LinePrinter.printLine();
		printLine();
		printLine(15);
		printLine(10);
		printLine(25);

	}
	public static void printLine() {
		System.out.println("-------------------------");
	}
	public static void printLine(int numberofCharacters) {
		for (int i = 0; i < numberofCharacters; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
