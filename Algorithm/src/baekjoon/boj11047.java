package baekjoon;
/*
 * BOJ 11047 - Coins 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] a = new int[n];
		for(int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(br.readLine());
		br.close();
		
		int v = 0;
		for(int i = n-1; i >= 0; --i)
			if(k / a[i] > 0) {
				v += (k / a[i]);
				k %= a[i];
			}
		System.out.println(v);
	}
}