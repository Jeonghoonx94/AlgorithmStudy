package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473_세_용액 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];
		long[] ans = new long[3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		long min = 3000000000l; // 3billion
		
		// one value is fixed
		for(int i=0; i<N-2; ++i) {
			int left = i+1, right = N - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					ans[0] = arr[i];
					ans[1] = arr[left];
					ans[2] = arr[right];
				}
				
				if(sum > 0) {
					right--;
					left++;
				} else {
				}
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
