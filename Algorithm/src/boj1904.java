/*
 * BOJ 1904 - 01Tile (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1904 {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		dp = new long[n+1];
		dp[0] = 1; dp[1] = 1;
		System.out.println(solve(n));
	}
	static long solve(int n) {
//		int result = 0, tmp=1, tmp2=1;
		if(dp[n] != 0)
			return dp[n];
		for(int i = 2; i<=n; ++i) {
//			result = (tmp + tmp2) %15746;
//			tmp = tmp2;
//			tmp2 = result;
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
//		return result;
		return dp[n];
	}

}
