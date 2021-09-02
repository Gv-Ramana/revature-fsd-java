import java.util.Scanner;

public class TakingCelsiusfromKeyboard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the celsius: ");
		int celsius = sc.nextInt();
		float fahrenheit = (celsius*(float)9/5) + 32;
		System.out.println("Fahrenheit = " + fahrenheit);

	}

}
