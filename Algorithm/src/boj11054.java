/*
 * BOJ 11054 - Longest Bitonic Subsequence (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class boj11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Length of Sequence
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        // Longest Increasing Subsequence
        int[] increasing_dp = new int[n];
        // Longest Decreasing Subsequence
        int[] decreasing_dp = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i= 0; i<n; ++i)
            arr[i] = Integer.parseInt(s[i]);
        // if the Length of Sequence is 1,
        increasing_dp[0] = 1;
        decreasing_dp[n-1] = 1;
        int LBS = 1;
        for(int i=1; i<n; ++i) {
            int tmp_lbs = 0;
            int tmp_lbs2 = 0;
            for(int j=0; j<i; ++j) {
                if(arr[i] > arr[j]) tmp_lbs = Math.max(tmp_lbs, increasing_dp[j]) ;
                if(arr[n-1-i] > arr[n-1-j]) tmp_lbs2 = Math.max(tmp_lbs2, decreasing_dp[n-1-j]) ;
            }
            increasing_dp[i] = tmp_lbs + 1;
            decreasing_dp[n-1-i] = tmp_lbs2 + 1;
        }
        // LBS = LIS + LDS - 1
        for(int i=0; i<n; ++i)
        	LBS = Math.max(LBS, increasing_dp[i]+decreasing_dp[i]-1);
        System.out.println(LBS);
    }
}