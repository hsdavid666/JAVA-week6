package java_BANK;

public class CheckingAccount extends BankAccount {
	private double ServiceCharge;
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(String accountNum,double balance,double ServiceCharge) {
		super(accountNum,balance);
		this.ServiceCharge=ServiceCharge;
	}

	public double getServiceCharge() {
		return ServiceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.ServiceCharge = serviceCharge;
	}
	//��ȡ���ÿ������
	public void assessServiceChargee() {
		super.setBalance(super.getBalance()-this.ServiceCharge);
	}

	public String toString() {
		String msg=super.toString();
		msg+="\n�����Ϊ:"+this.ServiceCharge;
		return msg;
	}
}
