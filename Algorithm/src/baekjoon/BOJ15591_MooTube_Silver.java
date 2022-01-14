package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ15591_MooTube_Silver {
    static int N, Q;
    static List<int[]>[] U;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);
        U = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            U[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);

            U[p].add(new int[]{q, r});
            U[q].add(new int[]{p, r});
        }

        while (Q-- > 0) {
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            int cnt = 0;

            visited[v] = true;
            q.offer(v);

            while (!q.isEmpty()) {
                int cv = q.poll();

                for (int[] next : U[cv]) {
                    int nv = next[0];
                    int nk = next[1];

                    if (!visited[nv] && nk >= k) {
                        cnt++;
                        visited[nv] = true;
                        q.offer(nv);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        br.close();

        System.out.println(sb);
    }

}
