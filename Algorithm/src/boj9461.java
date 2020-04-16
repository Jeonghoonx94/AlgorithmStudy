import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9461 {
	static StringBuilder sb = new StringBuilder();
	static long[] p = new long[101];
	public static void main(String[] args) throws java.io.IOException {
		p[1] = 1; p[2] = 1; p[3] = 1; p[4] = 2; p[5] = 2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			sb.append(padovan(n)+"\n");
		}
		br.close();
		System.out.println(sb);
	}
	static long padovan(int n)
	{
	    for(int i=6; i<=n; ++i)
		    p[i] = p[i-1] + p[i-5];
		return p[n];
	}
}