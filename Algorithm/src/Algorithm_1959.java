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
//            int[] tmp = new int[Math.max(N-M+1, M-N+1)];
            int ans;
             
            for(int i=0; i<N; ++i)
                A[i] = sc.nextInt();
            for(int i=0; i<M; ++i)
                B[i] = sc.nextInt();
             
            if(N>=M) 	ans = calculate(A, B);
            else		ans = calculate(B, A);
            
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
	}
	
	static int calculate(int[] a, int[] b) {
		int[] tmp = new int[ a.length - b.length +1 ];
//		int result = Integer.MIN_VALUE;
		
		for(int i =0; i<=a.length - b.length; ++i) {
			int sum = 0;
			for(int j=0; j<b.length; ++j)
//				sum += ( a[i+j] * b[j] );
				tmp[i] += ( a[i+j] * b[j] );
//			result = Math.max(sum, result);
		}
		
        Arrays.sort(tmp);	// 오름차순 정렬
        
        return tmp[tmp.length-1];	// 마지막 원소
//		return result;
	}

}
