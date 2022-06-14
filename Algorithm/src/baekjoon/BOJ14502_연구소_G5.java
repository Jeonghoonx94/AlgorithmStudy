package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소_G5 {
    static int N, M, Ans;
    static int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>(), copiedQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());   // 1 벽, 2 바이러스
                if (map[i][j] == 2)
                    q.offer(new int[]{i, j});  // 바이러스
            }
        }

        makeWall(0);

        System.out.println(Ans);
    }

    private static void makeWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈곳
                    map[i][j] = 1;
                    makeWall(cnt + 1);  // 벽 세우기
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] copiedMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(map[i], 0, copiedMap[i], 0, M);
        }

        for (int[] c : q) {
            copiedQ.offer(c);
        }

        while (!copiedQ.isEmpty()) {
            int[] cur = copiedQ.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (isIn(ni, nj) && copiedMap[ni][nj] == 0) {
                    copiedMap[ni][nj] = 2;
                    copiedQ.offer(new int[]{ni, nj});
                }
            }
        }

        int area = 0;
        for (int[] cur : copiedMap) {
            for (int c : cur) {
                if (c == 0) {
                    area++;
                }
            }
        }

        if(Ans < area) {
            Ans = area;
        }
    }

    private static boolean isIn(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < M;
    }
}
