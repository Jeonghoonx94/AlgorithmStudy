package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어_G3 {
    static int N, Ans, sharkSize = 2, eatCnt;
    static int[] di = {-1, 0, 0, 1}, dj = {0, -1, 1, 0}; // 상좌우하
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];    // 0: 빈칸, 1~6: 물고기 크기, 9: 아기상어
        int sharkI = 0, sharkJ = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkI = i;
                    sharkJ = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            // 가까운 먹이 찾기
            int[] fishPos = bfs(sharkI, sharkJ);

            if (fishPos == null) {
                System.out.println(Ans);
                return;
            }

            int fi = fishPos[0], fj = fishPos[1], dist = fishPos[2];

            map[fi][fj] = 0;
            Ans += dist;
            sharkI = fi;
            sharkJ = fj;

            if (++eatCnt == sharkSize) {
                eatCnt = 0;
                ++sharkSize;
            }
        }
    }

    private static int[] bfs(int sharkI, int sharkJ) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new int[]{sharkI, sharkJ, 0}); // i, j, dist
        visited[sharkI][sharkJ] = true;

        int minI = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        int minD = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                int nd = cur[2] + 1;

                if (!isIn(ni, nj) || visited[ni][nj] || map[ni][nj] > sharkSize) {
                    continue;
                }

                // 먹을 수 있다면
                if (map[ni][nj] > 0 && map[ni][nj] < sharkSize) {
                    if (minD > nd) {
                        minD = nd;
                        minI = ni;
                        minJ = nj;
                    } else if (minD == nd) {
                        if (minI > ni) {
                            minI = ni;
                            minJ = nj;
                        } else if (minI == ni) {
                            if (minJ > nj) {
                                minJ = nj;
                            }
                        }
                    }
                }

                visited[ni][nj] = true;
                q.offer(new int[]{ni, nj, nd});
            }
        }

        if (minI != Integer.MAX_VALUE) {
            return new int[]{minI, minJ, minD};
        }

        return null;
    }

    private static boolean isIn(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < N;
    }
}
