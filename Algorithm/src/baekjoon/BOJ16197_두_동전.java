package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16197_두_동전 {
    static int N, M, Ans;
    static int[] di = {-1, 1, 0, 0},
            dj = {0, 0, -1, 1};
    static int[][] coins;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        Ans = 0;
        map = new char[N][M];
        coins = new int[2][2];

        for (int i = 0, cnt = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') { // coin 위치
                    coins[cnt][0] = i;
                    coins[cnt++][1] = j;
                }
            }
        }

        bfs();
        br.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        // i1, j1, i2, j2, 버튼 누른 횟수
        q.add(new int[]{coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[4] >= 10) {
                System.out.println(-1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ni1 = cur[0] + di[i];
                int nj1 = cur[1] + dj[i];
                int ni2 = cur[2] + di[i];
                int nj2 = cur[3] + dj[i];

                if (isIn(ni1, nj1) && isIn(ni2, nj2)) {
                    if (map[ni1][nj1] == '#') {
                        ni1 = cur[0];
                        nj1 = cur[1];
                    }
                    if (map[ni2][nj2] == '#') {
                        ni2 = cur[2];
                        nj2 = cur[3];
                    }
                    q.add(new int[]{ni1, nj1, ni2, nj2, cur[4] + 1});
                } else if (!isIn(ni1, nj1) && !isIn(ni2, nj2)) {
                    continue;
                } else {
                    System.out.println(cur[4] + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isIn(int i, int j) {
        return i < N && i >= 0 && j < M && j >= 0;
    }
}
