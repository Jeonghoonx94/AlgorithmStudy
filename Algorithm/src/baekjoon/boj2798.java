package baekjoon;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		String[] s = br.readLine().split(" ");
//		int n = Integer.parseInt(s[0]);
//		int m = Integer.parseInt(s[1]);
//		String[] arr = br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());	// = new StringTokenizer(br.readLine(), " "); 
		br.close();
		int[] a = new int[n];	// n개의 숫자를 넣기 위한 배열
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; ++i)
//			a[i] = Integer.parseInt(arr[i]);
			a[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<n-2; ++i)
			for(int j=i+1; j<n-1; ++j)
				for(int k = j+1; k<n; ++k)
					if(max<a[i]+a[j]+a[k] && m>=a[i]+a[j]+a[k])
						max = a[i]+a[j]+a[k];
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
