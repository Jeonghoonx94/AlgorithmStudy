import java.util.Arrays;
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
		int[] ans = new int[n*(n-1)*(n-2)/6];	// n개에서 3개의 조합(중복x) : nC_3
		int count = -1;	// 
		for(int i=0; i<n; ++i)
//			a[i] = Integer.parseInt(arr[i]);
			a[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<n-2; ++i) {
			for(int j=i+1; j<n-1; ++j) {
				for(int k = j+1; k<n; ++k) {
					ans[++count] = a[i]+a[j]+a[k];
					if(ans[count] == m) break;	// m과 같은 수가 있다면 반복문 종료
				}
				if(ans[count] == m) break;
			}
			if(ans[count] == m) break;
		}
		if(ans[count] == m)
			bw.write(ans[count]+"\n");
		else {
			Arrays.sort(ans);	// 오름차순으로 정렬
			for(int i = ans.length-1; i>=0; --i)
				if(ans[i] < m) {
					bw.write(ans[i]+"\n");
					break;
				}
		}
		bw.flush();
		bw.close();
	}
}
