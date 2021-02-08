package TestingPackage;

public class FishFrenzy {
	public static void main(String args[]){
		Acquarium bigTank = new Acquarium();
		Acquarium smallTank = new Acquarium();
		bigTank.addMoreFish(15);
		smallTank.addMoreFish(bigTank.getNumFish());
		smallTank.setNumFish(12);
		int totalFish = bigTank.getNumFish() + smallTank.getNumFish();
		System.out.println(totalFish);
	}
}
