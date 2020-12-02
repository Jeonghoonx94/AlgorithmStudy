package baekjoon;
import java.util.Scanner;
import java.util.Stack;

public class boj1012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; ++i) {
			// 배추밭의 가로길이 1 ~ 50
			int M = sc.nextInt();
			// 배추밭의 세로길이 1 ~ 50
			int N = sc.nextInt();
			// 배추가 심어져 있는 위치의 개수 1 ~ 2500
			int K = sc.nextInt();
			
			int[][] arr = new int[N][M];
			for(int j = 0; j<K; ++j) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[y][x] = 1;
			}
			
			dfs(arr, 0, 0);
		}
		sc.close();
	}

	private static void dfs(int[][] arr, int i, int j) {
//		Stack<Integer> x_
	}
}
