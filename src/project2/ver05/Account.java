package project2.ver05;

import java.util.Scanner;

public class Account
{

	private String accountNumber;
	private String name;
	private int balance;

	public void makeAccount()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호 : ");
		accountNumber = scanner.nextLine();
		System.out.print("고객이름 : ");
		name = scanner.nextLine();
		System.out.print("잔    고 : ");
		balance = scanner.nextInt();
		System.out.println("계좌개설이 완료되었습니다.\n");
	}

	public void showAccInfo()
	{
		System.out.println("------------------");
		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("고객이름 : " + name);
		System.out.println("잔    고 : " + balance);
		System.out.println("------------------");
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}

}
