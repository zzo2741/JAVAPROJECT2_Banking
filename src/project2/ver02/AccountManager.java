package project2.ver02;

import java.util.Scanner;

public class AccountManager implements CustomSpecialRate
{
	private int numOfAccount;
	private Account[] acc;

	public AccountManager(int num)
	{
		acc = new Account[num];
		numOfAccount = 0;
	}

	public void showMenu()
	{
		System.out.println("-----Menu-----");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입    금");
		System.out.println("3. 출    금");
		System.out.println("4. 계좌정보출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택 : ");
	}

	public void makeAccount()
	{
		String inputAccountNumber, inputName, inputCreditRating;
		int inputBalance;
		double inputBasicRate;
		Scanner scanner = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1. 보통계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.print("선택 : ");
		int selNum = scanner.nextInt();
		System.out.print("계좌번호 : ");
		inputAccountNumber = scanner.next();
		System.out.print("고객이름 : ");
		inputName = scanner.next();
		System.out.print("잔    고 : ");
		inputBalance = scanner.nextInt();
		System.out.print("기본이자% (정수형태로 입력) : ");
		inputBasicRate = scanner.nextInt();
		switch (selNum)
		{
		case NORMAL_ACCOUNT:
			acc[numOfAccount++] = new NormalAccount(inputAccountNumber, inputName, inputBalance, inputBasicRate);
			break;

		case HIGHCREDIT_ACCOUNT:
			System.out.print("신용등급 (A, B, C등급) : ");
			inputCreditRating = scanner.next();
			acc[numOfAccount++] = new HighCreditAccount(inputAccountNumber, inputName, inputBalance, inputBasicRate, inputCreditRating);
			break;
		}
		System.out.println("계좌개설이 완료되었습니다.\n");
	}

	public void depositMoney()
	{
		Scanner scanner = new Scanner(System.in);
		double calBalance = 0;
		System.out.println("***입    금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("입금액 : ");
		int plusBalance = scanner.nextInt();
		for (int i = 0; i < numOfAccount; i++)
		{
			if (serchAccNum.equals(acc[i].getAccountNumber()))
			{
				if (acc[i].getCreditRating().equals("A"))
				{
					calBalance = acc[i].getBalance()
							+ (acc[i].getBalance() * (acc[i].getBasicInterest() / 100) + (acc[i].getBalance() * A) + plusBalance);

					acc[i].setBalance((int) calBalance);
				} else if (acc[i].getCreditRating().equals("B"))
				{
					calBalance = acc[i].getBalance()
							+ (acc[i].getBalance() * (acc[i].getBasicInterest() / 100) + (acc[i].getBalance() * B) + plusBalance);
					acc[i].setBalance((int) calBalance);
				} else if (acc[i].getCreditRating().equals("C"))
				{
					calBalance = acc[i].getBalance()
							+ (acc[i].getBalance() * (acc[i].getBasicInterest() / 100) + (acc[i].getBalance() * C) + plusBalance);
					acc[i].setBalance((int) calBalance);
				} else if (acc[i].getCreditRating().equals("NORMAL"))
				{
					calBalance = acc[i].getBalance() + (acc[i].getBalance() * (acc[i].getBasicInterest() / 100) + plusBalance);
					acc[i].setBalance((int) calBalance);
				} else
				{

				}

			}
		}
		System.out.println("입금이 완료되었습니다.\n");
	}

	public void withdrawMoney()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("***출    금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("출금액 : ");
		int minusBalance = scanner.nextInt();
		System.out.println("출금이 완료되었습니다.\n");
		for (int i = 0; i < numOfAccount; i++)
		{
			if (serchAccNum.equals(acc[i].getAccountNumber()))
			{
				acc[i].setBalance(acc[i].getBalance() - minusBalance);
			}
		}
	}

	public void showInfo()
	{
		System.out.println("***계좌정보출력***");
		for (int i = 0; i < numOfAccount; i++)
		{
			System.out.println("------------------");
			acc[i].showAccInfo();
			System.out.println("------------------");

		}
		System.out.println("전체 계좌정보 출력이 완료되었습니다.\n");
	}

	public void exit()
	{
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

}
