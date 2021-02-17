package testingCodes;

public class BankAccount {
	private String name;
	private int amount;
	private boolean overdraft;

	public BankAccount (String s, int amt) {
		name = s;
		amount = amt;
		overdraft = false;
	}
	public String getName() {
		return name;
	}
	public void updateAmount(int newAmount) {
		amount = newAmount;
	}
	
}