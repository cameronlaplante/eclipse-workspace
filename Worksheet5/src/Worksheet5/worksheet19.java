package Worksheet5;

public class worksheet19 {
	
	
	
	static int DoubleTrouble(int num) {
		if (num % 3 ==1) {
			return 3;
		}
		else {
			return DoubleTrouble(num-1) + DoubleTrouble(num-1);
		}
	}
	
	

	public static void main(String[] args) {

		System.out.println(DoubleTrouble(18));
		
		
		
	}
	
}
