import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BusMinimumCost {
	
	public static int vertex, edge;
	public static int[] distance;
	public static List<List<Pair>> adjacent; // Pair(destinationNode, distance)
	public static Queue<Pair> queue; // Pair(destinationNode, distance)
	public static int start, end;
	
	public static class Pair implements Comparable<Pair> {

		int destNode, dist;
		
		public Pair(int destNode, int dist){
			this.destNode = destNode;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pair pair) {
			return this.dist - pair.dist;
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
							
		vertex = sc.nextInt();
		edge = sc.nextInt();
		distance = new int[vertex+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		adjacent = new ArrayList<List<Pair>>();
		for(int v=0; v<vertex+1; v++) adjacent.add(new ArrayList<Pair>());
		queue = new PriorityQueue<>();
		
		for(int e=0; e<edge; e++){
			int nodeOne = sc.nextInt();
			int nodeTwo = sc.nextInt();
			int cost = sc.nextInt();
			adjacent.get(nodeOne).add(new Pair(nodeTwo, cost));
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
						
		System.out.println(dijkstra(start, end));
				
		sc.close();
		
	}
	
	public static int dijkstra(int src, int dest){
		
		distance[src] = 0;
		queue.add(new Pair(src, 0));
		
		while(!queue.isEmpty()){
			int dist = queue.peek().dist;
			int here = queue.peek().destNode;
			queue.poll();
			
			if(distance[here]<dist) continue;
			
			for(int i=0; i<adjacent.get(here).size(); i++){
				int there = adjacent.get(here).get(i).destNode;
				int nextDist = dist + adjacent.get(here).get(i).dist;
				if(distance[there]>nextDist){
					distance[there] = nextDist;
					queue.add(new Pair(there, nextDist));
				}				
			}
			
		}
		
		return distance[dest];
		
	}

}
