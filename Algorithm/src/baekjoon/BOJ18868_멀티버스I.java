package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18868_멀티버스I {
    static int M, N, Ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 우주 개수
        N = Integer.parseInt(st.nextToken()); // 각 우주의 행성 수

        int[][] map = new int[M][N];

        for(int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M-1; ++i) {
            for(int j=i+1; j<M; ++j) {
                if(isSimilar(map[i], map[j])) {
                    Ans++;
                }
            }
        }

        System.out.println(Ans);
        br.close();
    }

    private static boolean isSimilar(int[] arr, int[] arr2) {
        for(int i=0; i<N-1; ++i) {
            for(int j=i+1; j<N; ++j) {
                if(compare(arr[i], arr[j]) != compare(arr2[i], arr2[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int compare(int i, int j) {
        if(i < j) {
            return 1;
        }
        if(i == 0) {
            return 0;
        }
        return -1;
    }
}
