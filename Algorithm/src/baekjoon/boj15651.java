package baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj15651 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		br.close();
		arr = new int[m];
		visited = new boolean[n+1];
		backtrack(0);
		System.out.println(sb);
	}
	
	static void backtrack(int k) {
		if(k == m) {
			for(int i: arr)
				sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=n; ++i) {
			arr[k] = i;
			backtrack(k+1);
		}
	}
}
