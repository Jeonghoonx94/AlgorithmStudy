/*
 * BOJ 1912 - Continuous Sum (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(s[i]);
		int max = arr[0];
		int[] dp = new int[n];
		dp[0] = arr[0];
		for(int i = 1; i < n; ++i) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
