package java_BANK;

public class Customer {
	private String ssn;
	private String name;
	private CheckingAccount checkingAccount;
	private SavingsAccount savingsAccount;
	public Customer() {
		
	}
	public Customer(String ssn,
			String name,
			CheckingAccount checkingAccount,
			SavingsAccount savingsAccount) {
		this.ssn=ssn;
		this.name=name;
		this.checkingAccount=checkingAccount;
		this.savingsAccount=savingsAccount;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	public String toString() {
		String msg;
		msg="���֤��Ϊ:"+this.ssn;
		msg+="\n����Ϊ:"+this.name;
		if(this.checkingAccount==null)
			msg+="\n"+this.savingsAccount.toString();
		else if(this.savingsAccount==null)
			msg+="\n"+this.checkingAccount.toString();
		else {
			msg+="\n�洢��:";
			msg+="\n"+this.savingsAccount.toString();
			msg+="\n���ÿ�:";
			msg+="\n"+this.checkingAccount.toString();
		}
		return msg;
		
		
		
	}

}
