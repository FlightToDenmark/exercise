import java.util.Arrays;

public class Test2 {

	static int D;
	static int[] cap = new int[4];
	static int[][][] cache = new int[101][101][101];

	public static void main(String[] args) {

		// System.out.println(solution(100, 99, 2, 1));
		// System.out.println(solution(2, 99, 100, 1));
		// System.out.println(solution(3, 5, 7, 1));
		// System.out.println(solution(3, 6, 9, 4));
		// System.out.println(solution(100, 49, 50, 99));
		System.out.println(solution(100, 3, 1, 96));
		System.out.println(solution(1, 3, 100, 96));
		System.out.println(solution(1, 3, 100, 30));

	}

	public static int solution(int a, int b, int c, int d) {

		int answer = 999;

		int[] vol;

		vol = new int[4];

		cap[1] = a;
		cap[2] = b;
		cap[3] = c;

		Arrays.fill(vol, 0);
		D = d;

		for (int i = 1; i <= 3; i++) {
			cache = new int[101][101][101];
			int[] vol1 = Arrays.copyOf(vol, 4);
			answer = Math.min(answer, fill(i, vol1));
		}

		return (answer == 999) ? -1 : answer;

	}

	static int fill(int x, int[] vol) {

		if (cache[vol[1]][vol[2]][vol[3]] != 0)
			return cache[vol[1]][vol[2]][vol[3]];

		// System.out.println("fill(" + x + ")");

		vol[x] = cap[x];

		// for (int i = 1; i <= 3; i++) {
		// System.out.print(vol[i] + " ");
		// }
		// System.out.println();

		if (check(vol))
			return 1;

		int ret1 = 999;
		int ret2 = 999;
		for (int i = 1; i <= 3; i++) {
			if (i != x) {

				if (vol[i] == 0) {

					int[] vol1 = Arrays.copyOf(vol, 4);
					ret1 = Math.min(ret1, fill(i, vol1));

				}

				if (cap[i] - vol[i] > 0) {

					int[] vol1 = Arrays.copyOf(vol, 4);
					ret2 = Math.min(ret2, move(x, i, vol1));

				}

			}

		}

		return cache[vol[1]][vol[2]][vol[3]] = Math.min(ret1, ret2) + 1;

	}

	static int move(int x, int y, int[] vol) {

		if (cache[vol[1]][vol[2]][vol[3]] != 0)
			return cache[vol[1]][vol[2]][vol[3]];

		// System.out.println("move(" + x + ", " + y + ")");

		if (cap[y] - vol[y] >= vol[x]) {

			vol[y] += vol[x];
			vol[x] = 0;

		} else {

			vol[x] -= (cap[y] - vol[y]);
			vol[y] = cap[y];

		}

		// for (int i = 1; i <= 3; i++) {
		// System.out.print(vol[i] + " ");
		// }
		// System.out.println();

		if (check(vol)) {
			return 1;
		}

		int ans = 999;
		for (int i = 1; i <= 3; i++) {
			if (vol[i] == 0) {
				int[] vol1 = Arrays.copyOf(vol, 4);
				ans = Math.min(ans, fill(i, vol1));
			}
		}

		return cache[vol[1]][vol[2]][vol[3]] = ++ans;

	}

	static boolean check(int[] vol) {

		for (int i = 1; i <= 3; i++) {
			if (vol[i] == D)
				return true;
		}

		return false;

	}

}
