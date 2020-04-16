import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2748 {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibo(n));
	}
	static long fibo(int n)
	{
		long[] fibo = new long[100];
		fibo[0] = 0;
		if(n <1)
			return fibo[n];
        else {
        	fibo[1] = 1;
		    for(int i=2; i<=n; ++i)
			    fibo[i] = fibo[i-1] + fibo[i-2];
        }
		return fibo[n];
	}
}
