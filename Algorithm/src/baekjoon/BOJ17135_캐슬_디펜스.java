package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17135_캐슬_디펜스 {
    static int N, M, D, maxKillCnt = Integer.MIN_VALUE, enemiesCnt;
    static int[] archers = new int[3];
    static boolean[][] map, copiedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        copiedMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                copiedMap[i][j] = map[i][j] = "1".equals(st.nextToken());
            }
        }

        comb(0, 0);

        System.out.println(maxKillCnt);
    }

    private static void comb(int start, int cnt) {
        if (cnt == 3) {
            attack();

            for (int i = 0; i < N; i++) {
                map[i] = copiedMap[i].clone();
            }

            return;
        }

        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    private static void attack() {
        int killCnt = 0;

        for (int i = 0; i < N; i++) {
            boolean[][] killed = new boolean[N][M];
            for (int j = 0; j < 3; j++) {
                int archer = archers[j];
                int minDist = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;

                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < M; l++) {
                        if (map[k][l]) {
                            int dist = getDist(k, l, N, archer);

                            if (dist > D) {
                                continue;
                            }

                            if (minDist > dist) {
                                minDist = dist;
                                minR = k;
                                minC = l;
                            } else if (minDist == dist && minC > l) {
                                minR = k;
                                minC = l;
                            }
                        }
                    }
                }

                if (minDist <= D) {
                    killed[minR][minC] = true;
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (killed[j][k]) {
                        map[j][k] = false;
                        killCnt++;
                    }
                }
            }

            for (int j = N - 1; j > 0; --j) {
                map[j] = map[j - 1].clone();
            }
            Arrays.fill(map[0], false);
        }

        if (maxKillCnt < killCnt) {
            maxKillCnt = killCnt;
        }
    }

    private static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
