import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class boj15649 {
	static BufferedWriter bw;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		br.close();
		arr = new int[m];
		visited = new boolean[n+1];
		backtrack(n, m, 0);
		bw.flush();
		bw.close();
	}
	
	static void backtrack(int n, int m, int k) throws IOException {
		if(k == m) {
			for(int i: arr)
				bw.write(i+" ");
			bw.write("\n");
		}
		else {
			for(int i=1; i<=n; ++i) {
				if(!visited[i]) {
					visited[i] = true;
					arr[k] = i;
					backtrack(n, m, k+1);
					visited[i] = false;
				}
			}
		}
	}
}
