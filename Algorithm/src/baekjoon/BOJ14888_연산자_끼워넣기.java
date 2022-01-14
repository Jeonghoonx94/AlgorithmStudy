package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_연산자_끼워넣기 {
    static int N, Max = Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
    static int[] arr, ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        ops = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        find(0, arr[0]);

        System.out.println(Max);
        System.out.println(Min);
    }

    private static void find(int cnt, int val) {
        if (cnt == N - 1) {
            if (val > Max) {
                Max = val;
            }
            if (val < Min) {
                Min = val;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] <= 0) {
                continue;
            }
            ops[i]--;
            find(cnt + 1, calc(val, arr[cnt + 1], i));
            ops[i]++;
        }
    }

    private static int calc(int a, int b, int op) {
        int result = 0;
        switch (op) {
            case 0:
                result = a + b;
                break;
            case 1:
                result = a - b;
                break;
            case 2:
                result = a * b;
                break;
            case 3:
                result = a / b;
                break;
        }

        return result;
    }
}
