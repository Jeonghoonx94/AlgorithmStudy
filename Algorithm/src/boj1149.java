/*
 * BOJ 1149 - RGB Street (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n+1][3];
		int[][] m = new int[n+1][3];
		for(int i=1; i<=n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; ++j)
				rgb[i][j] = Integer.parseInt(st.nextToken());
			m[i][0] = Math.min(m[i-1][1], m[i-1][2]) + rgb[i][0];
			m[i][1] = Math.min(m[i-1][0], m[i-1][2]) + rgb[i][1];
			m[i][2] = Math.min(m[i-1][0], m[i-1][1]) + rgb[i][2];
		}
		System.out.println(Math.min(Math.min(m[n][2], m[n][0]), m[n][1]));
		
		br.close();
	}
}
