
public class FahrenheitConverter {

	public static void main(String[] args) {
		System.out.println("Fahrenheit: " + toFahrenheit(12));

	}
	public static float toFahrenheit(float celsius) {
		float fahrenheit = (celsius * 9 / 5) + 32;
		return fahrenheit;
	}

}
