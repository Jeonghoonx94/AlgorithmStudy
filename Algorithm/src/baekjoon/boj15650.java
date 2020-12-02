package baekjoon;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class boj15650 {
//	static BufferedWriter bw;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		br.close();
		arr = new int[m];
		visited = new boolean[n+1];
		backtrack(0, 1);
//		bw.close();
		System.out.println(sb);
	}
	
	static void backtrack(int k, int next) {
		if(k == m) {
			for(int i: arr)
//				bw.write(i+" ");
				sb.append(i+" ");
//			bw.write("\n");
			sb.append("\n");
			return;
		}
		for(int i = next; i<=n; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				arr[k] = i;
				backtrack(k+1, i+1);
				visited[i] = false;
			}
		}
	}
}
