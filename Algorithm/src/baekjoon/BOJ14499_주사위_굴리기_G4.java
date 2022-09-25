package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499_주사위_굴리기_G4 {
    static int N, M, x, y, K;
    static int[] di = {0, 0, -1, 1}, dj = {1, -1, 0, 0};// 동서북남
    static int[] Dice = new int[6];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int dir = st.nextToken().charAt(0) - '1';
            if (moveDice(dir)) {
                rollDice(dir);
            }
        }
    }

    private static boolean moveDice(int dir) {
        // x : di, y : dj
        int ni = x + di[dir];
        int nj = y + dj[dir];

        if (!isIn(ni, nj)) {
            return false;
        }

        x = ni;
        y = nj;

        return true;
    }

    private static void rollDice(int dir) {
        int tmp = Dice[0];
        switch (dir) {
            case 0: // 동
                Dice[0] = Dice[3];
                Dice[3] = Dice[5];
                Dice[5] = Dice[2];
                Dice[2] = tmp;
                break;
            case 1: // 서
                Dice[0] = Dice[2];
                Dice[2] = Dice[5];
                Dice[5] = Dice[3];
                Dice[3] = tmp;
                break;
            case 2: // 북
                Dice[0] = Dice[4];
                Dice[4] = Dice[5];
                Dice[5] = Dice[1];
                Dice[1] = tmp;
                break;
            case 3: // 남
                Dice[0] = Dice[1];
                Dice[1] = Dice[5];
                Dice[5] = Dice[4];
                Dice[4] = tmp;
                break;
        }

        if (map[x][y] == 0) {
            map[x][y] = Dice[5];
        } else {
            Dice[5] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(Dice[0]);
    }

    static boolean isIn(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
