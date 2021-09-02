
public class AvgCalculatorLoop {

	public static void main(String[] args) {
		float[] score = {48, 55, 92, 78, 64};
		float total = 0.0f;
		/*for(int i = 0; i < score.length; i++) {
			//System.out.println(score[i]);
			total += score[i];
			
		}*/
		
		//Enhanced for loop
		for (float scores : score) {
			total += scores;
		}
		System.out.println("Average = " + (total / score.length));

	}

}
