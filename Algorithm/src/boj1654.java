/*
 * BOJ 1654 - Cut the LAN
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        long max = 0;
        long min = 1;

        int[] arr = new int[k];
        for(int i = 0; i < k; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            max += arr[i];
        }
        // 가장 최대가 될수 있는 값
        max /= n;

        while(min <= max) {
            long mid = (min + max) / 2;
            boolean check = isPossible(arr, n, mid);
            // 중간 값이 n 이상이면
            if(check)
                min = mid + 1;
            // 중간 값이 n 미만이면
            else
                max = mid - 1;
        }
        System.out.println(min - 1);
    }
    static boolean isPossible(int[] arr, int N, long key) {
        int count = 0;
        for (int i : arr)
            count += i / key;
        return count >= N;
    }
}
