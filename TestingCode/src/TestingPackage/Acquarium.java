package TestingPackage;

public class Acquarium {
	
	private int numFish = 12;
	public int numSquid;
	
	public void addMoreFish(int numFishies){
		if (numFishies > 10){
			numFish = multiplyAmount(2);
		}else{
			numFish = multiplyAmount(3);
		}
	}
	private int multiplyAmount(int value){
		return numFish * value;
	}
	public void setNumFish(int fishCount){
		numFish = fishCount;
	}
	public int getNumFish(){
		return numFish;
	}
}
