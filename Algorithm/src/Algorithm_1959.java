import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_1959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();   // 배열 A의 원소 수
            int M = sc.nextInt();   // 배열 B의 원소 수
            int[] A = new int[N];
            int[] B = new int[M];
            int[] tmp = new int[Math.max(N-M+1, M-N+1)];
            int ans = 0;
             
            for(int i=0; i<N; ++i)
                A[i] = sc.nextInt();
            for(int i=0; i<M; ++i)
                B[i] = sc.nextInt();
             
            for(int i =0; i<tmp.length; ++i) {
                if(N>=M)
                    for(int j=0; j<M; ++j) {
                        tmp[i] += ( A[i+j]*B[j] );
                    }
                else
                    for(int j=0; j<N; ++j) {
                        tmp[i] += ( A[j]*B[i+j] );
                    }
            }
            Arrays.sort(tmp);
            ans = tmp[tmp.length-1];
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
	}

}
