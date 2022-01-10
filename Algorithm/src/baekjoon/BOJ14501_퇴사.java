package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501_퇴사 {
    static int N, maxPrice = 0;
    static int[][] tp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tp = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tp[i][0] = Integer.parseInt(st.nextToken());
            tp[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i + tp[i][0] <= N) {
                find(i, 0);
            }
        }

        System.out.println(maxPrice);
    }

    private static void find(int day, int price) {
        if (day > N) {
            return;
        }

        if (maxPrice < price) {
            maxPrice = price;
        }

        for (int i = day; i < N; ++i) {
            find(i + tp[i][0], price + tp[i][1]);
        }
    }

}
