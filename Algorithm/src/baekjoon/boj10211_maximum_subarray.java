package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10211_maximum_subarray {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = dp[0] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < N; ++i) {
                int next = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i - 1] + next, next);
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }
}
