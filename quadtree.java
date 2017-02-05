package algospot;

import java.util.Scanner;

public class QuadTree {

	static int iterator = -1;
	static String inputString;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int testCase = Integer.parseInt(sc.nextLine());
		
		for(int test=0; test<testCase; test++){
			inputString = sc.nextLine();
			System.out.println(reverse());
			iterator = -1;
		}
		
		sc.close();
		
	}
	
	public static String reverse(){
		
		iterator++;
		
		char head = inputString.charAt(iterator);
		if(head=='b' || head=='w'){
			return Character.toString(head);
		}
		
		String upperLeft = reverse();
		String upperRight = reverse();
		String lowerLeft = reverse();
		String lowerRight = reverse();
		
		return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
		
	}
		
}
