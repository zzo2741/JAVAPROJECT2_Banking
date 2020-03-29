package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

import project2.ver04.AccountManager;
import project2.ver04.MenuChoice;
import project2.ver04.MenuSelectException;

public class BankingSystemVer04 implements MenuChoice
{

	public static void main(String[] args)
	{
		AccountManager am = new AccountManager();

		while (true)
		{
			am.showMenu();
			int selNum;

			Scanner sc = new Scanner(System.in);
			try
			{
				selNum = sc.nextInt();
				if (selNum < 1 || selNum > 5)
				{
					throw new MenuSelectException("잘못된 선택입니다.");
				}
			} catch (InputMismatchException e)
			{
				System.out.println("숫자를 입력해주세요.");
				continue;
			} catch (MenuSelectException e)
			{
				continue;
			}

			switch (selNum)
			{
			case MAKE:
				am.makeAccount();
				break;

			case DEPOSIT:
				am.depositMoney();
				break;

			case WITHDRAW:
				am.withdrawMoney();
				break;

			case INQUIRE:
				am.loadAccountInfo();
				am.showInfo();
				break;

			case EXIT:
				am.saveAccountInfo();
				am.exit();
				break;
			}

		}
	}
}
