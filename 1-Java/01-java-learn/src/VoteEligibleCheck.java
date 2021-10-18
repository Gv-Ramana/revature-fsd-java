import java.util.Scanner;
public class VoteEligibleCheck {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter your age");
		int a= s.nextInt();
		if(a >= 18) {
			System.out.println("your are eligible to vote");
			
		}
		else {
			System.out.println("not eligible to vote");
		}
		s.close();

	}
	

}
