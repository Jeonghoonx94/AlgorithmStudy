package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2174_로봇_시뮬레이션 {
    static int A, B, N, M;
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1}; // ESWN
    static int[][] robots, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[A + 1][B + 1];
        robots = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            robots[i][0] = x;
            robots[i][1] = y;
            if (dir == 'E') {
                robots[i][2] = 0;
            } else if (dir == 'S') {
                robots[i][2] = 1;
            } else if (dir == 'W') {
                robots[i][2] = 2;
            } else {
                robots[i][2] = 3;
            }
            visited[x][y] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            if (!isPossible(idx, cmd, repeat)) {
                return;
            }
        }

        br.close();

        System.out.println("OK");
    }

    private static boolean isPossible(int idx, char cmd, int repeat) {
        int x = robots[idx][0];
        int y = robots[idx][1];
        int dir = robots[idx][2];

        while (repeat-- > 0) {
            if (cmd == 'L') {
                dir = (dir + 3) % 4;
            } else if (cmd == 'R') {
                dir = (dir + 1) % 4;
            } else if (cmd == 'F') {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(!isIn(nx, ny)) {
                    System.out.println("Robot " + idx + " crashes into the wall");
                    return false;
                } else if(visited[nx][ny] != 0) {
                    System.out.println("Robot " + idx + " crashes into robot " + visited[nx][ny]);
                    return false;
                }
                visited[x][y] = 0;
                visited[nx][ny] = idx;
                x = nx;
                y = ny;
            }
        }

        robots[idx][0] = x;
        robots[idx][1] = y;
        robots[idx][2] = dir;

        return true;
    }

    private static boolean isIn(int x, int y) {
        return x > 0 && x <= A && y > 0 && y <= B;
    }

}
