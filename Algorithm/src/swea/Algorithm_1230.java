package swea;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm_1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {
			
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			int n = sc.nextInt();	// 원본 암호문의 길이 n (10 <= n <= 20)
			
			for(int i=0; i<n; ++i)	// 원본 암호문
				list.add(sc.nextInt());
			int instr = sc.nextInt();
			
			int x = 0, y = 0;
			
			while(instr > 0) {
				String s = sc.next();	// 명령어
				if(s.equals("I")) {	// 삽입 I 이면
					x = sc.nextInt();
					y = sc.nextInt();
					for(int i=0; i<y; ++i)
						list.add(x+i, sc.nextInt());
				} 
				else if(s.equals("D")) {	// 삭제 D 이면
					x = sc.nextInt();
					y = sc.nextInt();
					for(int i=0; i<y; ++i)
						list.remove(x);
				} 
				else if(s.equals("A")) {	// 추가 A 이면
					y = sc.nextInt();
					for(int i=0; i<y; ++i)
						list.addLast(sc.nextInt());
				}
				--instr;
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