package swea;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class A_1226 {
	private int x;
	private int y;
	
	public A_1226() {}
	public A_1226(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

public class Algorithm_1226 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] arr = new int[16][16];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case<=1; ++test_case) {
			char[][] carr = new char[16][16];
			boolean[][] visited = new boolean[16][16];
			int ans = 0;
			
			int startx = 0, starty = 0;
			int T = sc.nextInt();
			
			for(int i=0; i<16; ++i)
				carr[i] = sc.next().toCharArray();
			
			for(int i=0; i<16; ++i) 
				for(int j=0; j<16; ++j) {
					arr[i][j] = Integer.parseInt(carr[i][j]+"");
					if(arr[i][j] == 2) {
						startx = j;
						starty = i;
					}
				}
			
			Queue<A_1226> q = new LinkedList<>();
			q.add(new A_1226(starty, startx));
			while(!q.isEmpty()) {
				if(ans == 1)
					break;
				A_1226 t = q.peek();
				q.remove();
				int y = t.getY();
				int x = t.getX();
				visited[y][x] = true;
				for(int i=0; i<4; ++i) {
					if(arr[y+dy[i]][x+dx[i]] == 0 && !visited[y+dy[i]][x+dx[i]]) {
						q.add(new A_1226(y+dy[i], x+dx[i]));
						visited[y+dy[i]][x+dx[i]] = true;
					} else if(arr[y+dy[i]][x+dx[i]] == 3 && !visited[y+dy[i]][x+dx[i]])
						ans = 1;
				}
			}
			
			System.out.println("#"+T+" "+ans);
			
			q.clear();
		}
		sc.close();
	}
}
