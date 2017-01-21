package algospot;

import java.util.Scanner;

public class Boggle {

	static int testCase;
	static String board[][] = new String[5][5];
	static int numWords;
	static String word[] = new String[10];

	static int dx[] = { -1, -1, -1, 1, 1, 1, 0, 0 };
	static int dy[] = { -1, 0, 1, -1, 0, 1, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		testCase = Integer.parseInt(sc.nextLine());

		for (int testNum = 0; testNum < testCase; testNum++) {
			for (int i = 0; i < 5; i++) {
				String boardLine = sc.nextLine();
				for (int j = 0; j < 5; j++) {
					board[i][j] = boardLine.substring(j, j + 1);
				}
			}
			numWords = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < numWords; i++) {
				word[i] = sc.nextLine();
			}
			
			for (int i = 0; i < numWords; i++) {

				int check = -1;
				Loop: for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						if (hasWord(x, y, word[i])) {
							check = 1;
							System.out.println(word[i] + " " + "YES");
							break Loop;
						}
					}
				}
				if (check != 1) {
					System.out.println(word[i] + " " + "NO");
				}

			}
		}
		
		sc.close();
		
	}

	public static boolean hasWord(int x, int y, String testWord) {

		if (!inRange(x, y)) {
			return false;
		}
		if (!board[x][y].equals(testWord.substring(0, 1))) {
			return false;
		}
		if (testWord.length() == 1) {
			return true;
		}

		for (int direction = 0; direction < 8; direction++) {
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			if (hasWord(nextX, nextY, testWord.substring(1))) {
				return true;
			}
		}

		return false;
	}

	public static boolean inRange(int x, int y) {

		if (x >= 0 && y >= 0 && x < 5 && y < 5) {
			return true;
		} else {
			return false;
		}
	}

}
