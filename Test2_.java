import java.util.LinkedList;
import java.util.Queue;

public class Test2_ {

	static int globalD;
	static int[] capacity;

	public static void main(String[] args) {

		System.out.println(solution(3, 5, 7, 1));
		
	}

	public static int solution(int a, int b, int c, int d) {

		int answer = 0;

		globalD = d;
		capacity = new int[] { 0, a, b, c };

		Queue<Status> q = new LinkedList<>();
		q.add(new Status(0, 0, 0));

		while (!q.isEmpty()) {

			answer++;

			Status s = q.poll();

			if (s.a == globalD || s.b == globalD || s.c == globalD)
				return answer;

			if (s.a == 0) {
				q.add(new Status(capacity[1], s.b, s.c));
			}

			if (s.b == 0) {
				q.add(new Status(s.a, capacity[2], s.c));
			}

			if (s.c == 0) {
				q.add(new Status(s.a, s.b, capacity[3]));
			}

			if (s.a == capacity[1] && capacity[2] - s.b > 0) {

				if (capacity[2] - s.b >= s.a) {

					s.b += s.a;
					s.a = 0;

				} else {

					s.a -= (capacity[2] - s.b);
					s.b = capacity[2];

				}
				
				q.add(new Status(s.a, s.b, s.c));

			}
			
			if (s.a == capacity[1] && capacity[3] - s.c > 0) {

				if (capacity[3] - s.c >= s.a) {

					s.c += s.a;
					s.a = 0;

				} else {

					s.a -= (capacity[3] - s.c);
					s.c = capacity[3];

				}
				
				q.add(new Status(s.a, s.b, s.c));

			}

		}

		return (answer == 999) ? -1 : answer;

	}

}

class Status {

	int a, b, c;

	public Status(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
