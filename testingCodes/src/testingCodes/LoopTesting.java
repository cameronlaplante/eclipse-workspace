package testingCodes;

public class LoopTesting {

	public static void main (String[] args) {
		
		for(int i=1; i<=2000; i++) {
			if (i % 36 == 0) {
				if (i % 17 == 0) {
					System.out.println(i);
				}
			}
		}
	}
}