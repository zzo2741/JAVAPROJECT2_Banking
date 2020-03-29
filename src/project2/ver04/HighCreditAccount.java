package project2.ver04;

public class HighCreditAccount extends Account
{
	private double basicInterest;
	private String creditRating;

	public HighCreditAccount(String accountNumber, String name, int balance, double basicInterest, String creditRating)
	{
		super(accountNumber, name, balance);
		this.basicInterest = basicInterest;
		this.creditRating = creditRating;
	}

	@Override
	public void showAccInfo()
	{
		super.showAccInfo();
		System.out.println("기본이자 : " + (int) basicInterest + "%");
		System.out.println("신용등급 : " + creditRating);

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

	@Override
	public String getCreditRating()
	{
		return creditRating;
	}

	@Override
	public void setCreditRating(String creditRating)
	{
		this.creditRating = creditRating;
	}

}
