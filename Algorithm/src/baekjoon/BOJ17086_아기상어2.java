package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086_아기상어2 {
    static int N, M, Ans = Integer.MIN_VALUE;
    static int[] di = {1, 1, 1, -1, -1, -1, 0, 0}, dj = {0, 1, -1, 0, 1, -1, 1, -1};
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(Ans);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1], cv = cur[2];

            if(map[ci][cj]) {
                if(Ans < cv) {
                    Ans = cv;
                }
                return;
            }

            for (int d = 0; d < 8; d++) {
                int ni = ci + di[d], nj = cj + dj[d];
                if(isIn(ni, nj) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj, cv + 1});
                }
            }
        }
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
