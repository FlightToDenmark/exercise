import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Routing {

	public static int vertex, edge;
	public static double[] distance;
	public static PriorityQueue<Pair> queue;
	public static List<List<Pair>> adjacent;

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int testCase = Integer.parseInt(br.readLine());

			while (testCase-- > 0) {

				StringTokenizer st = new StringTokenizer(br.readLine());
				vertex = Integer.parseInt(st.nextToken());
				edge = Integer.parseInt(st.nextToken());
				distance = new double[vertex];
				Arrays.fill(distance, -1);
				adjacent = new ArrayList<List<Pair>>();
				for (int i = 0; i < vertex; i++)
					adjacent.add(new ArrayList<Pair>());
				queue = new PriorityQueue<>(); // Pair<v, dist[v]>

				for (int e = 0; e < edge; e++) {
					StringTokenizer s = new StringTokenizer(br.readLine());
					int from = Integer.parseInt(s.nextToken());
					int to = Integer.parseInt(s.nextToken());
					double cost = Double.parseDouble(s.nextToken());
					adjacent.get(from).add(new Pair(to, cost));
					adjacent.get(to).add(new Pair(from, cost));
				}

				System.out.format("%.11f\n", dijkstra(0));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static double dijkstra(int src) {

		distance[src] = 1;
		queue.add(new Pair(src, 1));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			double dist = pair.dist;
			int here = pair.destNode;
			
			if (distance[here] < dist && distance[here] > 0)
				continue;
			for (int i = 0; i < adjacent.get(here).size(); i++) {
				int there = adjacent.get(here).get(i).destNode;
				double nextDist = dist * adjacent.get(here).get(i).dist;
				if (distance[there] > nextDist || distance[there] < 0) {
					distance[there] = nextDist;
					queue.add(new Pair(there, nextDist));
				}
			}

		}

		return distance[vertex - 1];

	}

}

class Pair implements Comparable<Pair> {

	int destNode; double dist;

	public Pair(int a, double b) {
		super();
		this.destNode = a;
		this.dist = b;
	}

	@Override
	public int compareTo(Pair pair) {
		
		return (int)(this.dist - pair.dist);
	
	}	
	
}
