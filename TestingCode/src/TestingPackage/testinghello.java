package TestingPackage;

public class testinghello {

	public static void main (String[] args) {
		
		String name = "Richard M. Nixon";
		boolean startWord = true;
		
		for (int i = 0; i < name.length(); i++) {
			   if (startWord)
			      System.out.print(name.charAt(i));
			   if (name.charAt(i) == ' ')
			      startWord = true;
			   else
			      startWord = false;
		
		}
	
	}
}
