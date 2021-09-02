import java.util.Scanner;
public class Timeformat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the hh:mm:ss ");
		String time = sc.nextLine();
		System.out.println(time.substring(3,5));

	}

}
