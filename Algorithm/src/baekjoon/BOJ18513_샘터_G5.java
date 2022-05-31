package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ18513_샘터_G5 {

    static int N, K;
    static int[] dx = {-1, 1};
    static Queue<int[]> q;
    static Set<Integer> existed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        existed = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int pos = Integer.parseInt(st.nextToken());
            q.offer(new int[]{pos, pos});
            existed.add(pos);
        }

        System.out.println(bfs());
    }

    private static long bfs() {
        long res = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int cp = q.peek()[0];
                int sp = q.poll()[1];

                for (int i = 0; i < 2; ++i) {
                    int np = cp + dx[i];

                    if (existed.contains(np)) {
                        continue;
                    }

                    res += Math.abs(np - sp);

                    if (--K == 0) {
                        return res;
                    }

                    q.offer(new int[]{np, sp});
                    existed.add(np);
                }
            }
        }

        return res;
    }

}
