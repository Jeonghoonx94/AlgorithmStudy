package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14496_그대_그머가_되어 {
    static int a, b, N, M, Ans;
    static List<Integer>[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            pos[i] = new ArrayList<>();
        }
        Ans = Integer.MAX_VALUE;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pos[from].add(to);
            pos[to].add(from);
        }

        bfs(a);

        System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == b) {
                Ans = cur[1];
                return;
            }
            for (int next : pos[cur[0]]) {
                if (!visited[next]) {
                    q.add(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
    }

}
