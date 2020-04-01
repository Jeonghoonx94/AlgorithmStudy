import java.util.Scanner;
import java.util.Stack;

public class Algorithm_1223 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			int length = sc.nextInt();
			String s = sc.next();
			
			String f2p = convert(s, length);
			int result = calculate(f2p);
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
	
	static int priority (char c) {
		if(c == '*')
			return 2;
		else if(c == '+')
			return 1;
		else
			return 0;
	}
	
	static String convert(String s, int length) {
		Stack<Character> stack = new Stack<>();
		String result = new String();
		
		for(int i=0; i<length; ++i) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {	//	피연산자이면
				result += c;
			} else {	// 연산자이면
				if(stack.isEmpty()) {	// 스택이 비어있으면
					stack.push(c);
				} else if(priority(c) > priority(stack.peek())) {	// 토큰의 우선순위가 Stack top보다 높으면
					stack.push(c);
//				} else if(priority(c) <= priority(stack.peek())) {	// 토큰의 우선순위가 Stack top보다 작거나 같으면
				} else {
					while(!stack.isEmpty() && ( priority(c) <= priority(stack.peek()) ) )	// 토큰의 우선순위가 top보다 작거나 같을동안
							result += stack.pop();
					stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) {	// Stack의 남아있는 연산자 출력
			result += stack.pop();
		}
		stack.clear();
		return result;
	}
	
	static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			if(c == '+' || c == '*') {	// 연산자
				int a = stack.pop();
				int b = stack.pop();
				switch(c) {
					case '+':
						stack.push(b+a);
						break;
					case '*':
						stack.push(b*a);
						break;
				}
			} else {	// 피연산자
				stack.push(c - '0');
			}
		}
		int result = stack.pop();
		stack.clear();
		return result;
	}
}