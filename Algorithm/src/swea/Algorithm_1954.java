package swea;
import java.util.Scanner;

public class Algorithm_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		// 우 하 좌 상 순서
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int x=0, y=0, dir=0;
			for(int i=1; i<=N*N; ++i) {
				arr[x][y] = i;
				x += dx[dir];
				y += dy[dir];
				// 배열 범위를 벗어나거나 값이 존재할 경우
				if(x>=N || x<0 || y>=N || y<0 || arr[x][y] != 0) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir+1)%4;
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			System.out.println("#"+test_case);
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j)
					System.out.print(arr[i][j]+" ");
				System.out.println();
			}
		}
		sc.close();
	}
}