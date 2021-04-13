package java_BANK;

public class SavingsAccount extends BankAccount{
	private double Interest;
	public SavingsAccount() {
		super();
	}
	public SavingsAccount(String accountNum,double balance,double Interest) {
		super(accountNum,balance);
		this.Interest=Interest;
	}
	public double getInterest() {
		return Interest;
	}
	public void setInterest(double interest) {
		Interest = interest;
	}
	public void payInterest() {
		super.setBalance(super.getBalance()*(1+this.Interest));
	}
	public String toString() {
		String msg=super.toString();
		msg+="\n利息率为:"+this.Interest;
		return msg;
	}
}

