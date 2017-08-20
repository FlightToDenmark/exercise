package baekjoon;

import java.util.Scanner;

public class FindingPaths {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] adjacent = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				adjacent[i][j] = sc.nextInt();

		sc.close();

		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (adjacent[i][k] == 1 && adjacent[k][j] == 1)
						adjacent[i][j] = 1;

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				System.out.print(adjacent[i][j] + " ");
			}
			System.out.println();
		}

	}

}
