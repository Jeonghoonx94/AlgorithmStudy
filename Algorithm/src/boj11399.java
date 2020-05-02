/*
 * BOJ 11399 - ATM (Greedy Algorithm)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		br.close();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
//		for(int i:arr)
//			System.out.print(i+" ");
//		System.out.println();
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		int sum = dp[0];
		for(int i = 1; i < n; ++i) {
			dp[i] = dp[i-1] + arr[i];
			sum += dp[i];
//			System.out.print(dp[i]+" ");
		}
		System.out.println(sum);
	}
}
