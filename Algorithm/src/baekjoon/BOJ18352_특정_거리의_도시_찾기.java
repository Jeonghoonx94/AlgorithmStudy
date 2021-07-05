package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_특정_거리의_도시_찾기 {
    static int N, M, K, X;
    static List<Integer>[] pos;
    static List<Integer> Ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시
        M = Integer.parseInt(st.nextToken()); // 도로
        K = Integer.parseInt(st.nextToken()); // 거리
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        pos = new List[N + 1];
        Ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            pos[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pos[from].add(to);
        }

        bfs(X);

        if (Ans.size() == 0) {
            System.out.println(-1);
        } else {
            Ans.sort(null);
            for (int a : Ans) {
                System.out.println(a);
            }
        }
    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] == K) {
                Ans.add(cur[0]);
            }
            if (cur[1] < K) {
                for (int i : pos[cur[0]]) {
                    if(!visited[i]) {
                        q.add(new int[] {i, cur[1] + 1});
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
