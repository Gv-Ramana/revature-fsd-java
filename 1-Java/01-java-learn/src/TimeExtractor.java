import java.util.Scanner;
public class TimeExtractor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the time in hh:mm:ss format");
		String str =s.nextLine();
		System.out.println("Minutes : " + str.substring(3,5));
		

	}

}
