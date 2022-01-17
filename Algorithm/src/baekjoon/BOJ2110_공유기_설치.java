package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2110_공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int[] x = new int[N];
        for (int i = 0; i < N; ++i)
            x[i] = Integer.parseInt(br.readLine());
        Arrays.sort(x);

        int low = 1;
        int high = x[N - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean check = isPossible(x, C, mid);
            if (check) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low - 1);
    }

    static boolean isPossible(int[] x, int C, int mid) {
        int tmp = x[0];
        int count = 1;
        for (int i : x) {
            if (i >= tmp + mid) {
                ++count;
                tmp = i;
            }
        }
        return count >= C;
    }
}