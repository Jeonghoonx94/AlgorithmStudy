package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17281_야구 {
    static int N, Ans;
    static int[][] scores;
    static int[] orders = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new int[N][10];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            orders[i] = i;
        }

        perm(0);

        System.out.println(Ans);
    }

    static void perm(int start) {
        if (start == 8) {
            if (orders[3] != 0) {
                return;
            }
            int score = calc();
            Ans = Math.max(Ans, score);
            return;
        }

        for (int i = start; i < 9; i++) {
            swap(start, i);
            perm(start + 1);
            swap(start, i);
        }
    }

    private static int calc() {
        int outCnt, cur = 0, score = 0;
        for (int i = 0; i < N; i++) {
            outCnt = 0;
            boolean[] base = new boolean[4];

            while (outCnt < 3) {
                int order = orders[cur];
                base[0] = true;

                if (scores[i][order] == 0) {
                    outCnt++;
                } else {
                    for (int j = 3; j >= 0; j--) {
                        if (!base[j]) {
                            continue;
                        }
                        int scrPossible = j + scores[i][order];
                        if (scrPossible > 3) {
                            score++;
                        } else {
                            base[scrPossible] = true;
                        }
                        base[j] = false;
                    }
                }
                cur = cur == 8 ? 0 : cur + 1;
            }
        }
        return score;
    }

    private static void swap(int i, int j) {
        int tmp = orders[i];
        orders[i] = orders[j];
        orders[j] = tmp;
    }
}
