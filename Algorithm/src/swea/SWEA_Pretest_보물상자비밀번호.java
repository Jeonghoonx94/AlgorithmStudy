package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_Pretest_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			char[] pwd = br.readLine().toCharArray();
			int alen = N/4;
			
			Set<String> set = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			});
			int trial = 0;
			while(++trial < alen) {
				for(int i=0; i<N; ++i) {
					String tmp = "";
					for(int j=0; j<alen; ++j) {
						tmp += pwd[i+j];
					}
					set.add(tmp);
				}
				
				char tmp = pwd[N-1];
				for(int i=N-1; i>0; --i) {
					pwd[i] = pwd[i-1];
				}
				pwd[0] = tmp;
			}
			
			int k = 0;
			int ans = 0;
			for(String str : set) {
				if(++k == K) {
					ans = Integer.parseInt(str, 16);
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
