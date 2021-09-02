import java.util.Scanner;
public class ShortName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String name = sc.next();
		if(name.length() >= 2 && name.length() <= 6) {
			System.out.println("This is a valid short name");
		}else {
			System.out.println("This is not a valid short name");
		}

	}

}
