package jungol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cheese {

	public static int[][] cheeseBoard;
	public static Queue<Point> queue;
	public static int row, col;
	public static boolean visited[][];
	public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static int cheese;
	public static int hours;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt(); col = sc.nextInt();
		cheeseBoard = new int[row][col];
		visited = new boolean[row][col];
		queue = new LinkedList<Point>();
		
		for(int i=0; i<row; i++) for(int j=0; j<col; j++) cheeseBoard[i][j] = sc.nextInt();
		
		System.out.println(cheeseCount());
		
		findAnswer();

		sc.close();
		
	}
	
	private static void searchOuterCheese(int x, int y){
		
		System.out.println("ho");
		
		if(!isRange(x, y)) return;
		
		if(visited[x][y]) return;
			
		visited[x][y] = true;
		
		if(cheeseBoard[x][y]==1) queue.add(new Point(x, y));
		else for(int i=0; i<4; i++) searchOuterCheese(x+dx[i], y+dy[i]);
			
		return;		
		
	}
		
	private static boolean isRange(int x, int y){
		
		if(x>=0 && y>=0 && x<row && y<col) return true;
		
		return false;
		
	}
	
	private static void findAnswer(){
		
		System.out.println(cheeseCount());
		while(cheeseCount()!=0){
			searchOuterCheese(0, 0);
			int queueSize = queue.size();
			for(int i=0; i<queueSize; i++){
				Point point = queue.poll();
				cheeseBoard[point.x][point.y] = 0;
			}
			hours++;
		}
		
		System.out.println(hours);
		System.out.println(cheeseCount());
		
	}
	
	private static int cheeseCount(){
		
		int count = 0;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(cheeseBoard[i][j]==1) count++;
			}
		}
		return count;		
		
	}

}

class Point{
	
	int x; int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
}
