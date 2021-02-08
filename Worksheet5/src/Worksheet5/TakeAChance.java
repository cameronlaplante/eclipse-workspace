package Worksheet5;

public class TakeAChance {
	public static void main(String args[]){
		String funkyWord = new String("aa"); // a type of lava!
		funkyWord = funkyWord + funkyWord;String extraFunky = funkyWord.replace("a", "b");
		for (int i=0; i<extraFunky.length(); i++){
			if (i < 1){
				extraFunky = "a" + extraFunky;
			}
		}
		extraFunky = extraFunky.substring(0,3);
		extraFunky = extraFunky + "a";
		System.out.println(extraFunky);
	}
}
