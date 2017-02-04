package algospot;

import java.util.Scanner;

public class ClockSync {

	static final int MAX = 99;
	static int testCase;
	static int clock[] = new int[16];
	static int linked[][] = {  // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15	// (WatchNumber)
															{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0번 스위치
															{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 }, // 1번 스위치
															{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 }, // 2번 스위치
															{ 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3번 스위치
															{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0 }, // 4번 스위치
															{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, // 5번 스위치
															{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, // 6번 스위치
															{ 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 }, // 7번 스위치
															{ 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8번 스위치
															{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, // 9번 스위치
	};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();

		for (int test = 0; test < testCase; test++) {
			for (int i = 0; i < 16; i++) {
				clock[i] = sc.nextInt();
			}
			System.out.println((solve(0)!=MAX) ? solve(0) : -1);
		}
		
		sc.close();

	}

	public static void push(int switchNum) {

		for (int clockNum = 0; clockNum < 16; clockNum++) {
			if (linked[switchNum][clockNum] == 1) {
				clock[clockNum] += 3;
				if (clock[clockNum] == 15)
					clock[clockNum] = 3;
			}
		}

	}

	public static boolean checkAllTwelve() {
		for (int i = 0; i < 16; i++) {
			if (clock[i] != 12)
				return false;
		}
		return true;
	}

	public static int solve(int switchNum) {

		if (switchNum == 10) {
			return checkAllTwelve() ? 0 : MAX;
		}

		int minCnt = MAX;

		for (int cnt = 0; cnt < 4; cnt++) {
			minCnt = Math.min(minCnt, cnt + solve(switchNum + 1));
			push(switchNum);
		}

		return minCnt;
	}

}
