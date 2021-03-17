package exam2;

import java.util.Stack;

public class PracticeTest {

	public static void main(String[] args) {
		
		int[][] randArray = {{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};
		
//		arraySum(randArray);
		
//		stringInfo("Cameron");
		
//		stringInfo("cameron", 7);
		
		System.out.print(true == false || false != false || true);
		System.out.println("t" + "r" + "ue");
		
	}
	
	//sum all elements in array.
	public static int arraySum(int[][] sumMe) {
		
		int sum = 0;
		
		for(int i = 0; i < sumMe.length; i++) {
			for (int j = 0; j < sumMe[i].length; j++) {
				sum = sum + sumMe[i][j];
			}
		}
		return sum;
	}
	
	//Determine if num chars in string matches provided int. 
	public static void stringInfo(String anStr, int anInt) {
		
		if (anInt == anStr.length()) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	//return num characters in str.
	public static int stringInfo(String anStr) {
		
		int strLength = anStr.length();
		return strLength;
	}
	
	//reverse polish notation calculator
	public static void evaluate(String postfix) {
		Stack<Double> Stack = new Stack<>();
		
		
	}
	
	
	
}
