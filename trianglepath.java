package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class TrianglePath {

	static int testCase;
	static int n;
	static int[][] triangle = new int[100][100];
	static int[][] cache = new int[100][100];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		while (testCase-- > 0) {
			n = sc.nextInt();
			setting();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i + 1; j++) {
					triangle[i][j] = sc.nextInt();
				}
			}
			System.out.println(pathSum(0, 0));

		}

		sc.close();

	}

	public static int pathSum(int row, int col) {

		if (row == n - 1)
			return triangle[row][col];

		if (cache[row][col] != -1)
			return cache[row][col];

		return cache[row][col] = Math.max(pathSum(row + 1, col), pathSum(row + 1, col + 1)) + triangle[row][col];

	}

	public static void setting() {
		for (int[] C : cache) {
			Arrays.fill(C, -1);
		}
	}

}
