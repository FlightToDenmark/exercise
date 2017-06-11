import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SevenDwarfs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] height = new int[9];
		int sum = 0;

		for (int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}

		sc.close();

		int out1 = 0, out2 = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (sum == height[i] + height[j] + 100) {
					out1 = i;
					out2 = j;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < height.length; i++) {
			if (i == out1 || i == out2) {
				continue;
			}
			list.add(height[i]);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
