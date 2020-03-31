import java.util.Scanner;
public class Algorithm_1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			int ans = mth_degree(n, m);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	static int mth_degree(int n, int m) {
		int ans = 1;
		for(int i=0; i<m; ++i) {
			ans *=n;
		}
		return ans;
	}
}
