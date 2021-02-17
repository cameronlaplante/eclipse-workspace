package testingCodes;

public class SumMeUp {

	public static void main (String args[]) {
		int[][] aa = new int[4][3];
		int sum = 0;
		for (int i = 1; i < aa.length; i++) {
			for (int j = 1; j < aa[2].length; j++) {
				aa[i][j] = aa[i-1][j-1] + 1;
				sum += aa[i][j];
			}
		}
		
	System.out.println(sum);
		
	}
}
