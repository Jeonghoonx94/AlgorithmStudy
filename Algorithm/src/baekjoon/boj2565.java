package baekjoon;
/*
 * BOJ 1565 - Electric Wire (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[501];
		int[] dp = new int[501];
		for(int i=0; i<n; ++i) {
			String[] s = br.readLine().split(" ");
			a[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
		}
		int maxCrossedLine = 0;
		for(int i=1; i<501; ++i) {
			int tmp_lis = 1;
			for(int j=1; j<i; ++j)
				if( a[i] != 0 && a[j] != 0 && a[i] > a[j] )
					tmp_lis = Math.max(tmp_lis, dp[j] + 1);
			dp[i] = tmp_lis;
			maxCrossedLine = Math.max(maxCrossedLine, dp[i]);
		}
		System.out.println(n - maxCrossedLine);
	}
}
