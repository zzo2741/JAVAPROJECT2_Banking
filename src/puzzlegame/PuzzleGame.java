package puzzlegame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PuzzleGame
{
	public final int SHUFFLE_COUNT = 100;
	PuzzleMove pm = new PuzzleMove();

	public ArrayList<String> createPuzzle()
	{
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; list.size() < 9; i++)
		{
			list.add(Integer.toString(i));
		}
		int index = list.indexOf("9");
		list.set(index, "x");
		System.out.println("\n섞기 전");
		puzzleShow(list);
		System.out.println("");
		return list;
	}

	public ArrayList<String> shuffle()
	{
		int count = 1, idx;
		ArrayList<String> puzzleList = createPuzzle();
		String key = null;
		while (count <= SHUFFLE_COUNT)
		{
			int random = (int) (Math.random() * 4 + 1);
			switch (random)
			{
			case 1:
				key = "w";
				break;
			case 2:
				key = "a";
				break;
			case 3:
				key = "s";
				break;
			case 4:
				key = "d";
				break;
			}
			idx = puzzleList.indexOf("x");
			puzzleList = pm.suflMove(puzzleList, key, idx);
			count++;
		}
		System.out.println("섞기 후\t" + "[섞은 횟수 : " + SHUFFLE_COUNT + "]");
		puzzleShow(puzzleList);
		System.out.println("");
		return puzzleList;
	}

	public void gameStart(ArrayList<String> list)
	{
		System.out.println();
		System.out.println("게임 시작 후 퍼즐 모양");
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

	public void endGame()
	{
		System.out.println("게임을 종료합니다.");
	}

	public void gameStart()
	{
		ArrayList<String> list = null;
		int selNum = 0;
		while (true)
		{
			showMenu();
			try
			{
				Scanner scanner = new Scanner(System.in);
				selNum = scanner.nextInt();
				switch (selNum)
				{
				case 1:
					list = shuffle();
					break;
				case 2:
					gameStart(list);
					break;
				case 3:
					endGame();
					return;
				}
			} catch (Exception e)
			{
				System.out.println("숫자를 입력해주세요.\n");
			}

		}
	}

}