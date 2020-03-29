package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

import project2.ver03.AccountManager;
import project2.ver03.MenuChoice;
import project2.ver03.MenuSelectException;

public class BankingSystemVer03 implements MenuChoice
{
	public final static int MAX_SAVE_NUM = 50;

	public static void main(String[] args)
	{
		AccountManager am = new AccountManager(MAX_SAVE_NUM);

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
				am.showInfo();
				break;

			case EXIT:
				am.exit();
				break;
			}

		}
	}
}
