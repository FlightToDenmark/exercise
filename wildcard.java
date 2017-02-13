package algospot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wildcard {

	static int testCase;
	static int n;
	static String pattern;
	static String string;
	static int cache[][] = new int[101][101];
	static List<String> matchedString = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		testCase = Integer.parseInt(sc.nextLine());
		
		while(testCase-->0){
			pattern = sc.nextLine();
			matchedString = new ArrayList<String>();
			n = Integer.parseInt(sc.nextLine());
			for(int i=0; i<n; i++){
				string = sc.nextLine();
				for(int[] C : cache) Arrays.fill(C, -1);
				if(match(0, 0)==1) matchedString.add(string);
			}
			Collections.sort(matchedString);
			for(String str : matchedString){
				System.out.println(str);
			}
		}		
		sc.close();
	}

	public static int match(int p, int s) {

		if (cache[p][s] != -1)
			return cache[p][s];

		while (p < pattern.length() && s < string.length() && (pattern.charAt(p) == '?'|| pattern.charAt(p) == string.charAt(s))) {
			p++;
			s++;
		}

		if (p == pattern.length())
			if(s == string.length()) return cache[p][s] = 1;
			else return cache[p][s] = 0;

		if (pattern.charAt(p) == '*') {
			for(int skip=0; s+skip<=string.length(); skip++){
				if(match(p+1,s+skip)==1) return cache[p][s] = 1;
			}
		}

		return cache[p][s] = 0;

	}
	
}
