import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gallery {

	public static List<ArrayList<Integer>> adjacent;
	public static boolean[] visited;
	public static final int UNWATCHED = 0;
	public static final int WATCHED = 1;
	public static final int INSTALLED = 2;
	public static int installed;
	public static int vertex;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		while(testCase-->0){
			
			vertex = sc.nextInt();
			int edge = sc.nextInt();
			
			adjacent = new ArrayList<ArrayList<Integer>>(vertex);
			visited = new boolean[vertex];
			installed = 0;
			
			for(int i=0; i<vertex; i++) adjacent.add(new ArrayList<Integer>());
			
			while(edge-->0){
				
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adjacent.get(from).add(to);
				adjacent.get(to).add(from);
				
			}
			
			System.out.println(installCamera());
		}
		
		sc.close();		
		
	}
	
	private static int dfs(int from){
		
		visited[from] = true;
		int children[] = {0, 0, 0};
		
		for(int i=0; i<adjacent.get(from).size(); i++){
			int to = adjacent.get(from).get(i);
			if(!visited[to]) children[dfs(to)]++;
		}
		
		if(children[UNWATCHED]>=1){
			installed++;
			return INSTALLED;
		}
		
		if(children[INSTALLED]>=1){
			return WATCHED;
		}
		
		return UNWATCHED;
		
	}
	
	private static int installCamera(){
		
		for(int u=0; u<vertex; u++)	if(!visited[u] && (dfs(u)==UNWATCHED)) installed++;
				
		return installed;
		
	}

}
