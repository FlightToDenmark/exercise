import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[] sequence;
	public static int[][] cache;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sequenceLength = sc.nextInt();
		
		sequence = new int[sequenceLength];
		cache = new int[sequenceLength][sequenceLength];
		for(int[] row : cache) Arrays.fill(row, -1);
				
		for(int i=0; i<sequenceLength; i++) sequence[i] = sc.nextInt();
		
		System.out.println(getPalindrome(0, sequenceLength-1));
				
		sc.close();

	}
	
	public static int getPalindrome(int left, int right){
		
		if(cache[left][right]!=-1) return cache[left][right];
		
		if(right-left==0) return 0;
		
		if(sequence[left]==sequence[right]){
			if(right-left==1) return cache[left][right] = 0;
			return cache[left][right] = getPalindrome(left+1, right-1);
		}else{
			if(right-left==1) return cache[left][right] = 1;
			return cache[left][right] = Math.min(getPalindrome(left, right-1), getPalindrome(left+1, right))+1;
		}

	}

}
