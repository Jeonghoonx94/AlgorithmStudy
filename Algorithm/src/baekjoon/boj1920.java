package baekjoon;
/*
 * BOJ 1920 - Find Number
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i){
//			int flag = Arrays.binarySearch(A, Integer.parseInt(st.nextToken()));
//			if(flag >= 0)
//				System.out.println(1);
//			else System.out.println(0);
			System.out.println(binarySearch(A, Integer.parseInt(st.nextToken())));
		}
	}
	static int binarySearch(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int middle = start + (end - start)/2;
			if(target == arr[middle])	return 1;
			else if(target > arr[middle])	start = middle + 1;
			else	end = middle - 1;
		}
		return 0;
	}
}
