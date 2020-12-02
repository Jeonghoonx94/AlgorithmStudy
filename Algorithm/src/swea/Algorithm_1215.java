package swea;
import java.util.Scanner;

public class Algorithm_1215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 1; test_case++)	{
			int T = sc.nextInt();
			
			char[][] arr = new char[8][8];
			for(int i=0; i<8; ++i) {
				String s = sc.next();
				for(int j=0; j<8; ++j)
					arr[i][j] = s.charAt(j);
			}
			int count = 0;

			
			for(int i=0; i<8; ++i) {
				boolean flag;	// 회문 플래그
				for(int j=0; j<8-T+1; ++j) {
					flag = true;
					for(int k=0; k<T/2; ++k) {
						if(arr[i][k+j] != arr[i][T-k-1 + j]) {	// 가로
							flag = false;	// 회문이 아니라면
							break;			// 그만
						}
					}
					if(flag)	// 회문이라면
						++count;	// 증가
					flag = true;
					for(int k=0; k<T/2; ++k) {
						if(arr[k+j][i] != arr[T-k-1 + j][i]) {	// 세로
							flag = false;
							break;
						}
					}
					if(flag)	// 회문이라면
						++count;	// 증가
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
		sc.close();
	}

}
