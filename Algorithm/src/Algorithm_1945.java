import java.util.Scanner;

public class Algorithm_1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a=0, b=0, c=0, d=0, e=0;
            int N = sc.nextInt();
            while(N!=1) {
                if(N%2 == 0) {
                    N = N/2;
                    ++a;
                }
                if(N%3 == 0) {
                    N = N/ 3;
                    ++b;
                }
                if(N%5 == 0) {
                    N = N/5;
                    ++c;
                }
                if(N%7 == 0) {
                    N = N/7;
                    ++d;
                }
                if(N%11 == 0) {
                    N = N/11;
                    ++e;
                }
            }
            System.out.println("#"+test_case+" "+a+" "+b+" "+c+" "+d+" "+e);
        }
	}

}
