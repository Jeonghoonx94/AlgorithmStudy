package swea;
import java.util.*;

public class Algorithm_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; ++test_case) {
			String num = sc.next();
			int count = sc.nextInt();
			int max = 0;
			int min = 0;
			
			while(count>0) {
				for(int i=0; i<num.length(); ++i) {
					if(num.charAt(max) <= num.charAt(i)) max = i;
					if(num.charAt(min) > num.charAt(i)) min = i;
				}
				for(int i=0; i<num.length(); ++i) {
					if(num.charAt(i)<num.charAt(max)) {
						char tmp = num.charAt(i);
//						num.
//						num.charAt
					}
				}
				--count;
			}

//			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
}
