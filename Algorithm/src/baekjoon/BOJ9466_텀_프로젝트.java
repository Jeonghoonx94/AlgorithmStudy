package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466_텀_프로젝트 {
    static int n;
    static int[] arr, first, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            first = new int[n + 1];
            visited = new int[n + 1];

            int count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; ++i) {
                if (visited[i] == 0) {
                    count += dfs(i, i, 1);
                }
            }

            System.out.println(n - count);
        }
    }

    private static int dfs(int start, int current, int cnt) {
        if (visited[current] > 0) {
            if (first[current] != start) {
                return 0;
            }
            return cnt - visited[current];
        }
        first[current] = start;
        visited[current] = cnt;
        return dfs(start, arr[current], cnt + 1);
    }
}
