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
		while (true)
		{
			int index = list.indexOf("x");
			Scanner sc = new Scanner(System.in);
			System.out.println("[ 이동 ] a : Left d : Right w : Up s : Down");
			System.out.println("[ 종료 ] x : Exit");
			System.out.print("키를 입력해주세요 : ");
			String key = sc.next();
			if (key.equals("x"))
			{
				break;
			} else if (index == 0)
			{
				if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 0, 1);

				} else if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 0, 3);
				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 1)
			{
				if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 1, 4);

				} else if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 1, 2);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 1, 0);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 2)
			{

				if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 2, 5);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 2, 1);
				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 3)
			{

				if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 3, 6);

				} else if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 3, 4);

				} else if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 3, 0);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 4)
			{

				if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 4, 7);

				} else if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 4, 5);

				} else if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 4, 1);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 4, 3);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 5)
			{

				if ("w".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 5, 8);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 5, 4);

				} else if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 5, 2);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 6)
			{

				if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 6, 7);

				} else if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 6, 3);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 7)
			{

				if ("a".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 7, 8);

				} else if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 7, 4);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 7, 6);

				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			} else if (index == 8)
			{

				if ("s".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 8, 5);

				} else if ("d".equalsIgnoreCase(key))
				{
					Collections.swap(puzzleList, 8, 7);
				} else
				{
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxx이동불가xxxxxxxxxxxx");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				}
			}
			puzzle.puzzleShow(puzzleList);
			if (puzzleCheak(puzzleList) == true)
			{
				break;
			}

		}

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
