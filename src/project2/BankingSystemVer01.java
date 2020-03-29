package project2;

import java.util.Scanner;

import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 implements MenuChoice
{
	static Account[] account = new Account[50];
	static int numOfAccount = 0;

	public static void showMenu()
	{
		System.out.println("-----Menu-----");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입    금");
		System.out.println("3. 출    금");
		System.out.println("4. 계좌정보출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택 : ");
	}

	public static void depositMoney()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("***입    금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("입금액 : ");
		int addBalance = scanner.nextInt();
		System.out.println("입금이 완료되었습니다.\n");
		for (int i = 0; i < numOfAccount; i++)
		{
			if (serchAccNum.equals(account[i].getAccountNumber()))
			{
				account[i].setBalance(account[i].getBalance() + addBalance);
			}
		}
	}

	public static void withdrawMoney()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("***출    금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("출금액 : ");
		int addBalance = scanner.nextInt();
		System.out.println("출금이 완료되었습니다.\n");
		for (int i = 0; i < numOfAccount; i++)
		{
			if (serchAccNum.equals(account[i].getAccountNumber()))
			{
				account[i].setBalance(account[i].getBalance() - addBalance);
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			showMenu();
			int choiceNum = sc.nextInt();

			switch (choiceNum)
			{
			case MAKE:
				account[numOfAccount] = new Account();
				account[numOfAccount].makeAccount();
				numOfAccount++;
				break;

			case DEPOSIT:
				depositMoney();
				break;

			case WITHDRAW:
				withdrawMoney();
				break;

			case INQUIRE:
				System.out.println("***계좌정보출력***");
				for (int i = 0; i < numOfAccount; i++)
				{
					account[i].showAccInfo();
				}
				System.out.println("전체 계좌정보 출력이 완료되었습니다.\n");
				break;

			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}

		}
	}
}
