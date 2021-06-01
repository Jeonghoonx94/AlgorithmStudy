package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1719_택배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());

        int[][] Graph = new int[n][n], Ans = new int[n][n];
        int max = 200 * 1000 + 1;
        for (int i = 1; i < n; ++i) {
            Arrays.fill(Graph[i], max);
            Graph[i][i] = 0;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Graph[from][to] = Graph[to][from] = Integer.parseInt(st.nextToken());
            Ans[from][to] = to;
            Ans[to][from] = from;
        }

        for (int b = 1; b < n; ++b) {
            for (int f = 1; f < n; ++f) {
                for (int t = 1; t < n; ++t) {
                    if (Graph[f][t] > Graph[f][b] + Graph[b][t]) {
                        Graph[f][t] = Graph[f][b] + Graph[b][t];
                        Ans[f][t] = Ans[f][b];
                    }
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(Ans[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
