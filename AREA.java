import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AREA {
	
	public static int[][] area;
	public static int M, N;
	public static int areaIndex;
	public static final int[] dx = { +1, -1,  0,  0 };
	public static final int[] dy = {  0,  0, -1, +1 };
	public static ArrayList<Integer> areaList;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // y
		N = sc.nextInt(); // x
		int K = sc.nextInt();
		
		area = new int[N+1][M+1];
		
		for(int[] a : area) { Arrays.fill(a, 0); }
		
		for(int i=0; i<K; i++){ quadrangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()); }
		
//		showArea();
		
		areaIndex = 1;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				if(isRange(i,j)&&area[i][j]==0){
					areaCheck(i, j);
					areaIndex++;
				}
			}
		}

//		showArea();
		
		System.out.println(areaIndex-1);
		areaCalculator();
		
		Collections.sort(areaList);
		
		for(Integer a : areaList) { System.out.print(a + " ");};
		
		sc.close();
		
	}
	
	public static void quadrangle(int x_1, int y_1, int x_2, int y_2){
		
		for(int x=x_1+1; x<=x_2; x++){
			for(int y=y_1+1; y<=y_2; y++){
				area[x][y] = -1;
			}
		}
		
	}
	
	public static void showArea(){
		for(int j=M; j>=1; j--){
			for(int i=1; i<=N; i++){
				System.out.print(area[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void areaCheck(int x, int y){
		
		if(!isRange(x, y)) return;
		
		if(area[x][y]!=0) return;
		
		area[x][y] = areaIndex;
		
		for(int i=0; i<4; i++){ areaCheck(x+dx[i], y+dy[i]); }
		
	}
	
	public static boolean isRange(int x, int y){
		
		if(x>=1 && y>=1 && x<=N && y<=M) return true;
		
		return false;
		
	}
	
	public static void areaCalculator(){
		
		areaList = new ArrayList<>();
		
		while(areaIndex-->1){
//			System.out.println(areaIndex);
			int areaSize = 0;
			for(int i=1; i<=N; i++){
				for(int j=1; j<=M; j++){
					if(areaIndex==area[i][j]) areaSize++;
				}
			}
			
			areaList.add(areaSize);
			
		}
		
	}

}
