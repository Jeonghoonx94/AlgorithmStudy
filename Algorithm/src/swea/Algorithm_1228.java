package swea;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm_1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {
			int n = sc.nextInt();	// 원본 암호문의 길이 n (10 <= n <= 20)
			LinkedList<Integer> list = new LinkedList<Integer>();
			int x = 0, y = 0;
			
			for(int i=0; i<n; ++i)	// 원본 암호문
				list.add(sc.nextInt());
			int instr = sc.nextInt();
			while(instr > 0) {
				if(sc.next().equals("I")) {	// 삽입 명령어 l이면
					--instr;
					x = sc.nextInt();
					y = sc.nextInt();
				}
				for(int i=0; i<y; ++i)
					list.add(x+i, sc.nextInt());
			}
			
			System.out.print("#"+test_case);
			for(int i=0; i<10; ++i) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
			list.clear();
		}
		sc.close();
	}
}
