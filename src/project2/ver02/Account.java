package project2.ver02;

public class Account
{
	private String accountNumber;
	private String name;
	private int balance;

	public Account(String accountNumber, String name, int balance)
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public void showAccInfo()
	{
		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("고객이름 : " + name);
		System.out.println("잔    고 : " + balance);
	}

	public String getCreditRating()
	{
		return "NORMAL";
	}

	public void setCreditRating(String creditRating)
	{
	}

	public double getBasicInterest()
	{
		return 0;
	}

	public void setBasicInterest(double basicInterest)
	{
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
