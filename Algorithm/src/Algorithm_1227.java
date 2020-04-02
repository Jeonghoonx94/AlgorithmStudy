import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm_1227 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case<=1; ++test_case) {
			boolean[][] visited = new boolean[100][100];
			int ans = 0;
			
			int startx = 0, starty = 0;
			int T = sc.nextInt();
			arr = new int[100][100];
			
			for(int i=0; i<100; ++i) {
				String s = sc.next();
				for(int j=0; j<100; ++j) {
					arr[i][j] =  s.charAt(j)-'0';
					if(arr[i][j] == 2) {
						startx = j;
						starty = i;
					}
				}
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(starty);
			q.add(startx);
			while(!q.isEmpty()) {
				if(ans == 1)
					break;
				int y = q.poll();
				int x = q.poll();
				visited[y][x] = true;
				for(int i=0; i<4; ++i) {
					int tx = x + dx[i];
					int ty = y + dy[i];
					if(arr[ty][tx] == 0 && !visited[ty][tx]) {
						q.add(ty);
						q.add(tx);
						visited[ty][tx] = true;
					} else if(arr[ty][tx] == 3 && !visited[ty][tx]) {
						ans = 1;
						break;
					}
				}
			}
			
			System.out.println("#"+T+" "+ans);
			
			q.clear();
		}
		sc.close();
	}
}
