package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17471_게리맨더링 {
    static int N, Ans = Integer.MAX_VALUE;
    static int[] pop;
    static boolean[] visited;
    static boolean[][] pop_adj;
    static List<Integer> selected = new ArrayList<>(), other = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pop = new int[N + 1];
        visited = new boolean[N + 1];
        pop_adj = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1, t; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t = Integer.parseInt(st.nextToken());
            while (t-- > 0) {
                int n = Integer.parseInt(st.nextToken());
                pop_adj[i][n] = pop_adj[n][i] = true;
            }
        }

        comb(1, 0);

        System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);

        br.close();
    }

    private static void comb(int start, int cnt) {
        if (cnt >= 1) {
            if (isPossible()) {
                calculate();
            }
        }

        for (int i = start; i <= N; i++) {
            selected.add(i);
            comb(i + 1, cnt + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static boolean isPossible() {
        int sSize = selected.size();
        other.clear();

        if (sSize == 0 || sSize == N) {
            return false;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected.contains(i)) {
                other.add(i);
            }
        }

        return isConnected(selected) && isConnected(other);
    }

    private static boolean isConnected(List<Integer> list) {
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(list.get(0));
        visited[list.get(0)] = true;
        int adjSize = 1;

        while (!q.isEmpty()) {
            int c = q.poll();

            for (int n : list) {
                if (pop_adj[c][n] && !visited[n]) {
                    adjSize++;
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }

        return adjSize == list.size();
    }

    private static void calculate() {
        int ap = 0, bp = 0;

        for (int i = 1; i <= N; i++) {
            if (selected.contains(i)) {
                ap += pop[i];
            } else {
                bp += pop[i];
            }
        }

        Ans = Math.min(Ans, Math.abs(ap - bp));
    }
}
