import java.util.Arrays;
import java.util.Scanner;

public class PI {

	static String N;
	static int cache[] = new int[10002];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			Arrays.fill(cache, -1);
			N = sc.next();
			System.out.println(minDifficulty(0));
		}

		sc.close();

	}

	public static int partDifficulty(int a, int b) {

		String M = N.substring(a, b);
		
		
		String regex = "^[" + M.charAt(0) + "]{3,5}$"; 
		if (M.matches(regex)) return 1;
		

		boolean progressive = true;
		for (int i = 0; i < M.length() - 1; i++) {
			if (M.charAt(i + 1) - M.charAt(i) != M.charAt(1) - M.charAt(0))
				progressive = false;
		}

		if (progressive
				&& Math.abs(Character.getNumericValue(M.charAt(1)) - Character.getNumericValue(M.charAt(0))) == 1)
			return 2;

		boolean alternating = true;
		for (int i = 0; i < M.length(); i++) {
			if (M.charAt(i) != M.charAt(i % 2))
				alternating = false;
		}

		if (alternating)
			return 4;

		if (progressive)
			return 5;

		return 10;

	}

	public static int minDifficulty(int begin) {

		if (begin == N.length())
			return 0;

		if (cache[begin] != -1)
			return cache[begin];

		int ret = cache[begin] = 99999999;

		for (int L = 3; L <= 5; L++) {
			if (begin + L <= N.length()){
				ret = cache[begin] = Math.min(ret, partDifficulty(begin, begin + L) + minDifficulty(begin + L));
			}
		}

		return ret;
		
	}

}
