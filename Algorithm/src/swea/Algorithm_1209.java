package swea;
//import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int crossSum = 0, crossSum2 = 0, k = -1;
			int[][] a = new int[100][100];	// 입력받은 100x100 배열
			int[] sums = new int[2 * a.length + 2];	// 가로 합 100개, 세로 합 100개, 대각선 합 2개
			for(int i=0; i<a.length; ++i) {
				int sum = 0;
				for(int j=0; j < a[i].length; ++j) {
					a[i][j] = sc.nextInt();
					sum += a[i][j];					// 가로 합
					if(i==j)
						crossSum += a[i][j];		// 좌상우하 대각선 합
					if(j == a[i].length-i-1)
						crossSum2 += a[i][j];		// 우상좌하 대각선 합
				}
				sums[++k] = sum;
			}
			sums[++k] = crossSum;
			sums[++k] = crossSum2;
			for(int i=0; i<a.length; ++i) {
				int sum = 0;
				for(int j=0; j<a[i].length; ++j) {
					sum += a[j][i];	// 세로 합
				}
				if(k>=sums.length)	// k가 sums 길이보다 커지면 그만
					break;
				sums[++k] = sum;
			}
			for(int i=0; i<sums.length-1; ++i) {	// 선택 정렬
				int tmp, minIndex = i;
				for(int j=i+1; j<sums.length; ++j) {
					if( sums[minIndex] > sums[j] )
						minIndex = j;	
				}
				tmp = sums[minIndex];
				sums[minIndex] = sums[i];
				sums[i] = tmp;
			}
//			Arrays.sort(sums);
			
			System.out.println("#"+T+" "+sums[sums.length-1]);
		}
		sc.close();
	}
	
}
