
public class AverageCalculatorLoop {

	public static void main(String[] args) {
		float scores[] = {23 ,43, 54,34,12};
		float total = 0.0f;
		//for(int i = 0; i < scores.length; i++) {
			//System.out.println(i);
			//System.out.println(scores[i]);
			// total += scores[i];
		for(float s : scores) {
			total += s;
			
			}
			System.out.println("the average = " + (total / scores.length));

	}

}
