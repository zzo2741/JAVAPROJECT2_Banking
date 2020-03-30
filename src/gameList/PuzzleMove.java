package gameList;

import java.util.ArrayList;
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
			if (index == 0)
			{
				if ("a".equalsIgnoreCase(key))
				{
					puzzleList.set(0, puzzleList.get(1));
					puzzleList.set(1, "x");

				} else if ("w".equalsIgnoreCase(key))
				{
					puzzleList.set(0, puzzleList.get(3));
					puzzleList.set(3, "x");
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
					puzzleList.set(1, puzzleList.get(4));
					puzzleList.set(4, "x");
				} else if ("a".equalsIgnoreCase(key))
				{
					puzzleList.set(1, puzzleList.get(2));
					puzzleList.set(2, "x");
				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(1, puzzleList.get(0));
					puzzleList.set(0, "x");
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
					puzzleList.set(2, puzzleList.get(5));
					puzzleList.set(5, "x");

				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(2, puzzleList.get(1));
					puzzleList.set(1, "x");
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
					puzzleList.set(3, puzzleList.get(6));
					puzzleList.set(6, "x");
				} else if ("a".equalsIgnoreCase(key))
				{
					puzzleList.set(3, puzzleList.get(4));
					puzzleList.set(4, "x");
				} else if ("s".equalsIgnoreCase(key))
				{
					puzzleList.set(3, puzzleList.get(0));
					puzzleList.set(0, "x");
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
					puzzleList.set(4, puzzleList.get(7));
					puzzleList.set(7, "x");
				} else if ("a".equalsIgnoreCase(key))
				{
					puzzleList.set(4, puzzleList.get(5));
					puzzleList.set(5, "x");
				} else if ("s".equalsIgnoreCase(key))
				{
					puzzleList.set(4, puzzleList.get(1));
					puzzleList.set(1, "x");
				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(4, puzzleList.get(3));
					puzzleList.set(3, "x");
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
					puzzleList.set(5, puzzleList.get(8));
					puzzleList.set(8, "x");
				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(5, puzzleList.get(4));
					puzzleList.set(4, "x");
				} else if ("s".equalsIgnoreCase(key))
				{
					puzzleList.set(5, puzzleList.get(2));
					puzzleList.set(2, "x");
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
					puzzleList.set(6, puzzleList.get(7));
					puzzleList.set(7, "x");
				} else if ("s".equalsIgnoreCase(key))
				{
					puzzleList.set(6, puzzleList.get(3));
					puzzleList.set(3, "x");
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
					puzzleList.set(7, puzzleList.get(8));
					puzzleList.set(8, "x");
				} else if ("s".equalsIgnoreCase(key))
				{
					puzzleList.set(7, puzzleList.get(4));
					puzzleList.set(4, "x");
				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(7, puzzleList.get(6));
					puzzleList.set(6, "x");
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
					puzzleList.set(8, puzzleList.get(5));
					puzzleList.set(5, "x");
				} else if ("d".equalsIgnoreCase(key))
				{
					puzzleList.set(8, puzzleList.get(7));
					puzzleList.set(7, "x");
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
			if (key.equals("x"))
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
