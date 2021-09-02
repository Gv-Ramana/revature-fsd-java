
public class AverageCalculator {

	public static void main(String[] args) {
		//int[] score = {48, 55, 92, 78, 64};
		int[] score = new int[5];
		score[0]=48;
		score[1]=55;
		score[2]=92;
		score[3]=78;
		score[4]=64;
		//float average = (score[0]+score[1]+score[2]+score[3]+score[4]) / 5.0f;
		float average = (score[0]+score[1]+score[2]+score[3]+score[4]) / (float)score.length;
		System.out.println("Average = " +average);

	}

}
