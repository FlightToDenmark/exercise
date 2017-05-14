import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WORDCHAIN {

	static int[][] adjacent;
	static Object[][] graph = new Object[26][26];
	static int[] indegree, outdegree;
	static ArrayList<Integer> circuit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int numWords = sc.nextInt();
			String[] words = new String[numWords];
			for (int i = 0; i < numWords; i++) {
				words[i] = sc.next();
			}
			System.out.println(solve(words));
		}
		sc.close();

	}

	@SuppressWarnings("unchecked")
	public static void makeGraph(String words[]) {

		initialize();

		for (int i = 0; i < words.length; i++){
			int a = words[i].charAt(0) - 'a';
			int b = words[i].charAt(words[i].length() - 1) - 'a';
			((ArrayList<String>)graph[a][b]).add(words[i]);
			adjacent[a][b]++;
			outdegree[a]++;
			indegree[b]++;
		}

	}

	public static void initialize() {

		for(int i=0; i<26; i++){
			for(int j=0; j<26; j++){
				graph[i][j] = new ArrayList<String>();
			}
		}
		adjacent = new int[26][26];
		indegree = new int[26];
		outdegree = new int[26];

	}

	public static void depthFirstSearch(int from) {
		for (int to = 0; to < adjacent.length; to++) {
			while (adjacent[from][to] > 0) {
				adjacent[from][to]--;
				depthFirstSearch(to);
			}
		}
		circuit.add(from);
	}

	public static ArrayList<Integer> getEulerTrailOrCircuit() {
		circuit = new ArrayList<>();
		// Euler Trail
		for (int i = 0; i < 26; i++) {
			if (outdegree[i] == indegree[i] + 1) {
				depthFirstSearch(i);
				return circuit;
			}
		}

		// Euler Circuit
		for (int i = 0; i < 26; i++) {
			if (outdegree[i] > 0) {
				depthFirstSearch(i);
				return circuit;
			}
		}

		return circuit;

	}

	public static boolean checkEuler() {

		int startPoints = 0, endPoints = 0;
		for (int i = 0; i < 26; i++) {
			int delta = outdegree[i] - indegree[i];
			if (delta < -1 || delta > 1) return false;
			if (delta == 1) startPoints++;
			if (delta == -1) endPoints++;
		}

		return (startPoints == 1 && endPoints == 1) || (startPoints == 0 && endPoints == 0);
	}
	
	@SuppressWarnings("unchecked")
	public static String solve(String[] words){
		
		makeGraph(words);
		if(!checkEuler()) return "IMPOSSIBLE";
		
		circuit = getEulerTrailOrCircuit();
		
		if(circuit.size() != words.length +1) return "IMPOSSIBLE";
		
		Collections.reverse(circuit);
		
		String wordsList = "";
		
		for(int i=1; i<circuit.size(); i++){
			int a = circuit.get(i-1), b = circuit.get(i);
			wordsList += (((ArrayList<String>)graph[a][b]).get(0) + " ");
			((ArrayList<String>)graph[a][b]).remove(0);
		}
		
		return wordsList;
		
	}

}
