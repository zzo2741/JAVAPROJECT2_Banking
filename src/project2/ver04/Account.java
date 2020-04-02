package project2.ver04;

import java.io.Serializable;

public abstract class Account implements Serializable
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj)
//	{
//		Account acc = (Account) obj;
//
//		if (acc.accountNumber.equals(this.accountNumber))
//		{
//			return true;
//		} else
//		{
//			return false;
//		}
//	}

	public abstract double getBasicInterest();

	public abstract void setBasicInterest(double basicInterest);

	public String getCreditRating()
	{
		return "NORMAL";
	}

	public void setCreditRating(String creditRating)
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
