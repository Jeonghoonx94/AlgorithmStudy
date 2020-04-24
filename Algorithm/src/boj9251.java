/*
 * BOJ 9251 - Longest Common Subsequence (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		br.close();
		
		int a_len = a.length();
		int b_len = b.length();
        int[][] dp = new int[a_len + 1][b_len + 1];
        
        for(int i = 1; i <= a_len; ++i) {
            for(int j = 1; j <= b_len; ++j) {
                if(a.charAt(i - 1) == b.charAt(j - 1))
                	dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[a_len][b_len]);
	}
}
