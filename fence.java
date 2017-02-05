package algospot;

import java.util.Scanner;

public class Fence {

	static int testCase;
	static int fenceHeight[] = new int[20001];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		for (int test = 0; test < testCase; test++) {
			int fenceNum = sc.nextInt();
			for (int i = 1; i <= fenceNum; i++) {
				fenceHeight[i] = sc.nextInt();
			}
			System.out.println(calculateArea(1, fenceNum));
		}
		
		sc.close();

	}

	public static int calculateArea(int left, int right) {

		if (left == right) return fenceHeight[left];

		int mid = (left + right) / 2;

		int area = Math.max(calculateArea(left, mid), calculateArea(mid + 1, right));

		int low = mid;
		int high = mid + 1;
		int height = Math.min(fenceHeight[low], fenceHeight[high]);

		area = Math.max(area, height*2);

		while (left < low || high < right) {

			if (high < right && (low == left || fenceHeight[low - 1] < fenceHeight[high + 1])) {
				high++;
				height = Math.min(height, fenceHeight[high]);
			} else {
				low--;
				height = Math.min(height, fenceHeight[low]);
			}

			area = Math.max(area, height * (high - low + 1));

		}

		return area;
	}

}
