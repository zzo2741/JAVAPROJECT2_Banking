package project2.ver03;

public class NormalAccount extends Account
{
	private double basicInterest;

	public NormalAccount(String accountNumber, String name, int balance, double basicInterest)
	{
		super(accountNumber, name, balance);
		this.basicInterest = basicInterest;
	}

	@Override
	public void showAccInfo()
	{
		super.showAccInfo();
		System.out.println("기본이자 : " + (int) basicInterest + "%");
	}

	@Override
	public double getBasicInterest()
	{
		return basicInterest;
	}

	@Override
	public void setBasicInterest(double basicInterest)
	{
		this.basicInterest = basicInterest;
	}

}
