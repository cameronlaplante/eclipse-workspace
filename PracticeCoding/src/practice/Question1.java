package practice;

public class Question1 {

	public static void printReverse(String input) {
		String reverse = "";
		for (int i = input.length() - 1; i>=0; i--) {
			reverse = reverse + input.charAt(i);
			
		}
		System.out.println(reverse);
		System.out.println("145".equals("145"));
		
	}
	
}
