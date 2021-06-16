package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404_플로이드_G4 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine()) + 1;
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // map 초기화
        int max = 100000 * (n - 1) + 1;
        for (int i = 1; i < n; ++i) {
            Arrays.fill(map[i], max);
            map[i][i] = 0;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (map[from][to] > weight) { // 같은 from, to의 다른 weight 값이 존재할 수 있음
                map[from][to] = weight;
            }
        }

        for (int b = 1; b < n; ++b) {
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (map[i][j] > map[i][b] + map[b][j]) {
                        map[i][j] = map[i][b] + map[b][j];
                    }
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                sb.append(map[i][j] == max ? 0 + " " : map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
