import java.util.Scanner;
public class WeburlChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the website address: ");
		String url = sc.nextLine();
		
		if(url.startsWith("http://") || url.startsWith("https://")){
			System.out.println("This is a web url.");
		}else {
			System.out.println("This is not a web url.");
		}

	}

}
