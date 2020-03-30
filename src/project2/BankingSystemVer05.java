package project2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import project2.ver05.MenuChoice;

public class BankingSystemVer05 implements MenuChoice
{

	static public PreparedStatement psmt;
	static public Statement stmt;
	static public CallableStatement csmt;
	static public Connection con;
	static public ResultSet rs;

	static
	{
		String user = "kosmo";
		String pass = "1234";
		try
		{
			Class.forName(ORACLE_DRIVER);
			con = DriverManager.getConnection(ORALE_URL, user, pass);

			stmt = con.createStatement();
			String creatTableSql = "CREATE TABLE banking_tb (" + " idx number, accountnumber VARCHAR2(50), " + "name VARCHAR2(50), " + "balance NUMBER, "
					+ "PRIMARY KEY (accountnumber))";
			stmt.execute(creatTableSql);
			System.out.println("테이블을 생성하였습니다.");
		} catch (Exception e)
		{
			System.out.println("기존 테이블 이용");
		}
		try
		{
			stmt = con.createStatement();
			String createSeqSql = "CREATE SEQUENCE seq_banking NOCYCLE NOCACHE";
			stmt.execute(createSeqSql);
			System.out.println("시퀀스를 생성하였습니다.");
		} catch (Exception e)
		{
			System.out.println("기존 시퀀스 이용");
		} finally
		{
			close();
		}

	}

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
		int plusBalance = scanner.nextInt();

		String updateQuery = "UPDATE banking_tb SET balance = balance + ?  WHERE accountnumber = ?";
		try
		{
			psmt = con.prepareStatement(updateQuery);
			psmt.setInt(1, plusBalance);
			psmt.setString(2, serchAccNum);
			psmt.executeUpdate();

		} catch (Exception e)
		{
			System.out.println("입금실패");
			e.printStackTrace();
		} finally
		{
			close();
		}
		System.out.println("입금이 완료되었습니다.\n");
	}

	public static void withdrawMoney()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("***출    금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String serchAccNum = scanner.nextLine();
		System.out.print("출금액 : ");
		int minusBalance = scanner.nextInt();
		String updateQuery = "UPDATE banking_tb SET balance = balance - ?  WHERE accountnumber = ?";
		try
		{
			psmt = con.prepareStatement(updateQuery);
			psmt.setInt(1, minusBalance);
			psmt.setString(2, serchAccNum);
			psmt.executeUpdate();

		} catch (Exception e)
		{
			System.out.println("출금실패");
			e.printStackTrace();
		} finally
		{
			close();
		}
		System.out.println("출금이 완료되었습니다.\n");
	}

	public static void makeAccount()
	{
		String accountNumber, name;
		int balance;
		Scanner scanner = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호 : ");
		accountNumber = scanner.nextLine();
		System.out.print("고객이름 : ");
		name = scanner.nextLine();
		System.out.print("잔    고 : ");
		balance = scanner.nextInt();
		try
		{
			String insertQuery = "INSERT INTO banking_tb VALUES (seq_banking.NEXTVAL, ?, ?, ?)";
			psmt = con.prepareStatement(insertQuery);
			psmt.setString(1, accountNumber);
			psmt.setString(2, name);
			psmt.setInt(3, balance);
			psmt.executeUpdate();
		} catch (Exception e)
		{
			System.out.println("계좌개설 실패");
			e.printStackTrace();
		} finally
		{
			close();
		}
		System.out.println("계좌개설이 완료되었습니다.\n");

	}

	public static void showAccInfo()
	{
		System.out.println("***계좌정보출력***");
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(String.format("SELECT * FROM banking_tb WHERE accountnumber LIKE '%%'"));

			System.out.println("------------------");
			while (rs.next())
			{
				String accountnumber = rs.getString("accountnumber");
				String name = rs.getString("name");
				int balance = rs.getInt("balance");

				System.out.printf("계좌번호 : %-10s 이름 : %-10s 금액 : %-10s\n", accountnumber, name, balance);

			}
			System.out.println("------------------");

		} catch (Exception e)
		{
			System.out.println("계좌정보출력 실패");
			e.printStackTrace();
		} finally
		{
			close();
		}

	}

	public static void close()
	{
		try
		{
			if (psmt != null)
			{
				psmt.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (csmt != null)
			{
				csmt.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		} catch (Exception e)
		{
			System.out.println("자원반납을 할 수 없습니다.");
			e.printStackTrace();
		}
	}

	public static void exit()
	{
		try
		{
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
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
				makeAccount();
				break;

			case DEPOSIT:
				depositMoney();
				break;

			case WITHDRAW:
				withdrawMoney();
				break;

			case INQUIRE:
				showAccInfo();
				break;

			case EXIT:
				exit();
				break;
			}

		}

	}

}
