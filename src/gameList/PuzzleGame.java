package gameList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class Puzzle
{
	public ArrayList<String> shuffle()
	{

		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		ArrayList<String> list = new ArrayList<>();
		while (list.size() < 9)
		{
			int ranNum = random.nextInt(9) + 1;
			if (list.contains(Integer.toString(ranNum)) == false)
			{
				list.add(Integer.toString(ranNum));
			}
		}
		int index = list.indexOf("9");
		list.set(index, "x");
		System.out.println("셔플메소드안");
		puzzleShow(list);
		return list;
	}

	public void gameStart()
	{
		ArrayList<String> puzzleList = shuffle();
		PuzzleMove pm = new PuzzleMove();
		System.out.println();
		System.out.println("게임스타트 메소드 안");
		puzzleShow(puzzleList);
		pm.puzzleMove(puzzleList);

	}

	public void puzzleShow(ArrayList<String> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");

			if (i == 2 || i == 5)
			{
				System.out.println();
			}

		}
		System.out.println();
	}

	public void showMenu()
	{
		System.out.println("3by3퍼즐게임을 시작합니다.");
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1. 퍼즐 섞기");
		System.out.println("2. 게임 종료");
		System.out.print("선택 : ");
	}

}

public class PuzzleGame
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		Puzzle puzzle = new Puzzle();

		while (true)
		{

			puzzle.showMenu();
			int selNum = scanner.nextInt();
			switch (selNum)
			{
			case 1:
				puzzle.gameStart();
				break;
			case 2:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

}
