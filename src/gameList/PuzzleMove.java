package gameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PuzzleMove
{
	public void puzzleMove(ArrayList<String> list)
	{
		ArrayList<String> puzzleList = list;
		Puzzle puzzle = new Puzzle();
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (true)
		{
			index = list.indexOf("x");
			System.out.println("[ 이동 ] a : Left d : Right w : Up s : Down");
			System.out.println("[ 종료 ] x : Exit");
			System.out.print("키를 입력해주세요 : ");
			String key = sc.next();
			puzzleList = yesMove(puzzleList, key, index);
			puzzle.puzzleShow(puzzleList);
			if (key.equals("x"))
			{
				break;
			}
			if (puzzleCheak(puzzleList) == true)
			{
				break;
			}

		}

	}

	public ArrayList<String> yesMove(ArrayList<String> puzzleList, String key, int index)
	{
		if (key.equals("w"))
		{
			switch (index)
			{
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				Collections.swap(puzzleList, index, index + 3);
				break;
			case 6:
			case 7:
			case 8:
				noMove();
				break;

			}
		} else if (key.equals("s"))
		{
			switch (index)
			{
			case 0:
			case 1:
			case 2:
				noMove();
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				Collections.swap(puzzleList, index, index - 3);
				break;

			}
		} else if (key.equals("a"))
		{
			switch (index)
			{
			case 0:
			case 1:
			case 3:
			case 4:
			case 6:
			case 7:
				Collections.swap(puzzleList, index, index + 1);
				break;
			case 2:
			case 5:
			case 8:
				noMove();
				break;
			}

		} else if (key.equals("d"))
		{
			switch (index)
			{
			case 0:
			case 3:
			case 6:
				noMove();
				break;
			case 1:
			case 2:
			case 4:
			case 5:
			case 7:
			case 8:
				Collections.swap(puzzleList, index, index - 1);
				break;
			}

		}
		return puzzleList;

	}

	public ArrayList<String> suflMove(ArrayList<String> puzzleList, String key, int index)
	{
		if (key.equals("w"))
		{
			switch (index)
			{
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				Collections.swap(puzzleList, index, index + 3);
				break;
			}
		} else if (key.equals("s"))
		{
			switch (index)
			{
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				Collections.swap(puzzleList, index, index - 3);
				break;

			}
		} else if (key.equals("a"))
		{
			switch (index)
			{
			case 0:
			case 1:
			case 3:
			case 4:
			case 6:
			case 7:
				Collections.swap(puzzleList, index, index + 1);
				break;
			}

		} else if (key.equals("d"))
		{
			switch (index)
			{
			case 1:
			case 2:
			case 4:
			case 5:
			case 7:
			case 8:
				Collections.swap(puzzleList, index, index - 1);
				break;
			}

		}
		return puzzleList;

	}

	public void noMove()
	{
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}

	public Boolean puzzleCheak(ArrayList<String> list)
	{
		Boolean flag = false;
		if (list.get(0).equals("1"))
		{
			if (list.get(1).equals("2"))
			{
				if (list.get(2).equals("3"))
				{
					if (list.get(3).equals("4"))
					{
						if (list.get(4).equals("5"))
						{
							if (list.get(5).equals("6"))
							{
								if (list.get(6).equals("7"))
								{
									if (list.get(7).equals("8"))
									{
										if (list.get(8).equals("x"))
										{
											System.out.println("정답입니다.");
											System.out.println();
											flag = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return flag;
	}
}
