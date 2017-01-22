import java.util.Scanner;

public class Picnic {

	static int testCase, numOfStudents, numOfPairs;
	static int solution;

	static boolean areFriends[][] = new boolean[10][10];
	static boolean havePartner[] = new boolean[10];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		for (int test = 0; test < testCase; test++) {
		
			numOfStudents = sc.nextInt();
			numOfPairs = sc.nextInt();

			for (int i = 0; i < numOfPairs; i++) {

				int friend1 = sc.nextInt();
				int friend2 = sc.nextInt();

				areFriends[friend1][friend2] = true;
				areFriends[friend2][friend1] = true;

			}

			makePair();
			System.out.println(solution);
			clear();
		
		}
		
		sc.close();

	}

	public static void makePair() {

		int firstFree = -1;

		for (int i = 0; i < numOfStudents; i++) {
			if (!havePartner[i]) {
				firstFree = i;
				break;
			}
		}

		if (firstFree == -1) {
			solution++;
		}

		for (int partner = firstFree + 1; partner < numOfStudents; partner++) {
			if (!havePartner[partner] && areFriends[firstFree][partner]) {
				coupling(firstFree, partner);
				makePair();
				decoupling(firstFree, partner);
			}
		}

	}

	public static void coupling(int x, int y) {

		havePartner[x] = true;
		havePartner[y] = true;

	}

	public static void decoupling(int x, int y) {

		havePartner[x] = false;
		havePartner[y] = false;

	}
	
	public static void clear(){
		
		numOfStudents = 0;
		numOfPairs = 0;
		solution = 0;
		for(int i=0; i<10; i++){
			havePartner[i] = false;
		}
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				areFriends[i][j] = false;
			}
		}
	}

}
