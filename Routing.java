import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Routing {

	public static int vertex, edge;
	public static BigDecimal[] distance;
	public static PriorityQueue<BigPair> queue;
	public static List<List<BigPair>> adjacent;
	
	public static class BigPair implements Comparable<BigPair> {

		int destNode; BigDecimal dist;

		public BigPair(int a, BigDecimal b) {
			this.destNode = a;
			this.dist = b;
		}

		@Override
		public int compareTo(BigPair pair) {
			
			return this.dist.compareTo(pair.dist);
		
		}
			
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int testCase = Integer.parseInt(br.readLine());

			while (testCase--> 0) {

				StringTokenizer st = new StringTokenizer(br.readLine());
				vertex = Integer.parseInt(st.nextToken());
				edge = Integer.parseInt(st.nextToken());
				distance = new BigDecimal[vertex];
				Arrays.fill(distance, new BigDecimal("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
				adjacent = new ArrayList<List<BigPair>>();
				for (int i = 0; i < vertex; i++) adjacent.add(new ArrayList<BigPair>());
				queue = new PriorityQueue<>(); // Pair<v, dist[v]>

				for (int e = 0; e < edge; e++) {
					StringTokenizer s = new StringTokenizer(br.readLine());
					int from = Integer.parseInt(s.nextToken());
					int to = Integer.parseInt(s.nextToken());
					BigDecimal cost = new BigDecimal(Double.parseDouble(s.nextToken()));
					adjacent.get(from).add(new BigPair(to, cost));
					adjacent.get(to).add(new BigPair(from, cost));
				}

				System.out.format("%.10f\n", dijkstra(0));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static BigDecimal dijkstra(int src) {

		distance[src] = BigDecimal.ONE;
		queue.add(new BigPair(src, BigDecimal.ONE));

		while (!queue.isEmpty()) {
			BigPair pair = queue.poll();
			BigDecimal dist = pair.dist;
			int here = pair.destNode;
			
			if (distance[here].compareTo(dist)<0) continue;
			
			for (int i = 0; i < adjacent.get(here).size(); i++) {
				int there = adjacent.get(here).get(i).destNode;
				BigDecimal nextDist = dist.multiply(adjacent.get(here).get(i).dist);
				if (distance[there].compareTo(nextDist)>0) {
					distance[there] = nextDist;
					queue.add(new BigPair(there, nextDist));
				}
			}

		}

		return distance[vertex - 1];

	}

}
