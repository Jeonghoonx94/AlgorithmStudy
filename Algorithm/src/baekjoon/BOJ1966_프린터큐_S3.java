package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<int[]> q = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;

            while(!q.isEmpty()) {
                int max = findMax(q);
                int[] cur = q.poll();

                if (cur[1] < max) {
                    q.offer(cur);
                } else if (cur[1] == max) {
                    cnt++;
                    if(cur[0] == M) {
                        break;
                    }
                }
            }

            sb.append(cnt).append('\n');

            q.clear();
        }

        System.out.println(sb);
    }

    private static int findMax(Queue<int[]> q) {
        int val = q.peek()[1];

        for (int[] data : q) {
            if (val < data[1]) {
                val = data[1];
            }
        }

        return val;
    }
}
