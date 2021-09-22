import java.util.Scanner;
public class Prime {
 public static void main(String args[]) {
	 Scanner scan = new Scanner(System.in);
	 int t= scan.nextInt();
	 int n = scan.nextInt();
	 int count=0;
	 for(int i = 0;i<t;i++) {
		 for(int j = 0 ;j<n;j++) {
				 for(int k = 2;k<n/2;k++ ) {
					 if(j<=1) {
						 continue;
					 }else if(j%k == 0) {
						 continue;
						 }
					 
			 }count++;
		 }
	 }
 System.out.println(count);}
}