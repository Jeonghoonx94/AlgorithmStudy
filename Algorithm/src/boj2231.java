import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class boj2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int m = n;
		int min = Integer.MAX_VALUE;
		while(m>0) {
			int tmp = m;
			int sum = m;
			while(tmp>0) {
				sum += tmp%10;
				tmp /= 10; 
			}
			if(sum == n)
				min = Math.min(min, m);
			--m;
		}
		if(min == Integer.MAX_VALUE)
			min = 0;
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}

}
