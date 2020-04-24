/*
 * BOJ 11053 - Longest Increasing Subsequence (DP) 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i= 0; i<n; ++i)
            arr[i] = Integer.parseInt(s[i]);
        dp[0] = 1;
        int LIS = 1;
        for(int i=1; i<n; ++i) {
            int tmp_lis = 0;
            for(int j=0; j<i; ++j)
                if(arr[i] > arr[j]) tmp_lis = Math.max(tmp_lis, dp[j]) ;
            dp[i] = tmp_lis + 1;
            LIS = Math.max(LIS, dp[i]);
        }
        System.out.println(LIS);
    }
}