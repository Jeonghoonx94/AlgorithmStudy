/*
 * BOJ 10816 - Number Card 2
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {
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
		for(int i = 0; i < m; ++i) {
			int target = Integer.parseInt(st.nextToken());
//			System.out.print(binaryRightIndexSearch(list, target)+" ");
			System.out.print(binaryRightIndexSearch(A, target)-binaryLeftIndexSearch(A, target)+" ");
		}
	}
	
	static int binaryRightIndexSearch(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int middle = start + (end - start)/2;
			if(target >= arr[middle])	start = middle + 1;
			else	end = middle - 1;
		}
		return start;
	}
	
	static int binaryLeftIndexSearch(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int middle = start + (end - start)/2;
			if(target <= arr[middle])	end = middle - 1;
			else	start = middle + 1;
		}
		return start;
	}
}
