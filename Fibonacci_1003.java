import java.util.Scanner;

public class Fibonacci_1003 {

	public static int num0, num1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			num0 = num1 = 0;
			fibonacci(sc.nextInt());
			System.out.println(num0 + " " + num1);
		}

		sc.close();

	}

	public static int fibonacci(int n) {

		if (n == 0) {
			num0++;
			return 0;
		} else if (n == 1) {
			num1++;
			return 1;
		} else
			return fibonacci(n - 1) + fibonacci(n - 2);

	}

}
