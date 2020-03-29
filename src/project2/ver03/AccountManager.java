package project2.ver03;

import java.util.InputMismatchException;
import java.util.Scanner;

class NegativeException extends Exception
{
	public NegativeException()
	{
		super("음수는 입력할 수 없습니다.");
	}
}

class DepositException extends Exception
{
	public DepositException()
	{
		super("입금할 수 없는 금액입니다.");
	}
}

class WithdrawException1 extends Exception
{
	public WithdrawException1()
	{
		System.out.print("잔고가 부족합니다. 금액전체를 출금할까요? (y/n) : ");
	}
}

class WithdrawException2 extends Exception
{
	public WithdrawException2()
	{
		System.out.println("출금할 수 없는 금액입니다.");
	}
}

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
		int plusBalance = 0;

		System.out.println("***입    금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("입금액 : ");
		try
		{
			plusBalance = scanner.nextInt();
			if (plusBalance < 0)
			{
				throw new NegativeException();
			} else if (plusBalance % 500 != 0)
			{
				throw new DepositException();
			}
		} catch (NegativeException e)
		{
			System.out.println(e.getMessage());
			return;
		} catch (DepositException e)
		{
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e)
		{
			System.out.println("숫자를 입력해주세요.");
			return;
		}
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
				} else
				{
					calBalance = acc[i].getBalance() + (acc[i].getBalance() * (acc[i].getBasicInterest() / 100) + plusBalance);
					acc[i].setBalance((int) calBalance);
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
		int minusBalance = 0;

		try
		{
			minusBalance = scanner.nextInt();
			if (minusBalance < 0)
			{
				throw new NegativeException();
			} else if (minusBalance % 1000 != 0)
			{
				throw new WithdrawException2();
			}
		} catch (NegativeException e)
		{
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e)
		{
			System.out.println("숫자를 입력해주세요.");
			return;
		} catch (WithdrawException2 e)
		{
			return;
		}

		for (int i = 0; i < numOfAccount; i++)
		{
			if (serchAccNum.equals(acc[i].getAccountNumber()))
			{
				try
				{
					if (minusBalance > acc[i].getBalance())
					{
						throw new WithdrawException1();
					}
				} catch (WithdrawException1 e)
				{
					String answer = scanner.next();
					if ("y".equalsIgnoreCase(answer))
					{
						System.out.println("금액전체 출금처리");
						acc[i].setBalance(0);
						return;
					} else if ("n".equalsIgnoreCase(answer))
					{
						System.out.println("출금요청취소");
						return;
					}

				}
				acc[i].setBalance(acc[i].getBalance() - minusBalance);
			}

		}
		System.out.println("출금이 완료되었습니다.\n");
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
