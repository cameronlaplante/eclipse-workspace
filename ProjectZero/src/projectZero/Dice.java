package projectZero;

public class Dice {

	//max face value
	private final int maxRoll = 7; 
	//current value shown
	private int diceVal;  
	
	//define dice class 
	public Dice() {
		diceVal = 1;
	}
	
	//roll dice and return result 
	public int roll() {
		diceVal = (int)(Math.random() * maxRoll) + 1;
		return diceVal;
	}
	
	//
}
