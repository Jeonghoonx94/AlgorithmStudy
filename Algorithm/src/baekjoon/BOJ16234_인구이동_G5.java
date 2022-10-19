package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234_인구이동_G5 {
    static int N, L, R, Ans;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (bfs()) {
            Ans++;
        }
        System.out.println(Ans);
    }

    private static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        boolean check = false;
        boolean[][] visited = new boolean[N][N];
        int[] di = {-1, 0, 1, 0}, dj = {0, -1, 0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                list.clear();

                q.add(new int[]{i, j});
                list.add(new int[]{i, j});
                visited[i][j] = true;

                int cnt = 1, sum = A[i][j];

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int ni = cur[0] + di[d];
                        int nj = cur[1] + dj[d];

                        if (!isIn(ni, nj) || visited[ni][nj]) continue;

                        int diff = Math.abs(A[cur[0]][cur[1]] - A[ni][nj]);

                        if (diff >= L && diff <= R) {
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                            list.add(new int[]{ni, nj});
                            check = true;
                            cnt++;
                            sum += A[ni][nj];
                        }
                    }
                }

                int avg = sum / cnt;
                for (int[] d : list) {
                    A[d[0]][d[1]] = avg;
                }
            }
        }

        return check;
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

}
