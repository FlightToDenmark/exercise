package algospot;

import java.util.Scanner;

public class JumpGame {

	static int testCase;
	static int n;
	static int[][] board = new int[100][100];
	static int[][] cache = new int[100][100];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		for (int test = 0; test < testCase; test++) {
			n = sc.nextInt();
			cacheSetting(n);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			System.out.println(jump(0, 0) == 1 ? "YES" : "NO");
		}

		sc.close();

	}

	public static int jump(int x, int y) {

		if (x >= n || y >= n)
			return 0;

		if (x == n - 1 && y == n - 1)
			return 1;

		if (cache[x][y] != -1)
			return cache[x][y];

		return cache[x][y] = jump(x + board[x][y], y) | jump(x, y + board[x][y]);

	}

	public static void cacheSetting(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cache[i][j] = -1;
			}
		}
	}

}
