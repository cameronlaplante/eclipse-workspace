package projectZero;

public class DiceRollem {

	public static void main (String[] args) {
		
		//define all 5 dice objects
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		Dice die3 = new Dice();
		Dice die4 = new Dice();
		Dice die5 = new Dice();
		// accumulator variable
		int sum = 0; 
		
		//iterate for 1000 roles
		for(int i = 1; i<=1000; i++) {
			//roll each die 
			int dieOne = die1.roll();
			int dieTwo = die2.roll();
			int dieThree = die3.roll();
			int dieFour = die4.roll();
			int dieFive = die5.roll();
			
			//FOR TESTING ONLY: Print die values 
//			System.out.println(dieOne);
//			System.out.println(dieTwo);
//			System.out.println(dieThree);
//			System.out.println(dieFour);
//			System.out.println(dieFive);
//			System.out.println("----------");
			
			//determine if all dice have the same value. 
			if (dieOne == dieTwo && dieTwo == dieThree && dieThree == dieFour && dieFour == dieFive) {
				//add to accumulator variable
				sum = sum + 1;
				
				//print roll number and value of the dice. 
				System.out.println("Roll number " + i + " all dice show " + dieOne + ".");
			}	
		}
		//print total num times all dice were the same (accumulator variable) 
		System.out.println("A total of " + sum + " tosses were the same.");
	}	
}
