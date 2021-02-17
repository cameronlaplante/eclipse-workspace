package TestingPackage;

public class TestingProblems {

	public static void main (String[] args) {
		
		String name = "Richard M. Nixon";
		boolean startWord = true;
		int i = 0;
		
		for (i=0; i < name.length(); i++) {
			if (startWord) {
				System.out.print(name.charAt(i));
			}
			if (name.charAt(i) == ' ') {
				startWord = true;
			}
			else {
				startWord = false;
			}
				
		}
		
		
	}
	
}
