package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕_G2 {
    static int R, C, M, Ans;
    static Shark[] Sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M == 0) {
            System.out.println(0);
            return;
        }

        Sharks = new Shark[M];

        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1 || d == 2) {
                s = s % (2 * (R - 1));
            } else {
                s = s % (2 * (C - 1));
            }

            Sharks[m] = new Shark(r, c, s, d, z);
        }

        Ans = 0;
        int fkIdx = 0;

        // 1.낚시왕이 오른쪽으로 한칸 이동
        while (fkIdx++ < C) {
            // 2. 가까운 상어 잡기
            catchShark(fkIdx);
            // 3. 상어 이동
            moveSharks();
        }

        System.out.println(Ans);
    }

    private static void catchShark(int fkIdx) {
        for (int i = 1; i <= R; ++i) {
            for (int idx = 0; idx < M; ++idx) {
                if (Sharks[idx].alive && Sharks[idx].c == fkIdx && Sharks[idx].r == i) {
                    Ans += Sharks[idx].size;
                    Sharks[idx].alive = false;
                    return;
                }
            }
        }
    }

    private static void moveSharks() {
        int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, 1, -1}; // x상하우좌

        for (int idx = 0; idx < M; ++idx) {
            if (!Sharks[idx].alive) {
                continue;
            }

            int r = Sharks[idx].r;
            int c = Sharks[idx].c;
            int d = Sharks[idx].direct;
            int s = Sharks[idx].speed;

            while (s-- > 0) {
                r += dr[d];
                c += dc[d];

                // 1~4 : 상하우좌
                if (d == 1 || d == 2) {
                    if (r > R) { // 맨 아래에 위치
                        d = 1; // 상으로 바꾸기
                        r -= 2;
                    }
                    if (r == 0) {
                        d = 2;
                        r += 2;
                    }
                } else {
                    if (c > C) {
                        d = 4;
                        c -= 2;
                    }
                    if (c == 0) {
                        d = 3;
                        c += 2;
                    }
                }
            }

            Sharks[idx].r = r;
            Sharks[idx].c = c;
            Sharks[idx].direct = d;
        }

        // 같은 칸 잡아먹기
        eatShark();
    }

    private static void eatShark() {
        for (int i = 0; i < M - 1; ++i) {
            if (!Sharks[i].alive) {
                continue;
            }

            for (int j = i + 1; j < M; ++j) {
                if (!Sharks[j].alive) {
                    continue;
                }

                if (Sharks[i].r == Sharks[j].r && Sharks[i].c == Sharks[j].c) {
                    if (Sharks[i].size > Sharks[j].size) {
                        Sharks[j].alive = false;
                    } else {
                        Sharks[i].alive = false;
                    }
                    break;
                }
            }
        }
    }

    static class Shark {
        int r, c, speed, direct, size;
        boolean alive;

        public Shark(int r, int c, int speed, int direct, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.direct = direct;
            this.size = size;
            this.alive = true;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", speed=" + speed +
                    ", direct=" + direct +
                    ", size=" + size +
                    '}';
        }
    }
}