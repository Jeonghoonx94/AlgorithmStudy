/*
 * BOJ 1931 - Meeting room Assignment
 * Greedy Algorithm
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; ++i) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		// sort by ending time
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				// if ending time is same, sort by start time 
				if(o1[1] == o2[1])
					return Integer.compare(o1[0], o2[0]);
				else
					return Integer.compare(o1[1], o2[1]);
			}
		});
		// Sort Result
//		for(int i=0; i<n; ++i)
//			System.out.println(arr[i][0]+", "+arr[i][1]);
		
		// O(n)
		int count = 1;
		int next = arr[0][1];
		for(int j = 1; j < n; ++j)
			if(arr[j][0] >= next) {
				++count;
				next = arr[j][1];
			}
		System.out.println(count);
		
		/*	O(n^2)
		int max = 0;
		for(int i = 0; i < n; ++i) {
			int count = 1;
			int next = arr[i][1];
			for(int j = i+1; j < n; ++j) {
				if(arr[j][0] >= next) {
					
					++count;
					next = arr[j][1];
				}
			}
			max = Math.max(max, count); 
		}
		System.out.println(max);
		*/
	}
}