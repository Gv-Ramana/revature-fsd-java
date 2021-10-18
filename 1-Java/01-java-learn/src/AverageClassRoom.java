import java.util.Scanner;
 public class AverageClassRoom {
   public static void main(String args[]) {
	   int i;
    System.out.println("Enter number of sudents");
 
    Scanner sc=new Scanner(System.in);
 
    int n=sc.nextInt();
 
    int[] a=new int[n];
 
    double avg=0;
 
    
 
    for(i=0;i<n;i++)
    {
    	System.out.println("Student Score:");
       a[i]=sc.nextInt();
    }
 
    for(i=0;i<n;i++)
    {
      avg=avg+a[i];
    }
 
    System.out.println("average score " + avg/a.length);
  }
}