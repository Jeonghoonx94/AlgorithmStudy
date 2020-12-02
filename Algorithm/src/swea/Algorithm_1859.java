package swea;
import java.util.Scanner;

public class Algorithm_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; ++i)
            	arr[i] = sc.nextInt();
            int max = arr[n-1];
            for(int i= n-2; i>=0; --i) {
            	if(max<arr[i]) max = arr[i];
            	else ans += max-arr[i];
            }
            System.out.println("#"+test_case+" "+ans);
		}
		sc.close();
	}

}
