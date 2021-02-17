package practice;

public class TESTING {

	
	public static void main(String[] args) {
	
		int numQuarters = 15 %4;
		switch(numQuarters) {
			case 1: 
				System.out.print(1+3);
			case 2: 
				System.out.print("3+1");
			case 3: 
				System.out.print(4+1);
			case 4: 
				System.out.print(3/2);
				break;
			default:
				System.out.print("other");
		}
		System.out.println("3+1");
	}
	
	
	
	
}
