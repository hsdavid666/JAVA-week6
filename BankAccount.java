package java_BANK;

public class BankAccount {
	private String accountNum;
	private double balance;
	public BankAccount() {
		super();
	}
	public BankAccount(String accountNum,double balance) {
		this.accountNum=accountNum;
		this.balance=balance;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		String msg="";
		msg="����Ϊ:"+this.accountNum;
		msg+="\n�������Ϊ:"+this.balance;
		return msg;
		
	}
}
