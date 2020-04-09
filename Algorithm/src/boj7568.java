import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] w_h = new int[n][2];
		int[] rank = new int[n];
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			w_h[i][0] = Integer.parseInt(st.nextToken());
			w_h[i][1] = Integer.parseInt(st.nextToken());
			rank[i] = 1;
		}
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j)
				if((w_h[i][0] < w_h[j][0]) && (w_h[i][1] < w_h[j][1]))
					++rank[i];
			bw.write(rank[i]+ " ");
		}
		bw.close();
	}
}
