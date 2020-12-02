package swea;
import java.util.Scanner;

public class Algorithm_1222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			int result = 0;
			int length = sc.nextInt();
			String s = sc.next();
			
			result = solve(s, length);
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
	
	static int solve(String s, int length) {
		int result = 0;
		for(int i=0; i<length; ++i) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				result += s.charAt(i)-'0';
			}
		}
		return result;
	}
}
