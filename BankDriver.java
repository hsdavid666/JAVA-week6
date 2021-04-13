package java_BANK;

import java.util.Scanner;

public class BankDriver {
	public static Customer customer = null;
	public static CheckingAccount ca = null;
	public static SavingsAccount sa = null;
	public static int card;

	public static void main(String[] args) {

		int choice = menu();
		int i;
		while (choice != 8) {
			switch (choice) {
			case 1:
				i = submenu();
				switch (i) {
				case 1:
					createSavingsAccount();
					break;
				case 2:
					createCheckingAccount();
					break;
				case 3:
					break;
				default:
					System.out.println("输入错误！请重新输入！");
					break;
				}
				break;
			case 2:
				save();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				comsume();
				break;
			case 5:
				repay();
				break;
			case 6:
				settle();
				break;
			case 7:
				balance();
				break;
			case 8:
				break;
			default:
				System.out.println("请输入正确的选择!");

			}
			choice = menu();
		}
	}

	public static int menu() {

		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("\n欢迎使用银行系统");
		System.out.println("1.开户");
		System.out.println("2.存款");
		System.out.println("3.取款");
		System.out.println("4.消费");
		System.out.println("5.还款");
		System.out.println("6.银行结算");
		System.out.println("7.查询余额");
		System.out.println("8.退出");
		System.out.print("请选择(1-8):");
		choice = scan.nextInt();
		return choice;
	}

	public static int submenu() {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("请选择开卡类型:");
		System.out.println("1.存储卡");
		System.out.println("2.信用卡");
		System.out.println("3.返回");
		System.out.print("请选择(1-3):");
		choice = scan.nextInt();
		return choice;
	}

	public static void createCheckingAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入身份证号:");
		String ssn = scan.next();
		System.out.print("请输入姓名:");
		String name = scan.next();
		System.out.print("请输入开卡的卡号:");
		String accountNum = scan.next();
		System.out.print("请输入年服务费:");
		double ServiceCharge = scan.nextDouble();

		ca = new CheckingAccount(accountNum, 0, ServiceCharge);
		if (customer == null)
			customer = new Customer(ssn, name, ca, null);
		else {
			customer = new Customer(ssn, name, ca, sa);
		}
		if (customer.getCheckingAccount() != null)
			System.out.println(customer.toString());
	}

	public static void createSavingsAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入身份证号:");
		String ssn = scan.next();
		System.out.print("请输入姓名:");
		String name = scan.next();
		System.out.print("请输入开卡的卡号:");
		String accountNum = scan.next();
		System.out.print("请输入利息率:");
		double Interest = scan.nextDouble();

		sa = new SavingsAccount(accountNum, 0, Interest);
		if (customer == null)
			customer = new Customer(ssn, name, null, sa);
		else {
			customer = new Customer(ssn, name, ca, sa);
		}
		if (customer.getSavingsAccount() != null)
			System.out.println(customer.toString());
	}

	public static void save() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请确认操作对象(1.存储卡 2.信用卡):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("请先开通存储卡!");
		else if (card == 2 && ca == null)
			System.out.println("请先开通信用卡!");
		else if (card != 1 && card != 2)
			System.out.println("请输入正确选项!");
		else {
			System.out.print("请输入存款金额:");
			double money = scan.nextDouble();
			if (card == 1) {
				sa.setBalance(customer.getSavingsAccount().getBalance() + money);
				customer.setSavingsAccount(sa);
				System.out.println("存款成功!");
			} else if (card == 2) {
				ca.setBalance(customer.getCheckingAccount().getBalance() + money);
				customer.setCheckingAccount(ca);
				System.out.println("存款成功!");
			}
		}
	}

	public static void withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请确认操作对象(1.存储卡 2.信用卡):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("请先开通存储卡!");
		else if (card == 2 && ca == null)
			System.out.println("请先开通信用卡!");
		else if (card != 1 && card != 2)
			System.out.println("请输入正确选项!");
		else {
			System.out.print("请输入取款金额:");
			double money = scan.nextDouble();
			if (card == 1) {
				if (customer.getSavingsAccount().getBalance() < money)
					System.out.println("余额不足！取款失败！");
				else {
					customer.getSavingsAccount().setBalance(customer.getSavingsAccount().getBalance() - money);
					System.out.println("取款成功!");
				}
			} else if (card == 2) {
				if (customer.getCheckingAccount().getBalance() < money)
					System.out.println("余额不足！取款失败！");
				else {
					customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - money);
					System.out.println("取款成功!");
				}
			}
		}
	}

	public static void comsume() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请确认操作对象(1.存储卡 2.信用卡):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("请先开通存储卡!");
		else if (card == 2 && ca == null)
			System.out.println("请先开通信用卡!");
		else if (card != 1 && card != 2)
			System.out.println("请输入正确选项!");
		else {
			System.out.print("请输入消费金额:");
			double money = scan.nextDouble();
			if (card == 1) {
				if (customer.getSavingsAccount().getBalance() < money)
					System.out.println("余额不足！！！");
				else {
					customer.getSavingsAccount().setBalance(customer.getSavingsAccount().getBalance() - money);
					System.out.println("消费成功!");
				}
			} else if (card == 2) {
				customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - money);
				System.out.println("消费成功!");
			}
		}
	}

	public static void repay() {
		Scanner scan = new Scanner(System.in);
		if (customer.getCheckingAccount().getBalance() < 0) {
			System.out.println("当前需还款" + customer.getCheckingAccount().getBalance() * -1);
			System.out.print("请输入还款金额:");
			double money = scan.nextDouble();
			customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() + money);
			System.out.println("还款成功!");
		} else
			System.out.println("当前无需还款!" + customer.getCheckingAccount().getBalance());
	}

	public static void settle() {
		customer.getCheckingAccount().assessServiceChargee();
		System.out.println("信用卡服务费结算完毕!");
		customer.getSavingsAccount().payInterest();
		System.out.println("存储卡利息结算完毕!");
	}

	public static void balance() {
		if (customer.getSavingsAccount() == null)
			System.out.println("当前信用卡余额为:" + customer.getCheckingAccount().getBalance());
		else if (customer.getCheckingAccount() == null)
			System.out.println("当前存储卡余额为:" + customer.getSavingsAccount().getBalance());
		else {
			System.out.println("当前信用卡余额为:" + customer.getCheckingAccount().getBalance());
			System.out.println("当前存储卡余额为:" + customer.getSavingsAccount().getBalance());
		}

	}

}
