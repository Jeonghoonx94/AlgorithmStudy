package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100_2048_Easy_G2 {
    static int N, Ans;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(0);

        System.out.println(Ans);
    }

    private static void play(int cnt) {
        if (cnt == 5) {
            for (int[] data : map) {
                for (int d : data) {
                    if (Ans < d) {
                        Ans = d;
                    }
                }
            }

            return;
        }

        int[][] copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for (int d = 0; d < 4; d++) {
            move(d);
            play(cnt + 1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = copy[i][j];
                }
            }
        }

    }

    private static void move(int dir) {
        boolean[][] visited = new boolean[N][N];

        switch (dir) {
            case 0: // 상
                for (int j = 0; j < N; j++) {
                    for (int i = 1; i < N; i++) {
                        if (map[i][j] == 0) continue;

                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] == map[k + 1][j] && !visited[k][j]) { // 같은 숫자
                                visited[k][j] = true;
                                map[k][j] *= 2;
                                map[k + 1][j] = 0;
                                break;
                            } else if (map[k][j] == 0) {    // 빈 자리
                                map[k][j] = map[k + 1][j];
                                map[k + 1][j] = 0;
                            } else {    // 다른 숫자
                                break;
                            }
                        }
                    }
                }

                break;
            case 1: // 하
                for (int j = 0; j < N; j++) {
                    for (int i = N - 2; i >= 0; i--) {
                        if (map[i][j] == 0) continue;

                        for (int k = i + 1; k < N; k++) {
                            if (map[k][j] == map[k - 1][j] && !visited[k][j]) {
                                visited[k][j] = true;
                                map[k][j] *= 2;
                                map[k - 1][j] = 0;
                                break;
                            } else if (map[k][j] == 0) {
                                map[k][j] = map[k - 1][j];
                                map[k - 1][j] = 0;
                            } else {
                                break;
                            }
                        }
                    }
                }

                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (map[i][j] == 0) continue;

                        for (int k = j - 1; k >= 0; k--) {
                            if (map[i][k] == map[i][k + 1] && !visited[i][k]) {
                                visited[i][k] = true;
                                map[i][k] *= 2;
                                map[i][k + 1] = 0;
                                break;
                            } else if (map[i][k] == 0) {
                                map[i][k] = map[i][k + 1];
                                map[i][k + 1] = 0;
                            } else {
                                break;
                            }
                        }
                    }
                }

                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (map[i][j] == 0) continue;

                        for (int k = j + 1; k < N; k++) {
                            if (map[i][k] == map[i][k - 1] && !visited[i][k]) {
                                visited[i][k] = true;
                                map[i][k] *= 2;
                                map[i][k - 1] = 0;
                                break;
                            } else if (map[i][k] == 0) {
                                map[i][k] = map[i][k - 1];
                                map[i][k - 1] = 0;
                            } else {
                                break;
                            }
                        }
                    }
                }

                break;
        }

    }

}
