package Worksheet5;

public class References {
	public static void main(String args[]) {
		aLetter gammaChar = new aLetter();
		aLetter deltaChar = new aLetter();
		
		gammaChar.setLetter('g');
		System.out.print(gammaChar.getLetter());
		deltaChar.setLetter('d');
		System.out.print(deltaChar.getLetter());
		deltaChar = gammaChar;
		gammaChar.setLetter('e');
		System.out.print(deltaChar.getLetter());
	}
}
