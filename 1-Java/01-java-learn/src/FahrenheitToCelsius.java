import java.util.Scanner;
public class FahrenheitToCelsius {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the fahrenheit value = ");
		float fah = s.nextFloat();
		float cel = ((fah-35)*5)/9f;
		System.out.println("the celsius  value = " + cel);
		

	}

}
