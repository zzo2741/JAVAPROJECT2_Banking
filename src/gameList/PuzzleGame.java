package gameList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Puzzle
{
	public ArrayList<String> createPuzzle()
	{

		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; list.size() < 9; i++)
		{
			list.add(Integer.toString(i));
		}

		int index = list.indexOf("9");
		list.set(index, "x");
		System.out.println("섞기 전");
		puzzleShow(list);
		return list;
	}

	public ArrayList<String> shuffle()
	{
		int count = 1;
		ArrayList<String> puzzleList = createPuzzle();
		while (count <= 3)
		{
			
			count++;
		}
		System.out.println("섞기 후");
		puzzleShow(puzzleList);
		return puzzleList;
	}

	public void gameStart(ArrayList<String> list)
	{
		PuzzleMove pm = new PuzzleMove();
		System.out.println();
		System.out.println("게임스타트 메소드 안");
		puzzleShow(list);
		pm.puzzleMove(list);

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
		System.out.println("2. 퍼즐 시작");
		System.out.println("3. 게임 종료");
		System.out.print("선택 : ");
	}

}

public class PuzzleGame
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Puzzle puzzle = new Puzzle();
		ArrayList<String> list = null;
		while (true)
		{

			puzzle.showMenu();
			int selNum = scanner.nextInt();
			switch (selNum)
			{
			case 1:
				list = puzzle.shuffle();
				break;
			case 2:
				puzzle.gameStart(list);
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

}
