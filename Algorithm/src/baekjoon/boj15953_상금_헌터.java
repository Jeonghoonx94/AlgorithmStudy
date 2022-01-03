package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15953_상금_헌터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] in = br.readLine().split(" ");
            int ans = 0;
            for (int i = 0; i < in.length; ++i) {
                ans += calc(Integer.parseInt(in[i]), i + 1);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int calc(int grade, int rnd) {
        if (grade == 0) {
            return 0;
        }
        if (rnd == 1) {
            if (grade == 1) {
                return 5000000;
            } else if (grade < 4) {
                return 3000000;
            } else if (grade < 7) {
                return 2000000;
            } else if (grade < 11) {
                return 500000;
            } else if (grade < 16) {
                return 300000;
            } else if (grade < 22) {
                return 100000;
            }
        }
        if (rnd == 2) {
            if (grade == 1) {
                return 5120000;
            } else if (grade < 4) {
                return 2560000;
            } else if (grade < 8) {
                return 1280000;
            } else if (grade < 16) {
                return 640000;
            } else if (grade < 32) {
                return 320000;
            }
        }
        return 0;
    }
}
