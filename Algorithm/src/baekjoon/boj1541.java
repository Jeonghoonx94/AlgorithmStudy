package baekjoon;
/*
 * BOJ 1541 - Lost Parenthesis
 * Greedy Algorithm
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1541 {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		br.close();

		solve(s);
	}
	static void solve(String s) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		for(int i = 0; i < s.length(); ++i) {
			String tmp = new String();
			// 문자열에서 음수가 가장 처음으로 나올 때
			if(i == 0 && s.charAt(i) == '-') {
				s1.push(0);
				s2.push(s.charAt(i++));
			}
			
			// 연산자를 제외한 숫자 푸시
			while(Character.isDigit(s.charAt(i))) {
				tmp += s.charAt(i++);
				if(i >= s.length()) {
					i -= 1;
					break;
				}
			}
			s1.push(Integer.parseInt(tmp));
			
			// 연산자 - 이면 
			if(s.charAt(i) == '-') {
				while( !s2.isEmpty() ) {
					// 스택에 들어있는 + 연산자 계산
					if(s2.peek() != '-') {
						s2.pop();
						int a = s1.pop(), b = s1.pop();
						s1.push(a + b);
					} else break;
				}
				s2.push(s.charAt(i));
			}
			else if(s.charAt(i) == '+')
				s2.push(s.charAt(i));
		}
		// 마지막 + 연산  -> 스택에는 - 연산자만 남아있음
		while(!s2.isEmpty()) {
			if(s2.peek() == '+') {
				s2.pop();
				int op1 = s1.pop(), op2 = s1.pop();
				s1.push(op2 + op1);
			} else break;
		}
		// 최종 출력
		int result = s1.get(0);
		for(int i=1; i<s1.size(); ++i)
			result -= s1.get(i);
		System.out.println(result);
	}
}
