package swea;
import java.util.Scanner;

public class Algorithm_9658 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            int leng = s.length() -1;
            int num=0;
            float ans = 0f;
             
            for(int i=0; i<3; ++i) {
                num += s.charAt(i) - '0';
                if(i==2) break;
                num *= 10;
            }
            ans = num/10f;
            num = Math.round(ans);
            ans = num/10f;
            if(ans>=10f) {
                ans /= 10;
                ++leng;
            }
            System.out.println("#"+test_case+" "+ ans + "*10^" + leng);
        }
        sc.close();
	}

}
