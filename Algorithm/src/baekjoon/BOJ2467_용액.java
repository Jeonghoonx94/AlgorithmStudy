package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467_용액 {
	// 2 ~ 100,000
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] ans = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = arr.length - 1;
		int sum = 2000000000; // 2billion

		while (left < right) {
			if (Math.abs(arr[left] + arr[right]) < sum) {
				sum = Math.abs(arr[left] + arr[right]);
				ans[0] = arr[left];
				ans[1] = arr[right];
			}
			
			if(arr[left] + arr[right] < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(ans[0] + " " + ans[1]);
	}
}
