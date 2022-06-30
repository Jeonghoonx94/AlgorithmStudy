package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500_테트로미노_G5 {
    static int N, M, Ans;
    static int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(Ans);
    }

    private static void check(int i, int j) {
        int sum;
        if (i + 2 < N && j + 1 < M) {
            sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
            if (Ans < sum) {
                Ans = sum;
            }
        }
        if (i + 2 < N && j > 0) {
            sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1];
            if (Ans < sum) {
                Ans = sum;
            }
        }
        if (i + 1 < N && j + 2 < M) {
            sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
            if (Ans < sum) {
                Ans = sum;
            }
        }
        if (i > 0 && j + 2 < M) {
            sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 1];
            if (Ans < sum) {
                Ans = sum;
            }
        }
    }

    private static void dfs(int i, int j, int cnt, int sum) {
        if (cnt == 4) {
            if (Ans < sum) {
                Ans = sum;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (!isIn(ni, nj) || visited[ni][nj]) continue;

            visited[ni][nj] = true;
            dfs(ni, nj, cnt + 1, sum + map[ni][nj]);
            visited[ni][nj] = false;
        }
    }

    private static boolean isIn(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < M;
    }
}
