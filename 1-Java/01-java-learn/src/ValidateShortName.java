import java.util.Scanner;
public class ValidateShortName {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 System.out.println(" enter the string");
	     String str = s.nextLine();
	    // System.out.print(str);
	     if(str.length()>2 && str.length()<7) {
	    	 System.out.println(str + " is a valid short name");
	     }
	     else {
	    	 System.out.println(str + "  is not a valid short name");
	     }
	     
	     

	}

}
