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
					System.out.println("����������������룡");
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
				System.out.println("��������ȷ��ѡ��!");

			}
			choice = menu();
		}
	}

	public static int menu() {

		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("\n��ӭʹ������ϵͳ");
		System.out.println("1.����");
		System.out.println("2.���");
		System.out.println("3.ȡ��");
		System.out.println("4.����");
		System.out.println("5.����");
		System.out.println("6.���н���");
		System.out.println("7.��ѯ���");
		System.out.println("8.�˳�");
		System.out.print("��ѡ��(1-8):");
		choice = scan.nextInt();
		return choice;
	}

	public static int submenu() {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("��ѡ�񿪿�����:");
		System.out.println("1.�洢��");
		System.out.println("2.���ÿ�");
		System.out.println("3.����");
		System.out.print("��ѡ��(1-3):");
		choice = scan.nextInt();
		return choice;
	}

	public static void createCheckingAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���������֤��:");
		String ssn = scan.next();
		System.out.print("����������:");
		String name = scan.next();
		System.out.print("�����뿪���Ŀ���:");
		String accountNum = scan.next();
		System.out.print("������������:");
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
		System.out.print("���������֤��:");
		String ssn = scan.next();
		System.out.print("����������:");
		String name = scan.next();
		System.out.print("�����뿪���Ŀ���:");
		String accountNum = scan.next();
		System.out.print("��������Ϣ��:");
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
		System.out.print("��ȷ�ϲ�������(1.�洢�� 2.���ÿ�):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("���ȿ�ͨ�洢��!");
		else if (card == 2 && ca == null)
			System.out.println("���ȿ�ͨ���ÿ�!");
		else if (card != 1 && card != 2)
			System.out.println("��������ȷѡ��!");
		else {
			System.out.print("����������:");
			double money = scan.nextDouble();
			if (card == 1) {
				sa.setBalance(customer.getSavingsAccount().getBalance() + money);
				customer.setSavingsAccount(sa);
				System.out.println("���ɹ�!");
			} else if (card == 2) {
				ca.setBalance(customer.getCheckingAccount().getBalance() + money);
				customer.setCheckingAccount(ca);
				System.out.println("���ɹ�!");
			}
		}
	}

	public static void withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.print("��ȷ�ϲ�������(1.�洢�� 2.���ÿ�):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("���ȿ�ͨ�洢��!");
		else if (card == 2 && ca == null)
			System.out.println("���ȿ�ͨ���ÿ�!");
		else if (card != 1 && card != 2)
			System.out.println("��������ȷѡ��!");
		else {
			System.out.print("������ȡ����:");
			double money = scan.nextDouble();
			if (card == 1) {
				if (customer.getSavingsAccount().getBalance() < money)
					System.out.println("���㣡ȡ��ʧ�ܣ�");
				else {
					customer.getSavingsAccount().setBalance(customer.getSavingsAccount().getBalance() - money);
					System.out.println("ȡ��ɹ�!");
				}
			} else if (card == 2) {
				if (customer.getCheckingAccount().getBalance() < money)
					System.out.println("���㣡ȡ��ʧ�ܣ�");
				else {
					customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - money);
					System.out.println("ȡ��ɹ�!");
				}
			}
		}
	}

	public static void comsume() {
		Scanner scan = new Scanner(System.in);
		System.out.print("��ȷ�ϲ�������(1.�洢�� 2.���ÿ�):");
		card = scan.nextInt();
		if (card == 1 && sa == null)
			System.out.println("���ȿ�ͨ�洢��!");
		else if (card == 2 && ca == null)
			System.out.println("���ȿ�ͨ���ÿ�!");
		else if (card != 1 && card != 2)
			System.out.println("��������ȷѡ��!");
		else {
			System.out.print("���������ѽ��:");
			double money = scan.nextDouble();
			if (card == 1) {
				if (customer.getSavingsAccount().getBalance() < money)
					System.out.println("���㣡����");
				else {
					customer.getSavingsAccount().setBalance(customer.getSavingsAccount().getBalance() - money);
					System.out.println("���ѳɹ�!");
				}
			} else if (card == 2) {
				customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - money);
				System.out.println("���ѳɹ�!");
			}
		}
	}

	public static void repay() {
		Scanner scan = new Scanner(System.in);
		if (customer.getCheckingAccount().getBalance() < 0) {
			System.out.println("��ǰ�軹��" + customer.getCheckingAccount().getBalance() * -1);
			System.out.print("�����뻹����:");
			double money = scan.nextDouble();
			customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() + money);
			System.out.println("����ɹ�!");
		} else
			System.out.println("��ǰ���軹��!" + customer.getCheckingAccount().getBalance());
	}

	public static void settle() {
		customer.getCheckingAccount().assessServiceChargee();
		System.out.println("���ÿ�����ѽ������!");
		customer.getSavingsAccount().payInterest();
		System.out.println("�洢����Ϣ�������!");
	}

	public static void balance() {
		if (customer.getSavingsAccount() == null)
			System.out.println("��ǰ���ÿ����Ϊ:" + customer.getCheckingAccount().getBalance());
		else if (customer.getCheckingAccount() == null)
			System.out.println("��ǰ�洢�����Ϊ:" + customer.getSavingsAccount().getBalance());
		else {
			System.out.println("��ǰ���ÿ����Ϊ:" + customer.getCheckingAccount().getBalance());
			System.out.println("��ǰ�洢�����Ϊ:" + customer.getSavingsAccount().getBalance());
		}

	}

}
