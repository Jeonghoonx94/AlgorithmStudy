package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기_G5 {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 북동남서
    static int[][] map;
    static boolean[][] cleaned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaned[r][c] = true;

        System.out.println(clean(r, c, d, 1));
    }

    private static int clean(int r, int c, int d, int count) {
        for (int i = 0; i < 4; i++) {
            int nd = (d + 3 - i) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if (map[nr][nc] == 0 && !cleaned[nr][nc]) {
                cleaned[nr][nc] = true;
                return clean(nr, nc, nd, count + 1);
            }
        }

        int bd = (d + 2) % 4;
        int br = r + dr[bd];
        int bc = c + dc[bd];

        if (map[br][bc] == 0) {
            return clean(br, bc, d, count);
        } else {
            return count;
        }
    }

}
