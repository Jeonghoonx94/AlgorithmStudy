package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1003 {
	static StringBuilder sb = new StringBuilder();
	static long[] fibo = new long[41];
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		fibo[0] = 0;
		fibo[1] = 1;
		for(int tc = 0; tc<t; ++tc) {
			int n = Integer.parseInt(br.readLine()); 
			// In Fibonacci Sequence, Number of 0 = (n-1)th value
			// Number of 1 = (n)th value
			sb.append(fibo(n-1) + " " + fibo(n) + "\n");
		}
		br.close();
		System.out.println(sb);
	}
	static long fibo(int n)
	{
		if(n == -1)
			return 1;
		if(fibo[n] != 0)
			return fibo[n];
		else {
		    for(int i=2; i<=n; ++i)
			    fibo[i] = fibo[i-1] + fibo[i-2];
			return fibo[n];
		}
	}
}