package swea;
import java.util.Scanner;

public class Algorithm_1233 {
	static char[] tree;	// 트리
	static int n;	// 트리의 노드 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {

			n = sc.nextInt();	// 트리의 노드 수
			tree = new char[n+1];	// 노드 번호의 시작은 1부터
			for(int i=0; i<n; ++i)
				tree[sc.nextInt()] = sc.nextLine().charAt(1);	// 공백부터 읽어지므로 1
			
			System.out.println("#"+test_case+" "+isValid(n));
		}
		sc.close();
	}
	
	static int isValid(int i) {	// i: 트리의 마지막 노드 위치
		int result = 1;
		for(int a = i; a > 0; --a) {
			char c = tree[a];
			if(a>i/2) {	// 단말노드
				if(c >= '0' && c <='9')
					result = 1;
				else {
					result = 0;
					break;
				}
			} else {	// 부모노드
				if(c == '+' || c=='-' || c=='*' || c=='/')	// 연산자면
					result = 1;
				else {
					result = 0;
					break;
				}
			}
		}
		return result;
	}
}
