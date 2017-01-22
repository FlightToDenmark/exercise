import java.util.Scanner;

public class BoardCover {

	static int testCase, height, width;

	static int coverType[][][] = {

			{ { 0, 0 }, { 1, 0 }, { 0, 1 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, -1 } }

	};

	static String row[] = new String[20];
	static int board[][] = new int[20][20];

	static int solution;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();

		for (int test = 0; test < testCase; test++) {
			height = sc.nextInt();
			width = sc.nextInt();

			for (int i = 0; i < height; i++) {
				row[i] = sc.next();
			}

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (row[i].charAt(j) == '#') {
						board[i][j] = 1;
					}else{
						board[i][j] = 0;
					}
				}
			}

			cover();
			System.out.println(solution);
			solution = 0;
		}
		
		sc.close();

	}

	public static void cover() {

		int x = -1;
		int y = -1;

		Loop: for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == 0) {
					x = i;
					y = j;
					break Loop;
				}
			}
		}

		if (x == -1) {
			solution++;
		}

		for (int type = 0; type < 4; type++) {
			if (isPossible(x, y, type)) {
				placeBlock(x, y, type);
				cover();
				removeBlock(x, y, type);
			}
		}

	}

	public static boolean isPossible(int x, int y, int type) {

		for (int i = 0; i < 3; i++) {
			int ax = x + coverType[type][i][0];
			int ay = y + coverType[type][i][1];

			if (ax < 0 || ay < 0 || ax >= height || ay >= width || board[ax][ay] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void placeBlock(int x, int y, int type) {

		for (int i = 0; i < 3; i++) {
			int ax = x + coverType[type][i][0];
			int ay = y + coverType[type][i][1];

			board[ax][ay] = 1;
		}

	}

	public static void removeBlock(int x, int y, int type) {

		for (int i = 0; i < 3; i++) {
			int ax = x + coverType[type][i][0];
			int ay = y + coverType[type][i][1];

			board[ax][ay] = 0;
		}

	}

}
