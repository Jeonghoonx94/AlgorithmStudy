package swea;
import java.util.Scanner;

public class Algorithm_1204 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	// 테스트 횟수

		int tc, tmp;
     
		for(int test_case = 1; test_case <= T; test_case++)
		{
    		int[] score = new int[101];	// []: 점수, 값: 학생 수
    		int most = 0, ans = 0;
             
    		tc = sc.nextInt();
	         for(int i=0; i<1000; i++) {
	             tmp = sc.nextInt();
	             ++score[tmp];
	         }
	         for(int i=0; i<101; i++) {
	             if(most<=score[i]){
	                 most = score[i];
	                 ans = i;
	             }
	         }
	         System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}
