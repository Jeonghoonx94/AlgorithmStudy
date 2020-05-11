/*
 * BOJ 2805 - Cut the Trees
 * Binary Search
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] trees = new int[N];
		s = br.readLine().split(" ");
		for(int i = 0; i<N; ++i)
			trees[i] = Integer.parseInt(s[i]);
		
		binarySearch(trees, N, M);
	}
	
	static void binarySearch(int[] trees, int N, int M) {
		// 각 트리의 높이에서 설정한 h를 뺀 값들의 합이 최소 M 이상을 만족하는 h의 최대값
		int low = 0;
		int high = 1000000000;
		
		while(low <= high) {
			int h = (low + high) / 2;
			long sum = 0;
			for(int i : trees)
				if( i - h > 0)
					sum += (i - h);
			if(sum >= M)
				low = h + 1;
			else
				high = h - 1;
		}
		
		System.out.println(low - 1);
	}
}