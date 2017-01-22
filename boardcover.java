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

		int row = -1;
		int col = -1;

		Loop: for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					break Loop;
				}
			}
		}

		if (row == -1) {
			solution++;
		}

		for (int type = 0; type < 4; type++) {
			if (isPossible(row, col, type)) {
				placeBlock(row, col, type);
				cover();
				removeBlock(row, col, type);
			}
		}

	}

	public static boolean isPossible(int row, int col, int type) {

		for (int i = 0; i < 3; i++) {
			int newRow = row + coverType[type][i][0];
			int newCol = col + coverType[type][i][1];

			if (newRow < 0 || newCol < 0 || newRow >= height || newCol >= width || board[newRow][newCol] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void placeBlock(int row, int col, int type) {

		for (int i = 0; i < 3; i++) {
			int newRow = row + coverType[type][i][0];
			int newCol = col + coverType[type][i][1];

			board[newRow][newCol] = 1;
		}

	}

	public static void removeBlock(int row, int col, int type) {

		for (int i = 0; i < 3; i++) {
			int newRow = row + coverType[type][i][0];
			int newCol = col + coverType[type][i][1];

			board[newRow][newCol] = 0;
		}

	}

}
