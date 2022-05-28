package baekjoon;
/*
 * BOJ 10816 - Number Card 2
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816_숫자카드2_S4 {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(m-- > 0) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(binaryRightIndexSearch(arr, target) - binaryLeftIndexSearch(arr, target)).append(' ');
		}

		System.out.println(sb);
	}

	private static int binaryRightIndexSearch(int[] arr, int target) {
		int start = 0, end = arr.length;
		while(start < end) {
			int middle = (start + end) / 2;
			if(target < arr[middle])	end = middle;
			else	start = middle + 1;
		}
		return start;
	}

	private static int binaryLeftIndexSearch(int[] arr, int target) {
		int start = 0, end = arr.length;
		while(start < end) {
			int middle = (start + end) / 2;
			if(target <= arr[middle])	end = middle;
			else	start = middle + 1;
		}
		return start;
	}
}
