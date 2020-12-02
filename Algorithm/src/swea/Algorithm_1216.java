package swea;
import java.util.Scanner;

public class Algorithm_1216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)	{
			int tc = sc.nextInt();
			
			char[][] arr = new char[100][100];
			for(int i=0; i<100; ++i)
				arr[i]= sc.next().toCharArray();
			
			int count = 0;
			int max = Integer.MIN_VALUE;
			for(int T=2;T<=100; ++T) {	// 회문의 길이는 최소 2부터 최대 100
				for(int i=0; i<100; ++i) {
					boolean flag;	// 회문 플래그4
					for(int j=0; j<100-T+1; ++j) {
						flag = true;
						for(int k=0; k<T/2; ++k) {
							if(arr[i][k+j] != arr[i][T-k-1 + j]) {	// 가로
								flag = false;	// 회문이 아니라면
								break;			// 그만
							}
						}
						if(flag)	// 회문이라면
							if(max<T)	// T의 최대값
								max = T;
						flag = true;
						for(int k=0; k<T/2; ++k) {
							if(arr[k+j][i] != arr[T-k-1 + j][i]) {	// 세로
								flag = false;
								break;
							}
						}
						if(flag)
							if(max<T)
								max = T;
					}
				}
			}
			System.out.println("#"+tc+" "+count);
		}
		sc.close();
	}

}
