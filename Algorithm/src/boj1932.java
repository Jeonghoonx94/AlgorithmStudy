/*
 * BOJ 1932 - The Triangle (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rows = Integer.parseInt(br.readLine());
		int[][] triangle = new int[rows][];
		int[][] dp = new int[rows][];
		for(int i = 0; i < rows; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			triangle[i] = new int[i + 1];
			dp[i] = new int[i + 1];
			for(int j = 0; j < i + 1; ++j)
				triangle[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		dp[0][0] = triangle[0][0];
		int max = dp[0][0];
		for(int i = 1; i < rows; ++i) {
			for(int j = 0; j < i + 1; ++j) {
				if(j == 0)
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				else if(j >= 1 && j < i)
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				else	dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				if(i == rows - 1)	max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
