package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕_G2 {
    static int R, C, M, Ans;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1}; // 상하우좌
    static Queue<Shark> moveQ;
    static Queue<Shark>[][] pq;

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

        moveQ = new LinkedList<>();
        pq = new PriorityQueue[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                pq[i][j] = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.size, o2.size));
            }
        }

        for (int m = 1; m <= M; ++m) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            s %= d < 2 ? 2 * (R - 1) : 2 * (C - 1);

            pq[r][c].offer(new Shark(r, c, s, d, z));
        }

        Ans = 0;
        int fkIdx = 0;

        // 1.낚시왕이 오른쪽으로 한칸 이동
        while (fkIdx < C) {
            // 2. 가까운 상어 잡기
            catchShark(fkIdx++);
            // 3. 상어 이동
            moveSharks();
        }

        System.out.println(Ans);
    }

    private static void catchShark(int fkIdx) {
        for (int i = 0; i < R; ++i) {
            if (!pq[i][fkIdx].isEmpty()) {
                Ans += pq[i][fkIdx].poll().size;
                return;
            }
        }
    }

    private static void moveSharks() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!pq[i][j].isEmpty() && pq[i][j].peek().speed > 0) {
                    moveQ.offer(pq[i][j].poll());
                }
            }
        }

        while (!moveQ.isEmpty()) {
            Shark shark = moveQ.poll();

            int cr = shark.r;
            int cc = shark.c;
            int cd = shark.direct;
            int cs = shark.speed;

            while (cs-- > 0) {
                cr += dr[cd];
                cc += dc[cd];

                // 0~3 : 상하우좌
                if (!isIn(cr, cc)) {
                    if (cd == 0) {
                        cd = 1;
                    } else if (cd == 1) {
                        cd = 0;
                    } else if (cd == 2) {
                        cd = 3;
                    } else {
                        cd = 2;
                    }
                    cr += dr[cd] * 2;
                    cc += dc[cd] * 2;
                }
            }

            shark.r = cr;
            shark.c = cc;
            shark.direct = cd;

            pq[cr][cc].offer(shark);
        }

        eatShark();
    }

    private static void eatShark() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                while (pq[i][j].size() > 1) {
                    pq[i][j].poll();
                }
            }
        }
    }

    private static boolean isIn(int cr, int cc) {
        return cr >= 0 && cr < R && cc >= 0 && cc < C;
    }

    static class Shark {
        int r, c, speed, direct, size;

        public Shark(int r, int c, int speed, int direct, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.direct = direct;
            this.size = size;
        }
    }
}