package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15954_인형들 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(st.nextToken());
        }

        double ans = Double.MAX_VALUE;
        for (int k = K; k <= N; ++k) {
            for (int i = 0; i < N - k + 1; ++i) {
                ans = Math.min(calc(i, k, nums), ans);
            }
        }
        System.out.println(ans);
    }

    private static double calc(int idx, int k, double[] nums) {
        double sum = 0;
        for (int i = idx; i < idx + k; ++i) {
            sum += nums[i];
        }
        double m = sum / k;

        sum = 0;
        for (int i = idx; i < idx + k; ++i) {
            sum += Math.pow(nums[i] - m, 2);
        }

        return Math.sqrt(sum / k);
    }
}
